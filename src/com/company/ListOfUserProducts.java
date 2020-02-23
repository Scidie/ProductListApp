package com.company;

import java.util.ArrayList;

public class ListOfUserProducts {
    ArrayList<UserProduct> listOfProducts = new ArrayList<>();

    void showTheList() {
        for (int i = 0; i < getListOfProducts().size(); i++) {
            System.out.println("name: " + getListOfProducts().get(i).getName());
            System.out.println("id: " + getListOfProducts().get(i).getId());
        }
    }

    Boolean isProductInDataBase(UserProduct product, ProductsDataBase productsDataBase) {
        boolean productIsInDataBase = false;
        for (int i = 0; i < productsDataBase.getListOfProducts().size(); i++) {
            if (isTheSame(product.getName()) == false) {
                if (product.getName().equals(productsDataBase.getListOfProducts().get(i))) {
                    product.id = productsDataBase.getListOfProducts().indexOf(productsDataBase.getListOfProducts().get(i));
                    productIsInDataBase = true;
                    break;
                }
            }
        }
        return productIsInDataBase;
    }

    boolean isTheSame(String product) {
        boolean isTheSame = false;
        for (int i = 0; i < getListOfProducts().size(); i++) {
            if (product.equals(getListOfProducts().get(i).getName()) && listOfProducts.size() > 0) {
                isTheSame = true;
            }
        }
        return isTheSame;
    }

    UserProduct theLowestIdProduct() {
        ArrayList<UserProduct> copyOfListOfproducts = new ArrayList<>();
        for (int i = 0; i < getListOfProducts().size(); i++) {
            copyOfListOfproducts.add(getListOfProducts().get(i));
        }

        while (copyOfListOfproducts.size() > 1) {
            if (copyOfListOfproducts.get(0).getId() > getListOfProducts().get(1).getId()) {
                copyOfListOfproducts.remove(0);

            } else {
                copyOfListOfproducts.remove(1);
            }
        }
        return copyOfListOfproducts.get(0);
    }

    void createIntelligentList(IntelligentList intelligentList) {
        ArrayList<UserProduct> copyOfListOfProducts = new ArrayList<>();
        for (int i = 0; i < getListOfProducts().size(); i++) {
            copyOfListOfProducts.add(getListOfProducts().get(i));
        }
        while (getListOfProducts().size() >= 1) {
            UserProduct product = theLowestIdProduct();
            intelligentList.addProductToList(product);
            getListOfProducts().remove(product);
        }
        for (int i = 0; i < copyOfListOfProducts.size(); i++) {
            getListOfProducts().add(copyOfListOfProducts.get(i));
        }

    }

    int setId(UserProduct product, ProductsDataBase productsDataBase) {
        int id = 0;
        for (int i = 0; i < productsDataBase.getListOfProducts().size(); i++) {
            if (product.getName().equals(productsDataBase.getListOfProducts().get(i))) {
                id = productsDataBase.getListOfProducts().indexOf(productsDataBase.getListOfProducts().get(i));
            }
        }
        return id;
    }

    void addProductToList(ProductsDataBase productsDataBase, IntelligentList intelligentList, ListOfUserProducts listOfUserProducts) {
        UserProduct product = new UserProduct();
        product.setName();
        if (isProductInDataBase(product, productsDataBase) == true && isTheSame(product.getName()) == false && product.getName().equals("G") == false) {
            listOfProducts.add(new UserProduct(product.getName(), setId(product, productsDataBase)));
        } else if (isTheSame(product.getName()) && product.getName().equals("G") == false) {
            System.out.println("This product is already in your list...");
        } else if (product.getName().equals("G") == false) {
            System.out.println("product does not match, try something else...");
        } else {
            listOfUserProducts.createIntelligentList(intelligentList);
            intelligentList.showTheList();
            intelligentList.resetTheList();
        }
    }

    public ArrayList<UserProduct> getListOfProducts() {
        return listOfProducts;
    }
}


