package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductsDataBase productsDataBase = new ProductsDataBase("chleb", "mleko", "kawa", "cukier", "sol", "czekolada", "szynka");
        ListOfUserProducts listOfUserProducts = new ListOfUserProducts();
        IntelligentList intelligentList = new IntelligentList();
        productsDataBase.showAllProducts();

        System.out.println("Intelligent Shopping List Generator Beta 1.0");
        System.out.println();
        listOfUserProducts.showTheList();
        System.out.println("Enter your product or enter 'G' to generate intelligent shopping list: ");
        System.out.println();
        while (true) {
            String name = input.next();
            if (name.equals("G") == false) {
                listOfUserProducts.checkProduct(name, productsDataBase);
            } else {

//                listOfUserProducts.copyTheList();
//                System.out.println("rozmiar libraryList to: " + listOfUserProducts.libraryOfUserProducts.size());
//                System.out.println();
//                System.out.println("Your Intelligent List:");
                listOfUserProducts.createIntelligentList(intelligentList);
//                System.out.println("rozmiar libraryList to: " + listOfUserProducts.libraryOfUserProducts.size());
//                System.out.println("rozmiar userlisty to: " + listOfUserProducts.listOfProducts.size());
                intelligentList.showTheList();
                intelligentList.resetTheList();
            }
        }
    }
}






