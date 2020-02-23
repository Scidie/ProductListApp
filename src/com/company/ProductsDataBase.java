package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsDataBase {
    ArrayList<String> listOfProducts = new ArrayList<>();

    public ProductsDataBase(String... products) {
        getListOfProducts().addAll(Arrays.asList(products));
    }

    void showAllProducts() {
        for (int i = 0; i < getListOfProducts().size(); i++) {
            System.out.println(i + " " + getListOfProducts().get(i));
        }
        System.out.println();
    }

    public ArrayList<String> getListOfProducts() {
        return listOfProducts;
    }
}
