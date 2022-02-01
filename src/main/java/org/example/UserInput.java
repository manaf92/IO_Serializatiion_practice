package org.example;

import java.util.Scanner;

public  class UserInput {

    static int getNumber(){
        int number=0;
        boolean correctInput = false;
        do{
            try {
                number = Integer.parseInt(getString());
                correctInput = true;
            } catch (Exception e) {
                System.out.println("Invalid number, Try again");
            }
        }while (!correctInput);
        return number;
    }

    static int getCheckedNumber(){
        System.out.println("Enter an exercise number between 1 to 6 ");
        int number;
        while (true) {
            number = getNumber();
            if (number < 1 || number > 6)
                System.out.println("Out of the range. Try again between 1 to 6 ");
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
