package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRegisterTest {

    @Test
    void PassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 6);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertEquals(passed, CardValidator.ValidationResult.VALIDATED);
    }

    @Test
    void NOTPassingByCardWithTimeOfDayKind() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 0);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertNotEquals(passed, CardValidator.ValidationResult.VALIDATED);
    }

    @Test
    void PassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 3);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertEquals(passed, CardValidator.ValidationResult.VALIDATED);
    }

    @Test
    void NOTPassingByCardWith_BY_TRIPS_Kind() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 0);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertNotEquals(passed, CardValidator.ValidationResult.VALIDATED);
    }

    @Test
    void NOTPassingDeactivatedCard() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 6);
        register.DeactivateCard(identifier);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertNotEquals(passed, CardValidator.ValidationResult.VALIDATED);
    }

    @Test
    void PassingByCardWithTimeOfDayKind_For_SPECIAL_Type() {
        CardRegister register = new CardRegister();
        //results depends on the current time of day
        int identifier = register.RegisterNewCard(PassCard.CardType.SPECIAL, PassCard.CardKind.NIGHTLY, 6);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertEquals(passed, CardValidator.ValidationResult.VALIDATED_SPECIAL);
    }

    @Test
    void PassingByCardWith_BY_TRIPS_Kind_For_SPECIAL_Type() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.SPECIAL, PassCard.CardKind.BY_TRIPS, 3);
        CardValidator.ValidationResult passed = CardValidator.Validate(identifier, register);

        assertEquals(passed, CardValidator.ValidationResult.VALIDATED_SPECIAL);
    }

    @Test
    void CheckingActivatedCardState() {
        CardRegister register = new CardRegister();
        int identifier = register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_TRIPS, 6);
        register.DeactivateCard(identifier);
        register.ActivateCard(identifier);

        assertTrue(register.RegisteredCard.get(identifier).IsActive);
    }

    @Test
    void ChangingTripsLeftNumber() {
        CardRegister register = new CardRegister();
        int numberOfTripsBeforeSet = 3;
        int identifier = register.RegisterNewCard(PassCard.CardType.SPECIAL, PassCard.CardKind.BY_TRIPS, numberOfTripsBeforeSet);
        int numberOfTripsToSet = 10;
        register.RegisteredCard.get(identifier).AddTrips(numberOfTripsToSet);

        assertEquals(register.RegisteredCard.get(identifier).TripsNumberLeft, numberOfTripsToSet + numberOfTripsBeforeSet);
    }
}