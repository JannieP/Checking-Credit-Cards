package net.c0nan.comparethemarket.types.validator;

import net.c0nan.comparethemarket.types.AbstractCardValidator;
import net.c0nan.comparethemarket.types.CardTypeValidator;

public class MasterCardValidator extends AbstractCardValidator implements CardTypeValidator {
    /*
    * Starts with 5,then 1-5 , then any 14 digits
    * Total 16 digits
    */
    public static final String VALIDATOR_REGEX_PATTERN = "^5[1-5][0-9]{14}$";
    public static final String VALIDATOR_ISA_PATTERN = "^5[1-5][0-9]{14}$";

    @Override
    protected String getValidatorPattern() {
        return VALIDATOR_REGEX_PATTERN;
    }

    @Override
    protected String getIsAPattern() {
        return VALIDATOR_ISA_PATTERN;
    }

}
