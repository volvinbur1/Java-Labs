package com.company;

public class Main {
    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        register.RegisterTripsNumberCard(PassCard.CardType.SPECIAL, 3);
        register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.EVENING, 5);
        int make_inactive_id = register.RegisterValidityCard(PassCard.CardType.STANDARD, ValidityCard.CardValidityType.EVENING, 1);
        register.DeactivateCard(make_inactive_id);

        for (int i = 0; i < 5; i++) {
            register.RegisteredCard.forEach((k, v) -> {
                boolean passed = CardValidator.Validate(v);
                if (passed)
                    System.out.println("Pass allowed");
                else
                    System.out.println("Pass not allowed");
            });
        }
    }
}
