package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

    public static String readPasswordFile() {
        try {

            File passwordfile = new File("passwordFile.txt");
            Scanner reader = new Scanner(passwordfile);
            String data = reader.nextLine();
            reader.close();

            return data;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }

}
