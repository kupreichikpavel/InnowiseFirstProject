package test.com.innowise.kupreychik;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import main.com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import main.com.innowise.arraymanager.service.impl.ArraySortImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class AppTest {
    private static final Logger logger = LogManager.getLogger(AppTest.class);
    private static final EntityFactoryImpl factory = new EntityFactoryImpl();
    private final ArraySortImpl sortService = new ArraySortImpl();
    private final EntityAnalyzerImpl minMaxService = new EntityAnalyzerImpl();

    @Test
    void testCreateEntityWithValidArray() {
        int[] actual = {5, 2, 9};
        Entity expected = factory.createEntity(actual);
        assertNotNull(expected); // объект создан
        assertArrayEquals(actual, expected.getArray()); // массив совпадает
    }

    @Test
    void testCreateEmptyEntity() {
        Entity expected = factory.createEmptyEntity();
        assertNotNull(expected); // объект создан
        assertEquals(0, expected.getArray().length); // массив пустой
    }

    @Test
    void testCreateEntityWithEmptyArray() {
        int[] actual = {};
        Entity expected = factory.createEntity(actual);
        assertNotNull(expected);
        assertEquals(0, expected.getArray().length); // массив пустой, но объект создан
    }

    @Test
    void testFindMinNormalArray() throws EntityException {
        Entity entity = new Entity(new int[]{5, 2, 9, 1});
        int expected = 1;
        int actual = minMaxService.findMin(entity);
        assertEquals(expected, actual);
    }

    @Test
    void testFindMaxNormalArray() throws EntityException {
        Entity entity = new Entity(new int[]{5, 2, 9, 1});
        int expected = 9;
        int actual = minMaxService.findMax(entity);
        assertEquals(expected, actual);
    }

    @Test
    void testBubbleSortNormalArray() throws EntityException {
        Entity entity = new Entity(new int[]{5, 1, 4, 2});
        int[] expected = {1, 2, 4, 5};

        sortService.bubbleSort(entity);

        int[] actual = entity.getArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testQuickSortNormalArray() throws EntityException {
        Entity entity = new Entity(new int[]{5, 1, 4, 2});
        int[] expected = {1, 2, 4, 5};

        sortService.quickSort(entity);

        int[] actual = entity.getArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSumSingleElement() {
        Entity entity = new Entity(new int[]{5});
        int expected = 5;

        int actual = minMaxService.sum(entity);

        assertEquals(expected, actual);
    }
}