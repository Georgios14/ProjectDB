package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void prinMenu() throws SQLException {

        System.out.println("Menu:\n1)Get all records\n2)Get record\n3)Insert Record");
        Scanner keyboard = new Scanner(System.in);
        int option = keyboard.nextInt();

        switch(option) {
            case 1:
                SqlCommands.getAllRecords();
                break;
            case 2:
                System.out.println("Enter the id of the desired record:");
                int id = keyboard.nextInt();
                SqlCommands.getRecord(id);
                break;
            case 3:
                System.out.println("Enter Name:");
                String name = keyboard.nextLine();
                SqlCommands.insertRecord(name);
                break;
            default:
                return;
        }

    }

}
