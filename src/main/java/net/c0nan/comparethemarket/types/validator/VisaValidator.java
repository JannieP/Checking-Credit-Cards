package net.c0nan.comparethemarket.types.validator;

import net.c0nan.comparethemarket.types.AbstractCardValidator;
import net.c0nan.comparethemarket.types.CardTypeValidator;

public class VisaValidator extends AbstractCardValidator implements CardTypeValidator {
    /*
    * Starts with 4, then any 12, then a group of 3 optional digits
    * Total 13 or 16 digits
    */
    public static final String VALIDATOR_ISA_PATTERN = "^4[0-9].*$";
    public static final String VALIDATOR_REGEX_PATTERN = "^4[0-9]{12}(?:[0-9]{3})?$";

    @Override
    protected String getValidatorPattern() {
        return VALIDATOR_REGEX_PATTERN;
    }

    @Override
    protected String getIsAPattern() {
        return VALIDATOR_ISA_PATTERN;
    }

}
