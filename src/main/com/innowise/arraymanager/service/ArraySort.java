package com.innowise.arraymanager.service;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;

public interface ArraySort {
    void bubbleSort(Entity array) throws EntityException;

    void quickSort(Entity array) throws EntityException;
}
