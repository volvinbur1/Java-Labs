package com.company;

import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;

public class CardValidator {
    //TODO pass CardRegister class object as a reference
    public static boolean Validate(int identifier, CardRegister cardRegisterObject) {
        if (cardRegisterObject == null || identifier < 0)
            return false;

        PassCard passCard = cardRegisterObject.RegisteredCard.get(identifier);

        if (passCard == null)
            return false;

        if (!passCard.IsActive)
            return false;

        int hourNow = LocalTime.now().getHour();

        if (passCard.Kind == PassCard.CardKind.DAILY && hourNow < 9 && hourNow > 14)
            return false;

        if (passCard.Kind == PassCard.CardKind.EVENING && hourNow < 14 && hourNow > 19)
            return false;

        if (passCard.Kind == PassCard.CardKind.DAILY && hourNow < 19)
            return false;

        if (passCard.DaysLeft == 0)
            return false;

        if (passCard.Kind == PassCard.CardKind.BY_TRIPS) {
            if (passCard.TripsNumberLeft == -1)
                return false;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
        }

        return true;
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
