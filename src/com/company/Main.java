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
        System.out.println();

        while (true) {
            listOfUserProducts.addProductToList(productsDataBase, intelligentList, listOfUserProducts);
        }
    }
}






