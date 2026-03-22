package com.innowise.arraymanager;

import com.innowise.arraymanager.comparator.EntityIdComparator;
import com.innowise.arraymanager.comparator.EntitySumComparator;
import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.factory.EntityFactory;
import com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import com.innowise.arraymanager.observer.EntityObserver;
import com.innowise.arraymanager.observer.impl.EntityStatisticsObserver;
import com.innowise.arraymanager.parser.EntityParser;
import com.innowise.arraymanager.parser.impl.EntityParserImpl;
import com.innowise.arraymanager.reader.ArrayReader;
import com.innowise.arraymanager.reader.impl.ArrayFileImpl;
import com.innowise.arraymanager.repository.EntityRepository;
import com.innowise.arraymanager.repository.impl.EntityRepositoryImpl;
import com.innowise.arraymanager.service.ArraySort;
import com.innowise.arraymanager.service.AverageCalculator;
import com.innowise.arraymanager.service.EntityAnalyzer;
import com.innowise.arraymanager.service.EntityStatisticsCalculator;
import com.innowise.arraymanager.service.impl.AverageCalculatorImpl;
import com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import com.innowise.arraymanager.service.impl.ArraySortImpl;
import com.innowise.arraymanager.service.impl.EntityStatisticsCalculatorImpl;
import com.innowise.arraymanager.singleton.WareHouse;
import com.innowise.arraymanager.specification.Specification;
import com.innowise.arraymanager.specification.impl.SpecificationBySumGreaterThan;
import com.innowise.arraymanager.validator.impl.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ArraySort sortService = new ArraySortImpl();
        ArrayReader fileReader = new ArrayFileImpl();
        EntityAnalyzer service = new EntityAnalyzerImpl();
        AverageCalculator averageService = new AverageCalculatorImpl();
        ArrayValidator validatorService = new ArrayValidator();
        EntityParser parserLineToArray = new EntityParserImpl();
        EntityFactory entityFactory = new EntityFactoryImpl();
        EntityObserver entityStatisticsObserver = new EntityStatisticsObserver();
        EntityStatisticsCalculator entityStatisticsCalculator = new EntityStatisticsCalculatorImpl();
        EntityRepository repository = EntityRepositoryImpl.getInstance();
        Specification specification = new SpecificationBySumGreaterThan(12);

        List<String> values = new ArrayList<>();
        try {
            values = fileReader.read("/Users/alexey/IdeaProjects/InnowiseFirstProject/src/main/resources/arrays.txt");
        } catch (EntityException e) {
            logger.warn("Error reading file:" + e);
        }

        List<Entity> entityList = values.stream().filter(validatorService::isValidate).flatMap(line -> {
            try {
                int[] array = parserLineToArray.parseToIntArray(line);
                return Stream.of(entityFactory.createEntity(array));
            } catch (EntityException e) {
                logger.warn("Parsing error: {}", line, e);
                return Stream.empty();
            }
        }).toList();

        System.out.println("--------------");
        for (Entity entity : entityList) {
            repository.add(entity);
        }

        for (Entity entity : entityList) {
            System.out.println(WareHouse.getInstance().get(entity.getId()));
        }

        //  entityList.get(0) .setElement(1, 200);

        System.out.println("\n=== Specification (sum > 12) ===");

        List<Entity> filtered = repository.query(specification);

        filtered.forEach(System.out::println);

        System.out.println("\n=== Sort by ID ===");

        List<Entity> sortedById = repository.sort(new EntityIdComparator());
        sortedById.forEach(System.out::println);

        System.out.println("\n=== Sort by SUM ===");

        List<Entity> sortedBySum = repository.sort(new EntitySumComparator());
        sortedBySum.forEach(System.out::println);
    }
}
