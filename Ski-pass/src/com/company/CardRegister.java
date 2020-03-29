package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CardRegister {
    public Map<Integer, PassCard> RegisteredCard = new HashMap<>();

    public int RegisterValidityCard(PassCard.CardType type, ValidityCard.CardValidityType validityType, int availableDays) {
        if (availableDays <= 0)
            return -1;
        int identifier = RegisteredCard.size() + 1;
        PassCard card = new ValidityCard(identifier, type, validityType, availableDays);
        RegisteredCard.put(identifier, card);
        return identifier;
    }

    public int RegisterTripsNumberCard(PassCard.CardType type, int availableTripsNumber) {
        if (availableTripsNumber <= 0)
            return -1;
        int identifier = RegisteredCard.size() + 1;
        PassCard card = new TripsNumberCard(identifier, type, availableTripsNumber);
        RegisteredCard.put(identifier, card);
        return identifier;
    }

    public void DeactivateCard(int identifier) {
        PassCard object = RegisteredCard.get(identifier);
        if (object != null)
            object.DeactivateCard();
    }

    public void ActivateCard(int identifier) {
        PassCard object = RegisteredCard.get(identifier);
        if (object != null)
            object.ActivateCard();
    }

    public void PrintCardInfo(int identifier) {
        System.out.println(RegisteredCard.get(identifier).toString());
    }
}
