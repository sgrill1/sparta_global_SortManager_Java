package com.sparta.sdg.control;

import com.sparta.sdg.display.DisplayManager;
import com.sparta.sdg.sorters.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class SortManager{
    static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    static Logger log = Logger.getLogger (SortManager.class.getName ());

    public void initialiseLogging(){
        PropertyConfigurator.configure (LOG_PROPERTIES_FILE);
    }


    private int[] arrayToSort = {1,7,4,25,11,5,7};
    DisplayManager displayManager = new DisplayManager ();

    public void runSorter() {
        initialiseLogging ();
        try {
            Sorter sorter = SortFactory.getInstance();
            int[] sortedArray = sorter.sortArray (arrayToSort);
            displayArrayToSort (arrayToSort, sorter.toString ());
            displaySortedArray (sortedArray, sorter.toString ());
        } catch(FactoryException e){
            displayManager.displayExceptionMessage(e.getMessage());
            log.info ("Unable to process user request");
        }
    }
    private void displayArrayToSort(int[] arrayToSort, String sortType){
        displayManager.displayArrayToSort(arrayToSort, sortType);
    }

    private void displaySortedArray(int[] sortedArray, String sortType){
        displayManager.displaySortedArray(sortedArray, sortType);
    }





}
