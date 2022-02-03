package org.example;

import org.example.manager.IO_Manager;
import org.example.manager.JsonIO;
import org.example.manager.ObjectSerial;
import org.example.model.Car;
import org.example.model.Owner;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.manager.IO_Manager.readFileGetCollectionOfLines;
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
            int number = UserInput.getNumberBetween(1,6);
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
                 4. Create a method that can copy a file using both BufferedInputStream and
                 BufferedOutputStream.
                 */
                case 4:
                    IO_Manager.copyAFile("source_folder/Lines_Task3.txt","source_folder/destination_task4.txt");
                    break;

                /**
                 5. In Java create a class called Car with properties like regnumber, brand and model etc... The
                 Car class must implement Serializable. To also fulfil the contract make a default constructor.
                    a. Create a List of Cars and add some objects into it.
                    b. Save the List of Cars to a file using ObjectOutputStream.
                    c. Read the List of Cars from file using ObjectInputStream.
                 */
                case 5:
                    // filling objects in the fill
                    Task5Part_ab();
                    // Reading & Printing out the file objects
                    Task5Part_c();
                    break;

                /**
                 6.Make a small program called car_register.
                    a. Create models Car and Owner.
                    b. Car should have fields: carId, regNumber, brand, model, regDate and owner. It
                        should also implement Serializable together with a default constructor.
                    c. Owner should have fields: ownerId, name, birthdate. Owner also need to implement
                        Serializable and have a default contructor.
                    d. Create two collections, one for Cars and the other for Owners.
                    e. Create functionality to serialize the collections to JSON files.
                    f. Create functionality to deserialize the JSON files to it’s resepective Collection.
                 */
                case 6:
                    car_register();
                    break;
            }
        }while(!typeEToExit());
    }


    // extra helping methods
    private static void Task5Part_ab() {
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car(1,"reg123-b11","Volvo","S60 Cross Country", LocalDate.parse("2016-04-01")),
                new Car(2,"reg693-b81","Volvo","Volvo S80", LocalDate.parse("2016-07-22")),
                new Car(3,"reg253-b33","Mazzanti","Evantra", LocalDate.parse("2019-10-14")),
                new Car(4,"reg355-b75","Mazzanti","Evantra 771", LocalDate.parse("2021-03-09")),
                new Car(5,"reg897-b15","Toyota ","Toyota Vios", LocalDate.parse("2020-06-02"))
        ));
        ObjectSerial objectSerial=new ObjectSerial();
        objectSerial.addObjectsToFile(cars, new File("source_folder/Cars Collection"));
    }

    private static void Task5Part_c() {
        ObjectSerial objectSerial=new ObjectSerial();
        List<Car> cars = objectSerial.readObjectsFromFile(new File("source_folder/Cars Collection"));
        cars.forEach(System.out::println);
    }

    private static void car_register() {

        List<Owner>  owners = new ArrayList<>(Arrays.asList(
                new Owner(1,"Johan",LocalDate.parse("1992-03-01")),
                new Owner(2,"Mikael",LocalDate.parse("1999-10-14")),
        new Owner(3,"Anders", LocalDate.parse("2016-01-22")),
        new Owner(4,"Johan",LocalDate.parse("1988-05-22")),
        new Owner(5,"Lars", LocalDate.parse("1970-11-14"))
        ));

        List<Car>  cars = new ArrayList<>(Arrays.asList(
                new Car(1,"reg123-b11","Volvo","S60 Cross Country", LocalDate.parse("2016-04-01")),
                new Car(2,"reg693-b81","Volvo","Volvo S80", LocalDate.parse("2016-07-22")),
                new Car(3,"reg253-b33","Mazzanti","Evantra", LocalDate.parse("2019-10-14")),
                new Car(4,"reg355-b75","Mazzanti","Evantra 771", LocalDate.parse("2021-03-09")),
                new Car(5,"reg897-b15","Toyota ","Toyota Vios", LocalDate.parse("2020-06-02"))
        ));

        JsonIO jsonIO=new JsonIO();

        // Adding the cars & owners collection  to the file
        jsonIO.serializeToJson(cars, new File("source_folder/Cars Json"));
        jsonIO.serializeToJson(owners, new File("source_folder/owner Json"));

        // reading from the json file and printing out
        System.out.println("Cars ____");
        jsonIO.deserializeFromJson(new File("source_folder/Cars Json")).forEach(System.out::println);
        System.out.println("Owner ____");
        jsonIO.deserializeFromJson(new File("source_folder/owner Json")).forEach(System.out::println);
    }
}
