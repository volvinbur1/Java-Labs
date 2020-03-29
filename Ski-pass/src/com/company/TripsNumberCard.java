package com.company;

public class TripsNumberCard extends PassCard {
    public int leftTrips;
    public TripsNumberCard(int identifier, CardType type, int leftTrips) {
        super(identifier, type);
        this.leftTrips = leftTrips;
    }

//    public ValidationResult Validate() {
//        if (isActive && leftTrips > 0) {
//            leftTrips--;
//            if (type == CardType.SPECIAL)
//                return ValidationResult.VALIDATED_SPECIAL;
//            return ValidationResult.VALIDATED;
//        }
//        return ValidationResult.NOT_VALIDATED;
//    }

    @Override
    public String toString() {
        String returnValue = "Card Identifier\t" + identifier + "\n";
        returnValue += "Card Kind\tTripsNumberCard\n";
        returnValue += "Card Type\t" + type + "\n";
        returnValue += "Number of trios that left\t" + leftTrips + "\n";
        returnValue += "Number of Refusals\t" + refusals + "\n";
        returnValue += "Card is active\t" + isActive;
        return returnValue;
    }
}
