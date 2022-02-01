package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.IO_Manager.readFileGetCollectionOfLines;
import static org.example.IO_Manager.readFileGetString;
import static org.example.UserInput.typeEToExit;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //get the number of the exercise
        do{
            int number = UserInput.getCheckedNumber();
            switch (number) {
                /**
                 1. Create a textfile (.txt) and fill it with some text content. Tip: you can find random text here.
                 a. In Java create a method that read in a String from file and return the String using
                 FileReader.
                 */
                case 1:
                    System.out.println(IO_Manager.readFileGetString("source_folder/Random text 1.txt"));;
                    break;

                /**
                 2. Create a textfile (.txt) and fill it with lines of names.
                 a. In Java create a method that read in the lines into a Collection of your choice using
                 BufferedReader. One line for each element in the Collection.
                 */
                case 2:
                    readFileGetCollectionOfLines("source_folder/names_task2.txt").forEach(System.out::println);
                    break;


                /**
                 3. In Java create a Collection that contains at least five String objects.
                 a. Then create a method that write each String object from the collection into a textfile.
                 */
                case 3:
                    List<String> lines = new ArrayList<>(Arrays.asList(
                            "In Java create",
                            "a Collection that",
                            "contains at",
                            "least five String",
                            "objects.",
                            "Then create",
                            "a method that write",
                            "each String object from",
                            "collection into a textfile."

                    ));
                    IO_Manager.WriteCollectionOfLines(lines,"source_folder/Lines_Task3.txt");
                    break;

                /**

                 */
                case 4:
                    task4();
                    break;

                /**

                 */
                case 5:
                    task5();
                    break;

                /**

                 */
                case 6:
                    task6();
                    break;
            }
        }while(!typeEToExit());
    }

    private static void task6() {

    }

    private static void task5() {

    }

    private static void task4() {

    }

    private static void task3() {
    }

    private static void task2() {

    }



    // extra helping methods

}
