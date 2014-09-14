package com.company;

/*
* Класс, наследник SportsItem. Описывает спортивную одежду.
* */
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

    public SportsWear(String t, String b, double p, String s, boolean hasS) {
        super(t,b,p);
        size = s;
        hasSleeves = hasS;
    }
}
