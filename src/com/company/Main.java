package com.company;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop("Abibas", null);
        Utilities.RegShop(shop);
        User user = new User("Alex");
        user.Register();


        System.out.println("Bye!");
    }
}
