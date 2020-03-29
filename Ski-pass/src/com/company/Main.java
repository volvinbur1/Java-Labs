package com.company;

public class Main {

    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        int make_inactive_id = register.RegisterTripsNumberCard(PassCard.CardType.STANDARD, 3);
        register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.EVENING, 5);
        register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.EVENING, 1);
        register.DeactivateCard(make_inactive_id);

        for (int i = 0; i < 5; i++) {
            register.RegisteredCard.forEach((k, v) -> {
                PassCard.ValidationResult passed = v.Validate();
                if (passed ==  PassCard.ValidationResult.VALIDATED) System.out.println("Card " + k + " is validated.");
                else if (passed ==  PassCard.ValidationResult.VALIDATED_SPECIAL) System.out.println("Card " + k + " is validated but documents should be checked");
                else System.out.println("Card " + k + " is not validated.");
            });
        }

    }
}
