package com.company;

public class Main {

    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        //register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.DAILY, 3);
        //register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.EVENING, 3);
        register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.NIGHTLY, 3);

        for (int i = 0; i <= 5; i++) {
            register.RegisteredCard.forEach((k, v) -> {
                boolean passed = CardValidator.Validate(k, register);
                if (passed) System.out.println("Card " + k + " is validated.");
                else System.out.println("Card " + k + " is not validated.");
            });
        }

    }
}
