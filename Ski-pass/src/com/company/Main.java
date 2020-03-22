package com.company;

public class Main {

    public static void main(String[] args) {
        CardRegister register = new CardRegister();
        for (int i = 0; i < 5; i ++) {
            register.RegisterNewCard(PassCard.CardType.STANDARD, PassCard.CardKind.BY_DAYS_LEFT, );
        }
    }
}
