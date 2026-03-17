package main.com.innowise;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.factory.impl.EntityFactory;
import main.com.innowise.parser.impl.ParserLineToArray;
import main.com.innowise.reader.impl.ArrayFileReader;
import main.com.innowise.service.impl.AverageService;
import main.com.innowise.service.impl.SortService;
import main.com.innowise.service.impl.SumService;
import main.com.innowise.validator.impl.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SortService sortService = new SortService();
        ArrayFileReader fileReader = new ArrayFileReader();
        SumService sumService = new SumService();
        AverageService averageService = new AverageService();
        ValidatorService validatorService = new ValidatorService();
        ParserLineToArray parserLineToArray = new ParserLineToArray();
        EntityFactory entityFactory = new EntityFactory();

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
                System.out.println(sumService.sum(entity));
                System.out.println("averageService.findAverageElement(entity) = " + averageService.findAverageElement(entity));
                System.out.println(entity);
            } catch (EntityException e) {
                logger.warn(e);
            }
        }
    }
}