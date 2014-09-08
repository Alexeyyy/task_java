package com.company;

import java.math.BigDecimal;

/**
 * Created by 1 on 08.09.2014.
 */
public class SportsWear extends SportsItem {
    //Поля
    protected String size;
    protected boolean hasSleeves;

    public String getSize() {
        return size;
    }

    public boolean getHasSleeves() {
        return hasSleeves;
    }

    //Конструкторы
    public SportsWear() { }

    public SportsWear(String t, String d, String b, BigDecimal p, String s, boolean hasS) {
        super(t,d,b,p);
        size = s;
        hasSleeves = hasS;
    }
}
