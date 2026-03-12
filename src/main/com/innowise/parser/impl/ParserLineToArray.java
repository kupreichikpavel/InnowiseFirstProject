package main.com.innowise.parser.impl;

import main.com.innowise.exception.EntityException;
import main.com.innowise.parser.ParserInterface;
import main.com.innowise.validator.impl.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static main.com.innowise.consts.Consts.*;

public class ParserLineToArray implements ParserInterface {
    private static final Logger logger = LogManager.getLogger(ParserLineToArray.class);
    private static final ValidatorService validator = new ValidatorService();

    @Override
    public int[] parseToIntArray(String line) throws EntityException {

        logger.info("Parsing line to array of integer numbers");

        if (line == null || line.trim().isEmpty()) {
            logger.error("Line is null or empty");
            throw new EntityException("Input line is null or empty");
        }

        if (!validator.isValidate(line)) {
            logger.error("Line validation failed: {}", line);
            throw new EntityException("Invalid line format");
        }

        line = line.replaceAll(VALID_SYMBOLS, SPACE_SYMBOL).trim();

        if (line.isEmpty()) {
            logger.error("Line contains no valid numbers");
            throw new EntityException("Line contains no valid numbers");
        }

        String[] strNumbers = line.split("\\s+");
        int[] intArray = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            intArray[i] = Integer.parseInt(strNumbers[i]);
        }

        logger.info("Successful parsing to IntArray");

        return intArray;
    }
}