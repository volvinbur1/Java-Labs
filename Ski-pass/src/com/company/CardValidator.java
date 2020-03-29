package com.company;

import java.time.LocalTime;

public class CardValidator {
    enum ValidationResult {
        NOT_VALIDATED,
        VALIDATED,
        VALIDATED_SPECIAL // this one is used when pass card is validated for person from special group (etc. Students or retirees)
    }

    public static ValidationResult Validate(PassCard passCard) {
        if (passCard == null)
            return ValidationResult.NOT_VALIDATED;

        if (!passCard.isActive)
            return ValidationResult.NOT_VALIDATED;
        if (passCard instanceof ValidityCard)
            return validateValidityCard((ValidityCard) passCard);
        if (passCard instanceof TripsNumberCard)
            return validateTripsNumberCard((TripsNumberCard) passCard);
        return ValidationResult.NOT_VALIDATED;
    }

    public static ValidationResult validateTripsNumberCard(TripsNumberCard passCard) {
        if (passCard.isActive && passCard.leftTrips > 0) {
            passCard.leftTrips--;
            if (passCard.type == PassCard.CardType.SPECIAL)
                return ValidationResult.VALIDATED_SPECIAL;
            return ValidationResult.VALIDATED;
        }
        return ValidationResult.NOT_VALIDATED;
    }

    private static ValidationResult validateValidityCard(ValidityCard passCard) {
        int hourNow = LocalTime.now().getHour();
        if (passCard.validityType == ValidityCard.CardValidityType.EVENING && hourNow >= 14 && hourNow < 19) {
            if (verifyLeftDays(passCard)) {
                if (passCard.type == PassCard.CardType.SPECIAL)
                    return ValidationResult.VALIDATED_SPECIAL;
                return ValidationResult.VALIDATED;
            }
        }

        if (passCard.validityType == ValidityCard.CardValidityType.NIGHTLY && hourNow >= 19) {
            if (verifyLeftDays(passCard)) {
                if (passCard.type == PassCard.CardType.SPECIAL)
                    return ValidationResult.VALIDATED_SPECIAL;
                return ValidationResult.VALIDATED;
            }
        }
        return ValidationResult.NOT_VALIDATED;
    }

    private static boolean verifyLeftDays(ValidityCard passCard) {
        if (passCard.leftDays > 0) {
            passCard.leftDays--;
            return true;
        }
        return false;
    }
}
