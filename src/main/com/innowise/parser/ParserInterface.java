package main.com.innowise.parser;

import main.com.innowise.exception.EntityException;

public interface ParserInterface {
    int[] parseToIntArray(String lines) throws EntityException;
}


