package com.company;

public class Main {
    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        int make_inactive_id = register.RegisterTripsNumberCard(PassCard.CardType.STANDARD, 3);
        register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.NIGHTLY, 5);
        register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.NIGHTLY, 1);
        register.DeactivateCard(make_inactive_id);

        for (int i = 0; i < 5; i++) {
            register.RegisteredCard.forEach((k, v) -> {
                CardValidator.ValidationResult passed = CardValidator.Validate(v);
                if (passed ==   CardValidator.ValidationResult.VALIDATED) System.out.println("Card " + k + " is validated.");
                else if (passed ==   CardValidator.ValidationResult.VALIDATED_SPECIAL) System.out.println("Card " + k + " is validated but documents should be checked");
                else System.out.println("Card " + k + " is not validated.");
            });
        }
    }
}
