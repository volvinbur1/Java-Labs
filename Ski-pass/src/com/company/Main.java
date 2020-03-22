package com.company;

public class Main {

    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        //register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.DAILY, 3);
        //register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.EVENING, 3);
        register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 3);
        register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 5);
        register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 1);

        for (int i = 0; i < 5; i++) {
            register.RegisteredCard.forEach((k, v) -> {
                CardValidator.ValidationResult passed = CardValidator.Validate(k, register);
                if (passed ==  CardValidator.ValidationResult.VALIDATED) System.out.println("Card " + k + " is validated.");
                else if (passed ==  CardValidator.ValidationResult.VALIDATED_SPECIAL) System.out.println("Card " + k + " is validated but documents should be checked");
                else System.out.println("Card " + k + " is not validated.");
            });
        }

    }
}
