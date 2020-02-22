package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsDataBase {
    ArrayList<String> listOfProducts = new ArrayList<>();


    public ProductsDataBase(String... products) {
        listOfProducts.addAll(Arrays.asList(products));
    }

    void showAllProducts () {
        for (int i = 0; i < listOfProducts.size(); i++) {
            System.out.println(i + " " + listOfProducts.get(i));
        }
        System.out.println();
    }
}
