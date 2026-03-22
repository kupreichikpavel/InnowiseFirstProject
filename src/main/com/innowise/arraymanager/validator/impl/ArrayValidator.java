package com.innowise.arraymanager.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.innowise.arraymanager.validator.Validator;


public class ArrayValidator implements Validator {
    private static final Logger logger = LogManager.getLogger(ArrayValidator.class);


    @Override
    public boolean isValidate(String line) {
        if (line == null || line.trim().isEmpty()) {
            logger.warn("Line is null or empty");
            return false;
        }
        boolean isMatched = line.matches(NUMBER_REGEX);
        logger.warn("Line does not match regex: {}", line, !isMatched);
        return isMatched;
    }
}