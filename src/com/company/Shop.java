package com.company;

import java.util.ArrayList;

public class Shop {
    //Поля
    private String name;
    private ArrayList<SportsItem> items;

    public String getName() {
        return name;
    }

    public ArrayList<SportsItem> getItems() {
        return items;
    }

    //Конструкторы
    public Shop() { }

    public Shop(String n, ArrayList<SportsItem> goods) {
        name = n;
        items = goods;
    }

    //Методы
    public void sell(int goodIndex)
    {
        this.items.remove(goodIndex);
    }

    public void printItemsList() {
        System.out.println("===Список товаров в магазине " + this.getName() + "===");
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + ". --- " + items.get(i).title + " --- " + items.get(i).brand);
        }
        System.out.println();
    }
}
