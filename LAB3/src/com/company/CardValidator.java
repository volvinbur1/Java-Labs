package com.company;

import java.util.HashMap;
import java.util.Map;

class ValidationStatistic {
    ValidationStatistic(PassCard card) {CardObject = card;}
    public PassCard CardObject;
    public int PassAllowedNumber = 0;
    public int PassCanceledNumber = 0;
}

public class CardValidator {
    public static Map<Integer, ValidationStatistic> Statistics = new HashMap<>();

    public static boolean Validate(PassCard passCard) {
        if (passCard == null)
            return false;

        ValidationStatistic statForCard;
        if (Statistics.containsKey(passCard.identifier))
            statForCard = Statistics.get(passCard.identifier);
        else {
            statForCard = new ValidationStatistic(passCard);
            Statistics.put(passCard.identifier, statForCard);
        }

        PassCard.ValidationResult cardValidation = passCard.Validate();
        if (cardValidation == PassCard.ValidationResult.NOT_VALIDATED) {
            statForCard.PassCanceledNumber++;
            return false;
        }
        if (cardValidation == PassCard.ValidationResult.VALIDATED_SPECIAL)
            SpecialGroupAlert();

        statForCard.PassAllowedNumber++;
        return true;
    }

    private static void SpecialGroupAlert() {
        System.out.println("Check document. Card from special group was detected.");
    }
    private static boolean verifyLeftDays(ValidityCard passCard) {
        if (passCard.leftDays > 0) {
            passCard.leftDays--;
            return true;
        }
        return false;
    }
}
