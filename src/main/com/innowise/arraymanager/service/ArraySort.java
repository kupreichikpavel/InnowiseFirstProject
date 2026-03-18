package main.com.innowise.arraymanager.service;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;

public interface ArraySort {
    void bubbleSort(Entity array) throws EntityException;

    void quickSort(Entity array) throws EntityException;
}
