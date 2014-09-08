package com.company;

import java.math.BigDecimal;

/**
 * Created by 1 on 08.09.2014.
 */
public class SportsItem {
    //Поля
    protected String title;
    protected String department;
    protected String brand;
    protected BigDecimal price;

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //Конструкторы
    public SportsItem(){ }

    public SportsItem(String t, String d, String b, BigDecimal p) {
        title = t;
        department = d;
        brand = b;
        price = p;
    }
}
