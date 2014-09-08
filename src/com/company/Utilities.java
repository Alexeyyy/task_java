package com.company;

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

    public static void RegShop(Shop shop) {
        if(shopsCatalog.size() == 0) {
            shopsCatalog.add(shop);
            return;
        }

        if(searchShop(shop.getName()) != null) {
            shopsCatalog.add(shop);
        }
    }
}
