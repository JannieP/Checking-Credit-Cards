package net.c0nan.comparethemarket;

import net.c0nan.comparethemarket.types.CardTypeValidator;
import net.c0nan.comparethemarket.types.validator.AMEXValidator;
import net.c0nan.comparethemarket.types.validator.DiscoverValidator;
import net.c0nan.comparethemarket.types.validator.MasterCardValidator;
import net.c0nan.comparethemarket.types.validator.VisaValidator;

import java.util.HashMap;
import java.util.Map;

public class CardProcessor {

    static {
        //Default card validators, however more can be added if required
        Map<String, Class<? extends CardTypeValidator>> validatorlist = new HashMap<>();
        validatorlist.put("AMEX", AMEXValidator.class);
        validatorlist.put("Discover", DiscoverValidator.class);
        validatorlist.put("MasterCard", MasterCardValidator.class);
        validatorlist.put("VISA", VisaValidator.class);
        CardValidatorRegistry.addAll(validatorlist);
    }

    public void processCards(String[] cardNumbers) {

        for (String cardNo : cardNumbers) {
            processCard(cardNo);
        }
    }

    public boolean processCard(String cardNo) {
        boolean isASuccess = false;
        boolean success = false;
        int[] cleanCardNo = CardUtil.parseToInt(cardNo.trim().replaceAll(" ", ""));
        for (String validatorKey : CardValidatorRegistry.getValidatorsKeys()) {
            CardTypeValidator validator = CardValidatorRegistry.getValidatorInstance(validatorKey);
            isASuccess = validator.isA(cleanCardNo);
            success = validator.validate(cleanCardNo);
            if (success && isASuccess) {
                System.out.println(String.format("%s: %s (valid)", validatorKey, CardUtil.parseToString(cleanCardNo)));
                break;
            } else if (isASuccess) {
                System.out.println(String.format("%s: %s (invalid)", validatorKey, CardUtil.parseToString(cleanCardNo)));
                break;
            }
        }
        if (!isASuccess) {
            System.out.println(String.format("%s: %s (invalid)", "Unknown", CardUtil.parseToString(cleanCardNo)));
        }
        return success;
    }

}
