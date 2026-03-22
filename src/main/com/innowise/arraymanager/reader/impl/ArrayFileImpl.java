package com.innowise.arraymanager.reader.impl;

import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Path.of;


public class ArrayFileImpl implements ArrayReader {

    private static final Logger logger = LogManager.getLogger(ArrayFileImpl.class);

    @Override
    public List<String> read(String path) throws EntityException {

        if (path == null) {
            logger.error("Path is null");
            throw new EntityException("File path cannot be null");
        }
        try (Stream<String> lines = lines(of(path))) {
            List<String> result = lines
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                throw new EntityException("File is empty: " + path);
            }

            return result;
        } catch (Exception e) {
            throw new EntityException("Error reading file: " + path);
        }
    }
}
