package test.com.innowise.kupreychik;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.factory.impl.EntityFactory;
import main.com.innowise.service.impl.MinMaxService;
import main.com.innowise.service.impl.SortService;
import main.com.innowise.service.impl.SumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class AppTest {
    private static final Logger logger = LogManager.getLogger(AppTest.class);
    private static final EntityFactory factory = new EntityFactory();
    private final SortService sortService = new SortService();
    private final SumService sumService = new SumService();
    private final MinMaxService minMaxService = new MinMaxService();

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

        int actual = sumService.sum(entity);

        assertEquals(expected, actual);
    }
}