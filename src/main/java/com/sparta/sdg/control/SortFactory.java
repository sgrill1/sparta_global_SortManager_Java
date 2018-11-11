package com.sparta.sdg.control;

import com.sparta.sdg.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {

    private static final String PATH = "resources/Factory.properties";

    static Sorter getInstance() throws FactoryException {
        try {
            Properties properties = new Properties ();
            properties.load (new FileReader (PATH));
            String sortType = properties.getProperty ("sorter");
            Class selectedSorter = Class.forName(sortType);
            return (Sorter)selectedSorter.getDeclaredConstructor().newInstance ();

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new FactoryException("Unable to process user request");
        }
    }
}

