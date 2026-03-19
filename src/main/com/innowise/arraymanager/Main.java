package main.com.innowise.arraymanager;

import main.com.innowise.arraymanager.comparator.EntityIdComparator;
import main.com.innowise.arraymanager.comparator.EntitySumComparator;
import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import main.com.innowise.arraymanager.observer.impl.EntityStatisticsObserver;
import main.com.innowise.arraymanager.parser.impl.EntityParserImpl;
import main.com.innowise.arraymanager.reader.impl.ArrayFileImpl;
import main.com.innowise.arraymanager.repository.impl.EntityRepositoryImpl;
import main.com.innowise.arraymanager.service.impl.AverageCalculatorImpl;
import main.com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import main.com.innowise.arraymanager.service.impl.ArraySortImpl;
import main.com.innowise.arraymanager.service.impl.EntityStatisticsCalculatorImpl;
import main.com.innowise.arraymanager.singleton.WareHouse;
import main.com.innowise.arraymanager.specification.Specification;
import main.com.innowise.arraymanager.specification.impl.SpecificationBySumGreaterThan;
import main.com.innowise.arraymanager.validator.impl.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ArraySortImpl sortService = new ArraySortImpl();
        ArrayFileImpl fileReader = new ArrayFileImpl();
        EntityAnalyzerImpl service = new EntityAnalyzerImpl();
        AverageCalculatorImpl averageService = new AverageCalculatorImpl();
        ArrayValidator validatorService = new ArrayValidator();
        EntityParserImpl parserLineToArray = new EntityParserImpl();
        EntityFactoryImpl entityFactory = new EntityFactoryImpl();
        EntityStatisticsObserver entityStatisticsObserver = new EntityStatisticsObserver();
        EntityStatisticsCalculatorImpl entityStatisticsCalculator = new EntityStatisticsCalculatorImpl();
        EntityRepositoryImpl repository = EntityRepositoryImpl.getInstance();
        Specification specification = new SpecificationBySumGreaterThan(12);

        List<String> values = new ArrayList<>();
        try {
            values = fileReader.read("/Users/alexey/IdeaProjects/InnowiseFirstProject/src/resources/arrays.txt");
        } catch (EntityException e) {
            logger.warn("Error reading file:" + e);
        }

        List<Entity> entityList = values.stream()
                .filter(validatorService::isValidate)
                .flatMap(line -> {
                    try {
                        int[] array = parserLineToArray.parseToIntArray(line);
                        return Stream.of(entityFactory.createEntity(array));
                    } catch (EntityException e) {
                        logger.warn("Parsing error: {}", line, e);
                        return Stream.empty();
                    }
                })
                .toList();

        System.out.println("--------------");

// 1. добавляем все entity
        for (Entity entity : entityList) {
            repository.add(entity);
        }

// 2. проверяем warehouse
        for (Entity entity : entityList) {
            System.out.println(WareHouse.getInstance().get(entity.getId()));
        }

// 3. изменяем один объект (проверка observer)
        entityList.get(0).setElement(1, 200);

// 4. Specification
        System.out.println("\n=== Specification (sum > 15) ===");

        Specification spec = new SpecificationBySumGreaterThan(15);
        List<Entity> filtered = repository.query(spec);

        filtered.forEach(System.out::println);

// 5. Comparator
        System.out.println("\n=== Sort by ID ===");

        List<Entity> sortedById = repository.sort(new EntityIdComparator());
        sortedById.forEach(System.out::println);

        System.out.println("\n=== Sort by SUM ===");

        List<Entity> sortedBySum = repository.sort(new EntitySumComparator());
        sortedBySum.forEach(System.out::println);
    }
}
