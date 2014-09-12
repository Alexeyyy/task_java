package com.company;

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

    public SportsShoes(String t, String b, double p, int s, boolean hasL ) {
        super(t,b,p);
        size = s;
        hasLaces = hasL;
    }
}
