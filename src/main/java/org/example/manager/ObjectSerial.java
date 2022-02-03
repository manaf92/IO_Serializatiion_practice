package org.example.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerial<T> {
    public List<T> readObjectsFromFile(File sourceFile) {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(sourceFile))) {
            objects = (List<T>) read.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public void addObjectsToFile(List<T> objects, File destinationFile) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(destinationFile))) {
            write.writeObject(objects);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
