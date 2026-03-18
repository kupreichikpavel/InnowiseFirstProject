package main.com.innowise.arraymanager;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import main.com.innowise.arraymanager.parser.impl.EntityParserImpl;
import main.com.innowise.arraymanager.reader.impl.ArrayFileImpl;
import main.com.innowise.arraymanager.service.impl.AverageCalculatorImpl;
import main.com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import main.com.innowise.arraymanager.service.impl.ArraySortImpl;
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
        EntityAnalyzerImpl minMaxService = new EntityAnalyzerImpl();
        AverageCalculatorImpl averageService = new AverageCalculatorImpl();
        ArrayValidator validatorService = new ArrayValidator();
        EntityParserImpl parserLineToArray = new EntityParserImpl();
        EntityFactoryImpl entityFactory = new EntityFactoryImpl();


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
        for (Entity entity : entityList) {
            try {
                sortService.bubbleSort(entity);
                System.out.println(minMaxService.sum(entity));
                System.out.println("averageService.findAverageElement(entity) = " + averageService.findAverageElement(entity));
                System.out.println(entity);
            } catch (EntityException e) {
                logger.warn(e);
            }
        }
    }
}