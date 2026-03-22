package com.innowise.arraymanager.validator;

public interface Validator {
    boolean isValidate(String line);

    String NUMBER_REGEX = "^[0-9\\s,;\\-]*$";

}
