package com.company;

public class PassCard {
    enum CardType {
        STANDARD, SPECIAL, VIP
    }

    enum ValidationResult {
        NOT_VALIDATED,
        VALIDATED,
        VALIDATED_SPECIAL // this one is used when pass card is validated for person from special group (etc. Students or retirees)
    }

    protected int identifier;
    protected CardType type;
    protected int refusals = 0;
    protected boolean isActive = true;

    public PassCard(int identifier, CardType type) {
        this.identifier = identifier;
        this.type = type;
    }

    public ValidationResult Validate() {
        if (isActive) {
            if (type == CardType.SPECIAL)
                return ValidationResult.VALIDATED_SPECIAL;
            return ValidationResult.VALIDATED;
        }
        return ValidationResult.NOT_VALIDATED;
    }

    public void ActivateCard() {
        isActive = true;
    }
    public void DeactivateCard() {
        isActive = false;
    }
}
