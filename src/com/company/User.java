package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by 1 on 08.09.2014.
 */
public class User {
    //Поля
    private String name;
    private String login;
    private String password;
    private Shop shop;
    private ArrayList<SportsItem> cart;

    //Конструкторы
    public User() {
    }

    public User(String n) {
        name = n;
        cart = new ArrayList<SportsItem>();
    }

    public boolean Register() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter shop name, where you want to be registered: ");
            String shopName = br.readLine();
            System.out.println(shopName);

            shop = Utilities.searchShop(shopName);
            //Если магазин существует, тогда продолжаем регистрацию
            if (shop != null) {
                System.out.print("Enter your login: ");
                login = br.readLine();
                System.out.print("Enter your password: ");
                password = br.readLine();
            } else {
                System.out.println("This shop doesn't exist! Would you  like to repeat registration? (y/n)");
                String reply = br.readLine();
                if (reply.equals("y")) {
                    Register();
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

    public boolean AddToCart() {
        return true;
    }
}
