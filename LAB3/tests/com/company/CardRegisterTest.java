package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRegisterTest {

    @Test
    void PassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.NIGHTLY, 6);
        PassCard passCard = register.RegisteredCard.get(identifier);
        boolean passed = CardValidator.Validate(passCard);

        assertTrue(passed);
    }
    
    @Test
    void NOTPassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.NIGHTLY, 0);
        PassCard passCard = register.RegisteredCard.get(identifier);
        boolean passed = CardValidator.Validate(passCard);

        assertFalse(passed);
    }

    @Test
    void PassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterTripsNumberCard(PassCard.CardType.STANDARD, 5);
        PassCard passCard = register.RegisteredCard.get(identifier);
        boolean passed = CardValidator.Validate(passCard);

        assertTrue(passed);
    }

    @Test
    void NOTPassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterTripsNumberCard(PassCard.CardType.STANDARD, 0);
        PassCard passCard = register.RegisteredCard.get(identifier);
        boolean passed = CardValidator.Validate(passCard);

        assertFalse(passed);
    }

    @Test
    void NOTPassingDeactivatedCard() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterTripsNumberCard(PassCard.CardType.STANDARD, 5);
        PassCard passCard = register.RegisteredCard.get(identifier);
        passCard.DeactivateCard();
        boolean passed = CardValidator.Validate(passCard);

        assertFalse(passed);
    }

    @Test
    void CheckingActivatedCardState() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.NIGHTLY, 6);
        PassCard passCard = register.RegisteredCard.get(identifier);
        passCard.DeactivateCard();
        passCard.ActivateCard();

        assertTrue(register.RegisteredCard.get(identifier).isActive);
    }
}