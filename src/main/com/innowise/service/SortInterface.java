package main.com.innowise.service;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;

public interface SortInterface {
    void bubbleSort(Entity array) throws EntityException;

    void quickSort(Entity array) throws EntityException;
}
