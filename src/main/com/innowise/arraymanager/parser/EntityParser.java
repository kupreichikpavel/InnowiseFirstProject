package main.com.innowise.arraymanager.parser;

import main.com.innowise.arraymanager.exception.EntityException;

public interface EntityParser {
    int[] parseToIntArray(String lines) throws EntityException;

    String VALID_SYMBOLS = "[.,!?;:()]";
    String SPACE_SYMBOL = " ";
}


