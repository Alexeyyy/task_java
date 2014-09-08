package com.company;

import java.math.BigDecimal;

/**
 * Created by 1 on 08.09.2014.
 */
public class SportsShoes extends SportsItem {
    //Поля
    protected int size;
    protected boolean hasLaces;

    public int getSize() {
        return size;
    }

    public boolean getHasLaces() {
        return hasLaces;
    }

    //Конструкторы
    public SportsShoes() { }

    public SportsShoes(String t, String d, String b, BigDecimal p, int s, boolean hasL ) {
        super(t,d,b,p);
        size = s;
        hasLaces = hasL;
    }
}
