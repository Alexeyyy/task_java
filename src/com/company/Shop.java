package com.company;

import java.util.ArrayList;

/**
 * Created by 1 on 08.09.2014.
 */
public class Shop {
    //Поля
    private String name;
    private ArrayList<SportsItem> items;
    private ArrayList<User> users;

    public String getName() {
        return name;
    }

    public ArrayList<SportsItem> getItems() {
        return items;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    //Конструкторы
    public Shop() { }

    public Shop(String n, ArrayList<SportsItem> goods) {
        name = n;
        items = goods;
        users = new ArrayList<User>();
    }

    //Методы
    public boolean Sell() {
        return true;
    }
}
