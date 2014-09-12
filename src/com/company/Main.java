package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        Utilities.shopsCatalog = new ArrayList<Shop>();

        ArrayList<SportsItem> items = new ArrayList<SportsItem>();
        items.add(new SportsWear("Куртка", "Bogner", 10000, "XXL", true));
        items.add(new SportsWear("Футболка", "Reebok", 1000, "M", false));
        items.add(new SportsWear("Спортивный костюм", "Abibas", 3000, "S", true));
        items.add(new SportsWear("Перчатки", "Adidas", 8000, "XL", false));
        items.add(new SportsWear("Толстовка", "Völkl", 5000, "M", true));
        items.add(new SportsWear("Шапка", "КНР", 200, "M", false));
        items.add(new SportsShoes("Бутсы", "Star", 2000, 42, true));
        items.add(new SportsShoes("Сапоги для рыбалки", "Fishman", 4000, 45, false));

        Utilities.registerShop(new Shop("Adidas", items));
        Utilities.registerShop(new Shop("Nike", items));
        Utilities.registerShop(new Shop("Reebok", items));
        Utilities.printRegisteredShops();

        User user = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int action = -1;

        //цикл приложения
        while(true) {
            if(user == null) {
                System.out.print("Введите ваше имя: ");
                user = new User(br.readLine());
            }

            Utilities.printActionList();
            System.out.print("Введите действие: ");
            action = Integer.parseInt(br.readLine());

            switch (action) {
                case 1:
                    System.out.print("Введите название магазина: ");
                    Shop shop = Utilities.searchShop(br.readLine());
                    if(shop != null) {
                        Utilities.shopFunctionality(shop, user, br);
                    } else {
                        System.out.println("Такого магазина не существует!");
                    }
                    break;
                case 2:
                    System.out.print("Положите деньги на счет (руб.): ");
                    user.putCash(Double.parseDouble(br.readLine()));
                    System.out.println("Текущий счет - " + user.getMoney());
                    break;
                case 3:
                    if(!user.getCart().isEmpty()) {
                        user.printCart();
                    } else {
                        System.out.println("Ваша корзина пуста...");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("!");
                    break;
            }
        }
    }
}
