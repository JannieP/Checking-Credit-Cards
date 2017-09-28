package net.c0nan.comparethemarket.types;

import net.c0nan.comparethemarket.CardUtil;
import net.c0nan.comparethemarket.validator.Luhn;

public abstract class AbstractCardValidator {
    protected abstract String getValidatorPattern();

    protected abstract String getIsAPattern();

    public boolean validate(int[] cardDigits) {
        return CardUtil.parseToString(cardDigits).matches(getValidatorPattern()) && Luhn.validate(cardDigits);
    }

    public boolean isA(int[] cardDigits) {
        return CardUtil.parseToString(cardDigits).matches(getIsAPattern());
    }

}
