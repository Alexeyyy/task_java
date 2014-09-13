package com.company;

public class SAItem {
    public SAItem next;
    public SAItem prev;
    public String data;
    public int key;

    public SAItem(int i, String d) {
        key = i;
        data = d;
    }
}
