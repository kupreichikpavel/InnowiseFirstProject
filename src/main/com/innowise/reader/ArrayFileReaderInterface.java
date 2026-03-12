package main.com.innowise.reader;

import main.com.innowise.exception.EntityException;

import java.io.IOException;
import java.util.List;

public interface ArrayFileReaderInterface {
    List<String> read(String path) throws IOException, EntityException;
}
