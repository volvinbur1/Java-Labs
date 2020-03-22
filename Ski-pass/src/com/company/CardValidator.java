package com.company;

import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;

public class CardValidator {
    public static boolean Validate(int identifier, CardRegister cardRegisterObject) {
        if (cardRegisterObject == null || identifier < 0)
            return false;

        PassCard passCard = cardRegisterObject.RegisteredCard.get(identifier);

        if (passCard == null)
            return false;

        if (!passCard.IsActive)
            return false;

        if (passCard.DaysLeft == 0)
            return false;

        int hourNow = LocalTime.now().getHour();

        if (passCard.Kind == PassCard.CardKind.DAILY && hourNow >= 9 && hourNow < 14) {
            if (passCard.TripsNumberLeft == 0)
                return false;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return true;
        }

        if (passCard.Kind == PassCard.CardKind.EVENING && hourNow >= 14 && hourNow < 19) {
            if (passCard.TripsNumberLeft == 0)
                return false;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return true;
        }

        if (passCard.Kind == PassCard.CardKind.NIGHTLY && hourNow >= 19) {
            if (passCard.TripsNumberLeft == 0)
                return false;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return true;
        }

        if (passCard.Kind == PassCard.CardKind.BY_TRIPS) {
            if (passCard.TripsNumberLeft == 0)
                return false;
            passCard.TripsNumberLeft--;
            cardRegisterObject.RegisteredCard.put(identifier, passCard);
            return true;
        }

        return false;
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
