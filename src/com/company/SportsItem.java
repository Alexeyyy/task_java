package com.company;

/*
* Класс, описывающий единицу спортивного инвентаря
* */
public class SportsItem {
    //Поля
    protected String title;
    protected String brand;
    protected double price;

    public String getTitle() {
        return title;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    //Конструкторы
    public SportsItem(){ }

    public SportsItem(String t, String b, double p) {
        title = t;
        brand = b;
        price = p;
    }
}
