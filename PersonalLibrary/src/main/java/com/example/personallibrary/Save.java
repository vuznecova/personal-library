package com.example.personallibrary;

import java.io.*;

public class Save < T > {
    public void write(T t, int i) {

        try {

            FileOutputStream fileOut = new FileOutputStream("saveFile" + i + ".txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(t);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object read(int i) {

        try {

            FileInputStream fileIn = new FileInputStream("saveFile" + i + ".txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object list = objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception ex) {

            return null;
        }
    }
}