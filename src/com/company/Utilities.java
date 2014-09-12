package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 1 on 08.09.2014.
 */
public class Utilities {
    public static ArrayList<Shop> shopsCatalog = new ArrayList<Shop>();

    public static Shop searchShop(String name) {
        for(Shop item : shopsCatalog) {
            if(item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public static void registerShop(Shop shop) {
        if(shopsCatalog.size() == 0) {
            shopsCatalog.add(shop);
            return;
        }

        if(searchShop(shop.getName()) == null) {
            shopsCatalog.add(shop);
        }
    }

    public static void printRegisteredShops() {
        System.out.println("===Зарегистрированные магазины===");
        for(Shop item : shopsCatalog) {
            System.out.println(item.getName());
        }
        System.out.println("=================================");
    }

    public static void printActionList() {
        System.out.println("=======Действия=======");
        System.out.println("1 - Войти в магазин");
        System.out.println("2 - Положить деньги на счет");
        System.out.println("3 - Корзина");
        System.out.println("4 - Выйти");
        System.out.println("======================");
    }

    public static void shopActionsList(Shop shop) {
        System.out.println("=======Магазин " + shop.getName() + "=========");
        System.out.println("1 - Покупки");
        System.out.println("2 - Выйти");
        System.out.println("=====================");
    }

    private static void shopBuyingProcess(Shop shop, User user, BufferedReader br) throws IOException{
        System.out.print("Введите индекс товара - ");
        int goodIndex = Integer.parseInt(br.readLine());

        if(goodIndex > shop.getItems().size() - 1 || goodIndex < 0) {
            System.out.println("Такого товара нет...");
            return;
        }

        if(user.getMoney() >= shop.getItems().get(goodIndex).price) {
            System.out.println("Вы собираетесь потратить " + shop.getItems().get(goodIndex).price + ", согласны? (д/н)");
            String reply = br.readLine();

            if(reply.equals("д")) {
                user.deriveCash(shop.getItems().get(goodIndex).price);
                user.addToCart(shop.getItems().get(goodIndex));
                shop.sell(goodIndex);
                System.out.println("Операция покупки успешно завершена!");
            } else {
                System.out.println("Вы отказались от покупки");
                return;
            }
        } else {
            System.out.println("Не хватает денег!");
        }
    }

    public static void shopFunctionality(Shop shop, User user, BufferedReader br) throws IOException {
        while(true) {
            shopActionsList(shop);
            System.out.print("Введите действие: ");
            int action = Integer.parseInt(br.readLine());
            boolean isExit = false;

            switch (action) {
                case 1:
                    if(!shop.getItems().isEmpty()) {
                        shop.printItemsList();
                        shopBuyingProcess(shop, user, br);
                    } else {
                        System.out.println("В магазине закончились товары...");
                    }
                    break;
                case 2:
                    isExit = true;
                    break;
                default:
                    System.out.println("Неверная команда...");
            }

            if(isExit) {
                break;
            }
        }
    }
}
