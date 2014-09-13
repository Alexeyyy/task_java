package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    SparseArray array = new SparseArray();

        //array.insertToStart("a");
        array.insertToStart("b");
        array.insertToStart("c");
        array.insertToEnd("d");
        /*array.insertToEnd("e");
        array.insertToEnd("f");*/

        array.insertToStart("aaa");
        array.insertElement(1, "bbb");
        array.insertElement(-2, "ccc");
        array.insertElement(-2, "ddd");
        array.insertElement(-2, "ddd");
        array.insertElement(10, "333");
        array.insertElement(10, "333");
        array.insertElement(10, "333");
        array.insertElement(11,"3");

        array.printSparseArray();
        /*ArrayList<String> s = array.searchByKey(1);

        System.out.println("===============LOG===============");
        if(s.isEmpty())
            System.out.println("No!");

        for(String item : s) {
            System.out.println(item);
        }*/
        array.deleteByKey(10);
        System.out.println("===========");
        array.printSparseArray();
    }
}
