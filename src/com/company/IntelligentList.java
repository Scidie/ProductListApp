package com.company;

import java.util.ArrayList;

public class IntelligentList {
    ArrayList<UserProduct> intelligentList = new ArrayList<>();

    void addProductToList(UserProduct userProduct) {
        intelligentList.add(userProduct);
    }

    void showTheList() {
        System.out.println();
        System.out.println("Your Better Shopping List:");
        for (int i = 0; i < intelligentList.size(); i++) {
            System.out.println((i + 1) + ". " + intelligentList.get(i).getName() + " " + intelligentList.get(i).getQuantity());
        }
        System.out.println();
        System.out.println("Add more to your list if you want...");
        System.out.println();
    }

    void resetTheList() {
        while (intelligentList.size() > 0) {
            intelligentList.remove(0);
        }
    }
}

