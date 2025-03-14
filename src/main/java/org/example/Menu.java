package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void prinMenu() throws SQLException {

        HumanCrud function = new HumanCrud();

        System.out.println("Menu:\n1)Insert Record\n2)Update Record\n3)Get Record\n4)Get All Records\n5)Delete Record\nOption:");
        Scanner keyboard = new Scanner(System.in);
        int option = keyboard.nextInt();

        switch(option) {
            case 1://Create Record
                System.out.println("Enter Name:");
                String createName = keyboard.next();
                System.out.println("Enter Age:");
                Integer createAge = Integer.parseInt(keyboard.next());
                System.out.println("Enter Comment(Optional):");
                String createComment = keyboard.next();
                Human createdHuman = new Human(null,createName, createAge, createComment);
                createdHuman = function.createHuman(createdHuman);
                break;
            case 2://Update Record
                System.out.println("Enter ID:");
                Integer updateId = keyboard.nextInt();
                System.out.println("Enter Name:");
                String updateName = keyboard.next();
                System.out.println("Enter Age:");
                Integer updateAge = Integer.parseInt(keyboard.next());
                System.out.println("Enter Comment(Optional):");
                String updateComment = keyboard.next();
                Human updatedHuman = new Human(updateId,updateName,updateAge,updateComment);
                updatedHuman = function.updateHuman(updatedHuman);
                break;
            case 3://Get Record
                System.out.println("Enter the ID of the desired record:");
                Integer id = keyboard.nextInt();
                Human human = function.getHumanById(id);
                break;
            case 4://Get All Records
                SqlCommands.getAllRecords();
                break;
            case 5://Delete Record
                System.out.println("Enter the ID of the record to be deleted:");
                Integer deleteId = keyboard.nextInt();
                function.deleteHuman(deleteId);
                break;
            default:
                return;
        }

    }

}
