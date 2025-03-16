package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        HumanCrud function = new HumanCrud();
        int option = Print.menu();

        while(option>0 && option<6) {
            switch (option) {
                case 1://Create Record
                    System.out.println("Enter Name:");
                    String createName = keyboard.next();
                    System.out.println("Enter Age:");
                    Integer createAge = Integer.parseInt(keyboard.next());
                    System.out.println("Enter Comment(Optional):");
                    String createComment = keyboard.next();
                    Human createdHuman = new Human(null, createName, createAge, createComment);
                    createdHuman = function.createHuman(createdHuman);
                    Print.human(createdHuman);
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
                    Human updatedHuman = new Human(updateId, updateName, updateAge, updateComment);
                    updatedHuman = function.updateHuman(updatedHuman);
                    Print.human(updatedHuman);
                    break;
                case 3://Get Record
                    System.out.println("Enter the ID of the desired record:");
                    Integer id = keyboard.nextInt();
                    Human human = function.getHumanById(id);
                    Print.human(human);
                    break;
                case 4://Get All Records
                    List<Human> Humans = function.getAllHumans();
                    Print.allHumans(Humans);
                    break;
                case 5://Delete Record
                    System.out.println("Enter the ID of the record to be deleted:");
                    Integer deleteId = keyboard.nextInt();
                    function.deleteHuman(deleteId);
                    break;
                default:
                    return;
            }
            option = Print.menu();
        }
    }
}