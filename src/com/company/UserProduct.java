package com.company;

import java.util.Scanner;

public class UserProduct {
    String name;
    int id;
    String quantity;
    Scanner input = new Scanner(System.in);


    public UserProduct(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Enter quantity: ");
        this.quantity = getString();
    }

    public UserProduct(){}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getQuantity() {
        return quantity;
    }

    String getString() {
        String string = input.next();
        return string;
    }

    int getInt() {
        int integer = input.nextInt();
        return integer;
    }

    public void setName() {
        System.out.println("Enter your product: ");
        this.name = getString();
    }

    public void setQuantity() {
        this.quantity = getString();
    }

    boolean validateName() {
        if (getName().equals("G")) {
            return false;
        } else {
            return true;
        }
    }
}