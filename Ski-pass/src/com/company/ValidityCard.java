package com.company;

import java.time.LocalTime;

public class ValidityCard extends PassCard{
    enum CardValidityType{
        DAILY, EVENING, NIGHTLY
    }

    public CardValidityType validityType;
    public int leftDays;
    public ValidityCard(int identifier, CardType type, CardValidityType validityType, int leftDays){
        super(identifier, type);
        this.validityType = validityType;
        this.leftDays = leftDays;
    }

    public ValidationResult Validate() {
        if (!isActive)
            return ValidationResult.NOT_VALIDATED;

        int hourNow = LocalTime.now().getHour();
        if (validityType == CardValidityType.DAILY && hourNow >= 9 && hourNow < 14) {
            if (verifyLeftDays()) {
                if (type == CardType.SPECIAL)
                    return ValidationResult.VALIDATED_SPECIAL;
                return ValidationResult.VALIDATED;
            }
        }

        if (validityType == CardValidityType.EVENING && hourNow >= 14 && hourNow < 19) {
            if (verifyLeftDays()) {
                if (type == CardType.SPECIAL)
                    return ValidationResult.VALIDATED_SPECIAL;
                return ValidationResult.VALIDATED;
            }
        }

        if (validityType == CardValidityType.NIGHTLY && hourNow >= 19) {
            if (verifyLeftDays()) {
                if (type == CardType.SPECIAL)
                    return ValidationResult.VALIDATED_SPECIAL;
                return ValidationResult.VALIDATED;
            }
        }

        return ValidationResult.NOT_VALIDATED;
    }

    private boolean verifyLeftDays() {
        if (leftDays > 0) {
            leftDays--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String returnValue = "Card Identifier\t" + identifier + "\n";
        returnValue += "Card Kind\tValidityCard\n";
        returnValue += "Card validity type\t" + validityType + "\n";
        returnValue += "Card Type\t" + type + "\n";
        returnValue += "Expire date\t" + leftDays + "\n";
        returnValue += "Number of Refusals\t" + refusals + "\n";
        returnValue += "Card is active\t" + isActive;
        return returnValue;
    }
}
