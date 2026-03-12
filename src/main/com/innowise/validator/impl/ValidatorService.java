package main.com.innowise.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.com.innowise.validator.ValidatorInterface;

import java.util.List;

import static main.com.innowise.consts.Consts.NUMBER_REGEX;


public class ValidatorService implements ValidatorInterface {
    private static final Logger logger = LogManager.getLogger(ValidatorService.class);


    @Override
    public boolean isValidate(String line) {
        if (line == null || line.trim().isEmpty()) {
            logger.warn("Line is null or empty");
            return false;
        }

        boolean isMatched = line.matches(NUMBER_REGEX);
        if (!isMatched) {
            logger.warn("Line does not match regex: ", line);
        }

        return isMatched;
    }
}