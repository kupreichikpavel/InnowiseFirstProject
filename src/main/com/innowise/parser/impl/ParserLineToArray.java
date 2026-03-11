package main.com.innowise.parser.impl;

import main.com.innowise.Main;
import main.com.innowise.parser.ParserInterface;
import main.com.innowise.validator.impl.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.regex.Pattern;

import static main.com.innowise.consts.Consts.*;

public class ParserLineToArray implements ParserInterface {
    private static final Logger logger = LogManager.getLogger(ParserLineToArray.class);
    private static final ValidatorService validator = new ValidatorService();

    @Override
    public int[] parseToIntArray(String line) {

        logger.info("Parsing line to array of integer numbers");
        if (line == null || line.trim().isEmpty() || !validator.isValidate(line)) {
            logger.warn("Line is null, empty or invalid. Return empty array.");
            return new int[0];
        }
        line = line.replaceAll(VALID_SYMBOLS, SPACE_SYMBOL).trim();
        if (line.isEmpty()) {
            return new int[0];
        }

        String[] strNumbers = line.split("\\s+");
        int[] intArray = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            String element = strNumbers[i].trim();

            if (element.matches(NUMBER_REGEX)) {
                intArray[i] = Integer.parseInt(element);
            } else {
                logger.warn("Invalid element found: {}", element);
            }
        }
        logger.info("Successful parsing to IntArray.");
        return intArray;
    }
}