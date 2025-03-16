package org.example;

import java.util.List;
import java.util.Scanner;

public class Print {

    public static int menu() {
        System.out.println("""
                _________________
                1)Insert Record
                2)Update Record
                3)Get Record
                4)Get All Records
                5)Delete Record
                6)EXIT
                Option:""");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }

    public static void human(Human human){
        System.out.println("_________________");
        System.out.println("ID: "+human.getId()+", Name: "+human.getName()+", Age: "+human.getAge()+", Comment: "+human.getComment());
    }

    public static void allHumans(List<Human> Humans){
        System.out.println("_________________");
        for (Human human : Humans) {
            System.out.println("ID: " + human.getId() + ", Name: " + human.getName() + ", Age: " + human.getAge() + ", Comment: " + human.getComment());
        }
    }

}
