package net.c0nan.comparethemarket.types.validator;

import lombok.Data;
import net.c0nan.comparethemarket.types.AbstractCardValidator;
import net.c0nan.comparethemarket.types.CardTypeValidator;

@Data
public class AMEXValidator extends AbstractCardValidator implements CardTypeValidator {

    /*
    * Starts with 3, then 4 or 7, then any 13 digits
    * total 15 digits
    */
    public static final String VALIDATOR_REGEX_PATTERN = "^3[47][0-9]{13}$";
    public static final String VALIDATOR_ISA_PATTERN = "^3[47].*$";

    @Override
    protected String getValidatorPattern() {
        return VALIDATOR_REGEX_PATTERN;
    }

    @Override
    protected String getIsAPattern() {
        return VALIDATOR_ISA_PATTERN;
    }

}
