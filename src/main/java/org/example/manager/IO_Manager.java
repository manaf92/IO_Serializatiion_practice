package org.example.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IO_Manager<T> {

    // Static Methods .......
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
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }


    public static void WriteCollectionOfLines(Collection<String> lines, String writePath) {
        File source = new File(writePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
            System.out.println("the objects was added to the file, successfully. Reload to chek the file ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void copyAFile(String sourcePath, String destinationPath) {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationPath))
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
            System.out.println("the file:'" + sourcePath + "' was copied to this new file:'" + destinationPath + "'");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
