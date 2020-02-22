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

    Boolean isProductInDataBase(UserProduct product, ProductsDataBase productsDataBase) {
        boolean productIsInDataBase = false;
        for (int i = 0; i < productsDataBase.listOfProducts.size(); i++) {
            if (isTheSame(product.getName()) == false) {
                if (product.getName().equals(productsDataBase.listOfProducts.get(i))) {
                    product.id = productsDataBase.listOfProducts.indexOf(productsDataBase.listOfProducts.get(i));
                    productIsInDataBase = true;
                    break;
                }
            }
        }
        return productIsInDataBase;
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

    int setId(UserProduct product, ProductsDataBase productsDataBase) {
        int id = 0;
        for (int i = 0; i < productsDataBase.listOfProducts.size(); i++) {
                if (product.getName().equals(productsDataBase.listOfProducts.get(i))) {
                    id = productsDataBase.listOfProducts.indexOf(productsDataBase.listOfProducts.get(i));
                }
        }
        return id;
    }

    void addProductToList(ProductsDataBase productsDataBase, IntelligentList intelligentList, ListOfUserProducts listOfUserProducts) {
        UserProduct product = new UserProduct();
        product.setName();
        if (product.validateName() == true) {
            if (isProductInDataBase(product, productsDataBase) == true && isTheSame(product.getName()) == false) {
                listOfProducts.add(new UserProduct(product.getName(), setId(product, productsDataBase)));
            } else if (isTheSame(product.getName())) {
                System.out.println("This product is already in your list...");
            } else {
                System.out.println("product does not match, try something else...");
            }
        } else {
            listOfUserProducts.createIntelligentList(intelligentList);
            intelligentList.showTheList();
            intelligentList.resetTheList();
        }
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


