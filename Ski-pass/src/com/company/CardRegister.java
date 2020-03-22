package com.company;

import java.time.LocalDate;
import java.util.Map;

public class CardRegister {
    public Map<Integer, PassCard> RegisteredCard;

    public int RegisterNewCard(PassCard.CardType type, PassCard.CardKind kind, int trips, LocalDate expiredAt) {
        int identifier;
        identifier = RegisteredCard.size();
        PassCard card = new PassCard(identifier, type, kind, trips, expiredAt);
        RegisteredCard.put(identifier, card);
        return identifier;
    }

    public void DeactivateCard(int identifier) {
        PassCard object = RegisteredCard.get(identifier);
        if (object != null) {
            object.IsActive = false;
            RegisteredCard.put(identifier, object);
        }
    }

    public void ActivateCard(int identifier) {
        PassCard object = RegisteredCard.get(identifier);
        if (object != null) {
            object.IsActive = true;
            RegisteredCard.put(identifier, object);
        }
    }

    public void PrintCardInfo(int identifier) {
        System.out.println(RegisteredCard.get(identifier).toString());
    }
}
