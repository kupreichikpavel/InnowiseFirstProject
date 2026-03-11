package main.com.innowise;

import main.com.innowise.entity.Entity;
import main.com.innowise.factory.impl.EntityFactory;
import main.com.innowise.parser.impl.ParserLineToArray;
import main.com.innowise.reader.impl.FileReader;
import main.com.innowise.validator.impl.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        ValidatorService validatorService = new ValidatorService();
        ParserLineToArray parserLineToArray = new ParserLineToArray();
        EntityFactory entityFactory = new EntityFactory();

        List<String> values = fileReader.read("/Users/alexey/IdeaProjects/InnowiseFirstProject/src/resources/arrays.txt");

        List<Entity> entityList = values.stream()
                .filter(validatorService::isValidate)
                .map(parserLineToArray::parseToIntArray)
                .map(entityFactory::createEntity)
                .toList();
        entityList.forEach(System.out::println);

        logger.info("Создано сущностей: " + entityList.size());
    }
}