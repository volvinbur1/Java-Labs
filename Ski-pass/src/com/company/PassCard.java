package com.company;

import java.time.LocalDate;

public class PassCard {
    enum CardKind {
        DAILY, EVENING, NIGHTLY, BY_TRIPS, BY_DAYS_LEFT
    }
    enum CardType {
        STANDARD, SPECIAL, VIP
    }

    public int Identifier;
    public CardType Type;
    public CardKind Kind;
    public int TripsNumberLeft; // for kind BY_TRIPS
    public int DaysLeft; // for other kinds
    public LocalDate Validity; // data when validity ends
    public int Refusals = 0;
    public boolean IsActive = true;

    public PassCard(int identifier, CardType type, CardKind kind, int numberOfTripsOrDays, LocalDate validity) {
        Identifier = identifier;
        Type = type;
        Kind = kind;

        DaysLeft = -1;
        TripsNumberLeft = numberOfTripsOrDays;

        if (kind == CardKind.BY_DAYS_LEFT) {
            DaysLeft = numberOfTripsOrDays;
            TripsNumberLeft = -1;
        }

        Validity = validity;
    }

    public void ChangeValidity(LocalDate newValidity) {
        Validity = newValidity;
    }

    public void AddTrips(int trips) {
        TripsNumberLeft += trips;
    }

    @Override
    public String toString() {
        String returnValue = "Card Identifier\t" + Identifier + "\n";
        returnValue += "Card Type\t" + Type + "\n";
        returnValue += "Card Kind\t" + Kind + "\n";
        returnValue += "Number of trios that left\t" + TripsNumberLeft + "\n";
        returnValue += "Expire date\t" + Validity + "\n";
        returnValue += "Number of Refusals\t" + Refusals + "\n";
        returnValue += "Card is active\t" + IsActive;
        return returnValue;
    }
}
