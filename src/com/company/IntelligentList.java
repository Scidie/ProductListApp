package com.company;

import java.util.ArrayList;

public class IntelligentList {
    ArrayList<UserProduct> intelligentList = new ArrayList<>();

    void addProductToList(UserProduct userProduct) {
        getIntelligentList().add(userProduct);
    }

    void showTheList() {
        System.out.println();
        System.out.println("Your Better Shopping List:");
        for (int i = 0; i < getIntelligentList().size(); i++) {
            System.out.println((i + 1) + ". " + getIntelligentList().get(i).getName() + " " + getIntelligentList().get(i).getQuantity());
        }
        System.out.println();
        System.out.println("Add more to your list if you want...");
        System.out.println();
    }

    void resetTheList() {
        while (getIntelligentList().size() > 0) {
            getIntelligentList().remove(0);
        }
    }

    public ArrayList<UserProduct> getIntelligentList() {
        return intelligentList;
    }
}

