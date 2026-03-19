package test.com.innowise.kupreychik;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import main.com.innowise.arraymanager.repository.impl.EntityRepositoryImpl;
import main.com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import main.com.innowise.arraymanager.service.impl.ArraySortImpl;
import main.com.innowise.arraymanager.service.impl.EntityStatisticsCalculatorImpl;
import main.com.innowise.arraymanager.singleton.EntityParameters;
import main.com.innowise.arraymanager.singleton.WareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class AppTest {
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
        assertEquals(0, expected.getArray().length);
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
    @Test
    void calculateShouldReturnCorrectStatistics() throws EntityException {
        Entity entity = new Entity(new int[]{1, 2, 3, 4});
        EntityStatisticsCalculatorImpl calculator = new EntityStatisticsCalculatorImpl();

        EntityParameters parameters = calculator.calculate(entity);

        assertEquals(10, parameters.getSum());
        assertEquals(2, parameters.getAverage());
        assertEquals(1, parameters.getMin());
        assertEquals(4, parameters.getMax());
    }
    @Test
    void getInstanceShouldReturnSameObject() {
        WareHouse first = WareHouse.getInstance();
        WareHouse second = WareHouse.getInstance();

        assertSame(first, second);
    }

    @Test
    void putAndGetShouldWorkCorrectly() {
        WareHouse wareHouse = WareHouse.getInstance();
        EntityParameters parameters = new EntityParameters(10, 2, 1, 4);

        wareHouse.put(1000, parameters);

        assertEquals(parameters, wareHouse.get(1000));
    }

    @Test
    void removeShouldDeleteParameters() {
        WareHouse wareHouse = WareHouse.getInstance();
        EntityParameters parameters = new EntityParameters(10, 2, 1, 4);

        wareHouse.put(2000, parameters);
        wareHouse.remove(2000);

        assertNull(wareHouse.get(2000));
    }
    @Test
    void getInstanceShouldReturnSameRepository() {
        EntityRepositoryImpl first = EntityRepositoryImpl.getInstance();
        EntityRepositoryImpl second = EntityRepositoryImpl.getInstance();

        assertSame(first, second);
    }

    @Test
    void addShouldStoreEntity() {
        EntityRepositoryImpl repository = EntityRepositoryImpl.getInstance();
        Entity entity = new Entity(new int[]{1, 2, 3});

        repository.add(entity);

        List<Entity> entities = repository.getEntities();

        assertTrue(entities.contains(entity));
    }

    @Test
    void removeShouldDeleteEntity() {
        EntityRepositoryImpl repository = EntityRepositoryImpl.getInstance();
        Entity entity = new Entity(new int[]{4, 5, 6});

        repository.add(entity);
        repository.remove(entity);

        assertFalse(repository.getEntities().contains(entity));
    }

    @Test
    void getEntitiesShouldReturnCopy() {
        EntityRepositoryImpl repository = EntityRepositoryImpl.getInstance();
        List<Entity> list = repository.getEntities();

        int originalSize = list.size();
        list.clear();

        assertNotEquals(0, repository.getEntities().size() == originalSize ? 1 : 0);
    }

}