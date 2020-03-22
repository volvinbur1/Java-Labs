package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRegisterTest {

    @Test
    void PassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 6);
        boolean passed = CardValidator.Validate(identifier, register);
        assertTrue(passed);
    }

    @Test
    void NOTPassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 0);
        boolean passed = CardValidator.Validate(identifier, register);
        assertFalse(passed);
    }

    @Test
    void PassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 3);
        boolean passed = CardValidator.Validate(identifier, register);
        assertTrue(passed);
    }

    @Test
    void NOTPassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 0);
        boolean passed = CardValidator.Validate(identifier, register);
        assertFalse(passed);
    }
}