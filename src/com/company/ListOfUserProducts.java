package com.company;

import java.util.ArrayList;

public class ListOfUserProducts {
    ArrayList<UserProduct> listOfProducts = new ArrayList<>();

    void showTheList() {
        for (int i = 0; i < listOfProducts.size(); i++) {
            System.out.println("name: " + listOfProducts.get(i).getName());
            System.out.println("id: " + listOfProducts.get(i).getId());
        }
    }

    void checkProduct(String userProduct, ProductsDataBase productsDataBase) {
        for (int i = 0; i < productsDataBase.listOfProducts.size(); i++) {
            if (isTheSame(userProduct) == false) {
                if (userProduct.equals(productsDataBase.listOfProducts.get(i))) {
                    listOfProducts.add(new UserProduct(userProduct, productsDataBase.listOfProducts.indexOf(productsDataBase.listOfProducts.get(i))));
                    break;
                } else if (i == productsDataBase.listOfProducts.size() - 1) {
                    System.out.println("product doesn't match, you can try something else...");
                }
            } else {
                System.out.println("this product is already on your list...");
                System.out.println();
                break;
            }
        }
    }

    boolean isTheSame(String product) {
        boolean isTheSame = false;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (product.equals(listOfProducts.get(i).getName()) && listOfProducts.size() > 0) {
                isTheSame = true;
            }
        }
        return isTheSame;
    }

    UserProduct findLowestIdProduct() {
        ArrayList<UserProduct> copyOfListOfproducts = new ArrayList<>();
        for (int i = 0; i < listOfProducts.size(); i++) {
            copyOfListOfproducts.add(listOfProducts.get(i));
        }

        while (copyOfListOfproducts.size() > 1) {
            if (copyOfListOfproducts.get(0).getId() > copyOfListOfproducts.get(1).getId()) {
                copyOfListOfproducts.remove(0);

            } else {
                copyOfListOfproducts.remove(1);
            }
        }
        return copyOfListOfproducts.get(0);
    }


    void createIntelligentList(IntelligentList intelligentList) {
        ArrayList<UserProduct> libraryOfUserProducts = new ArrayList<>();
        for (int i = 0; i < listOfProducts.size(); i++) {
            libraryOfUserProducts.add(listOfProducts.get(i));
        }
        while (listOfProducts.size() >= 1) {
            UserProduct product = findLowestIdProduct();
            intelligentList.addProductToList(product);
            listOfProducts.remove(product);
        }
        for (int i = 0; i < libraryOfUserProducts.size(); i++) {
            listOfProducts.add(libraryOfUserProducts.get(i));
        }

    }
}


