package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IO_Manager {
    public static String readFileGetString(String path) {
        StringBuilder data = new StringBuilder();
        for (String line : readFileGetCollectionOfLines(path)) {
            data.append(line);
        }
        return data.toString();
    }

    public static Collection<String> readFileGetCollectionOfLines(String path) {
        File source = new File(path);
        List<String> data = new ArrayList<>();
        try( BufferedReader reader = new BufferedReader(new FileReader(source)))
        {
            String line;
            while((line = reader.readLine()) != null ){
                data.add(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return data;
    }


    public static void WriteCollectionOfLines(Collection<String> lines,String writePath) {
        File source = new File(writePath);
        try( BufferedWriter writer = new BufferedWriter(new FileWriter(source)))
        {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("the objects was added to the file, successfully. Reload to chek the file ");
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }




}
