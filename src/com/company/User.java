package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class User {
    //Поля
    private String name;
    private double money;
    private Shop shop;
    private ArrayList<SportsItem> cart;

    public String getName() { return name; }
    public double getMoney() { return money; }
    public ArrayList<SportsItem> getCart() { return cart; }

    //Конструкторы
    public User() { }

    public User(String n) {
        name = n;
        cart = new ArrayList<SportsItem>();
    }

    public boolean visit() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите название магазина, систему которого вы хотите посетить: ");
            String shopName = br.readLine();

            shop = Utilities.searchShop(shopName);

            if (shop == null) {
                System.out.println("Такого магазина нет в реестре. Хотите повторить вход? (y/n)");
                String reply = br.readLine();
                if (reply.equals("y")) {
                    visit();
                } else if (reply.equals("n")) {
                    return false;
                } else {
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    public void addToCart(SportsItem item) {
        this.cart.add(item);
    }

    public void printCart() {
        System.out.println("===Печать корзины===");

        if(cart.isEmpty()) {
            System.out.println("Ваша корзина пуста");
            return;
        }

        for(SportsItem item : cart) {
            System.out.println(item.title + " --- " + item.brand + " --- " + item.price);
        }

        System.out.println("=====================");
    }

    public void putCash(double amount) {
        this.money += amount;
    }

    public void deriveCash(double amount) {
        this.money -= amount;
    }
}
