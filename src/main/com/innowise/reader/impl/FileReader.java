package main.com.innowise.reader.impl;

import main.com.innowise.exception.EntityException;
import main.com.innowise.reader.FileReaderInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements FileReaderInterface {

    private static Logger logger = LogManager.getLogger(FileReader.class);

    @Override
    public List<String> read(String path) {
        if (path == null) {
            logger.error("Path is null");
            throw new EntityException("File path cannot be null");
        }
        try (Stream<String> lines = Files.lines(Path.of(path))) {
            return lines.filter(line -> !line.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new EntityException("Error of Reading File:" + path);
        }

    }
}
