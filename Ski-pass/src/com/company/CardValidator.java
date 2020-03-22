package com.company;

import java.time.LocalTime;

public class CardValidator {
    enum ValidationResult {
        NOT_VALIDATED,
        VALIDATED,
        VALIDATED_SPECIAL // this one is used when pass card is validated for person from special group (etc. Students or retirees)
    }
    public static ValidationResult Validate(int identifier, CardRegister cardRegisterObject) {
        if (cardRegisterObject == null || identifier < 0)
            return ValidationResult.NOT_VALIDATED;

        PassCard passCard = cardRegisterObject.RegisteredCard.get(identifier);

        if (passCard == null)
            return ValidationResult.NOT_VALIDATED;

        if (!passCard.IsActive)
            return ValidationResult.NOT_VALIDATED;

        if (passCard.DaysLeft == 0)
            return ValidationResult.NOT_VALIDATED;

        int hourNow = LocalTime.now().getHour();

        if (passCard.Kind == PassCard.CardKind.DAILY && hourNow >= 9 && hourNow < 14) {
            if (passCard.TripsNumberLeft == 0)
                return ValidationResult.NOT_VALIDATED;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return passCard.Type == PassCard.CardType.SPECIAL ? ValidationResult.VALIDATED_SPECIAL : ValidationResult.VALIDATED;
        }

        if (passCard.Kind == PassCard.CardKind.EVENING && hourNow >= 14 && hourNow < 19) {
            if (passCard.TripsNumberLeft == 0)
                return ValidationResult.NOT_VALIDATED;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return passCard.Type == PassCard.CardType.SPECIAL ? ValidationResult.VALIDATED_SPECIAL : ValidationResult.VALIDATED;
        }

        if (passCard.Kind == PassCard.CardKind.NIGHTLY && hourNow >= 19) {
            if (passCard.TripsNumberLeft == 0)
                return ValidationResult.NOT_VALIDATED;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return passCard.Type == PassCard.CardType.SPECIAL ? ValidationResult.VALIDATED_SPECIAL : ValidationResult.VALIDATED;
        }

        if (passCard.Kind == PassCard.CardKind.BY_TRIPS) {
            if (passCard.TripsNumberLeft == 0)
                return ValidationResult.NOT_VALIDATED;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return passCard.Type == PassCard.CardType.SPECIAL ? ValidationResult.VALIDATED_SPECIAL : ValidationResult.VALIDATED;
        }

        return ValidationResult.NOT_VALIDATED;
    }

    public static void DayRunOut(CardRegister cardRegisterObject) {
        if (cardRegisterObject == null)
            return;

        //TODO look if parameter of foreach loop change pointed element in Enumeration
        for (PassCard card:
             cardRegisterObject.RegisteredCard.values()) {
            if (card.Kind == PassCard.CardKind.BY_DAYS_LEFT) {
                if (card.DaysLeft == 0) {
                    card.IsActive = false;
                        continue;
                }
                card.DaysLeft--;
            }
        }
    }

}
