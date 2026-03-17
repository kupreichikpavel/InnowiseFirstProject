package main.com.innowise.service.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.factory.impl.EntityFactory;
import main.com.innowise.service.SortInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SortService implements SortInterface {
    private static final Logger logger = LogManager.getLogger(EntityFactory.class);

    @Override
    public void bubbleSort(Entity entity) throws EntityException {
        logger.info("Choose bubble sort ");
        int[] arr = entity.getArray();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        entity.setArray(arr);
    }

    @Override
    public void quickSort(Entity entity) throws EntityException {
        logger.info("Choose quick sort ");
        int[] array = entity.getArray();
        quickSort(array, 0, array.length - 1);
        entity.setArray(array);
    }

    private void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
