package main.com.innowise.arraymanager.reader;

import main.com.innowise.arraymanager.exception.EntityException;

import java.util.List;

public interface ArrayReader {
    List<String> read(String path) throws EntityException;
}
