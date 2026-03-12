package main.com.innowise.reader.impl;

import main.com.innowise.exception.EntityException;
import main.com.innowise.reader.ArrayFileReaderInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayFileReader implements ArrayFileReaderInterface {

    private static final Logger logger = LogManager.getLogger(ArrayFileReader.class);

    @Override
    public List<String> read(String path) throws EntityException {

        if (path == null) {
            logger.error("Path is null");
            throw new EntityException("File path cannot be null");
        }

        try (Stream<String> lines = Files.lines(Path.of(path))) {
            List<String> result = lines
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                logger.error("File is empty: {}", path);
                throw new EntityException("File is empty: " + path);
            }
            return result;
        } catch (IOException e) {
            throw new EntityException("Error of Reading File:" + path);
        }

    }
}

