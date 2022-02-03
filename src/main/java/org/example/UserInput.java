package org.example;

import java.util.Scanner;

public  class UserInput {

    static int getNumber(){
        int number=0;
        while (true){
            try {
                number = Integer.parseInt(getString());
                return number;
            } catch (Exception e) {
                System.out.println("Invalid number, Try again");
            }
        }
    }

    static int getNumberBetween(int min, int max){
        System.out.println("Enter an exercise number between"+ min+ "and"+ max);
        int number;
        while (true) {
            number = getNumber();
            if (number < min || number > max)
                System.out.println("Out of the range. Try again between"+ min+ "and"+ max);
            else  return number;
        }
    }

    static boolean typeEToExit(){
        System.out.println("\n\nType E to exit or type something else to continue");
        String input = getString();
        if (input.toLowerCase().startsWith("e")){
            System.out.println("End");
            return true;
        }
        System.out.flush();
        return input.toLowerCase().startsWith("e");
    }

    public static String getString(){
        Scanner scanner= new Scanner(System.in);
        return scanner.next();
    }
}
