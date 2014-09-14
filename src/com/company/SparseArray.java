package com.company;

import java.util.ArrayList;

public class SparseArray {
    private SAItem start;
    private SAItem last;

    public SparseArray() { }

    //Вставка первого значения по умолчанию
    private void InitArray(String value) {
        start = new SAItem(0, value);
        start.next = null;
        start.prev = null;
        last = start;
    }

    //Вставка первого значения по умолчанию
    private void InitArray(int key, String value) {
        start = new SAItem(key, value);
        start.next = null;
        start.prev = null;
        last = start;
    }


    //Вставляет элемент в начало " разряженного массива"
    public void insertToStart(String value) {
        if (start == null) {
            InitArray(value);
        } else {
            int index = start.key - 1;
            SAItem item = new SAItem(index, value);
            start.prev = item;
            item.next = start;
            start = item;
        }
    }

    //Вставляет элемент в конец "разряженного массива"
    public void insertToEnd(String value) {
        if(last == null) {
            InitArray(value);
        } else {
            int index = last.key + 1;
            SAItem item = new SAItem(index, value);
            last.next = item;
            item.prev = last;
            last = item;
        }
    }

    //получает значение(я) по ключу
    public ArrayList<String> getByKey(int key) {
        SAItem fromStart = start;
        SAItem fromEnd = last;
        ArrayList<String> values = new ArrayList<String>();

        while(fromStart.next != null && fromEnd.prev != null) {
            if(fromEnd.key < fromStart.key) {
                return values;
            }

            if(key == fromStart.key) {
                values.add(fromStart.data);
                while(fromStart.next != null && fromStart.next.key == key) {
                    fromStart = fromStart.next;
                    values.add(fromStart.data);
                }
                break;
            } else if(key == fromEnd.key) {
                values.add(fromEnd.data);
                while(fromEnd.prev != null && fromEnd.prev.key == key) {
                    fromEnd = fromEnd.prev;
                    values.add(fromEnd.data);
                }
                break;
            }

            fromEnd = fromEnd.prev;
            fromStart = fromStart.next;
        }

        return values;
    }

    //Производит постановку элемента по произвольному ключу
    public void insertElement(int key, String value) {
        SAItem item = new SAItem(key,value);

        if(start == null) {
            InitArray(key, value);
            return;
        }

        if(key >= last.key) {
            last.next = item;
            item.prev = last;
            last = item;
        } else if(key <= start.key) {
            start.prev = item;
            item.next = start;
            start = item;
        } else {
            SAItem current = start;
            while(current.key < item.key && current.next.next != null) {
                current = current.next;
            }
            item.next = current.next;
            current.next.prev = item;
            current.next = item;
            item.prev = current;
        }
    }

    //Удаляет элемент/последовательность по ключу
    public void deleteByKey(int key) {
        SAItem fromStart = start;
        SAItem fromEnd = last;

        while(fromStart.next != null && fromEnd.prev != null) {
            if(fromStart.key == key ) {
                while(fromStart != null && fromStart.key == key) {
                    if(fromStart.prev != null) {
                        fromStart.prev.next = fromStart.next;
                        fromStart.next.prev = fromStart.prev;
                        fromStart = fromStart.next;
                    } else {
                        if(fromStart.next != null) {
                            fromStart = fromStart.next;
                        } else {
                            start = last = null;
                            return; //массив пуст
                        }

                        fromStart.prev = null;
                        start = fromStart;
                    }
                }
                break;
            } else if(fromEnd.key == key) {
                while(fromEnd != null && fromEnd.key == key) {
                    if(fromEnd.next != null) {
                        fromEnd.next.prev = fromEnd.prev;
                        fromEnd.prev.next = fromEnd.next;
                        fromEnd = fromEnd.prev;
                    } else {
                        if(fromEnd.prev != null) {
                            fromEnd = fromEnd.prev;
                        } else {
                            start = last = null;
                            return; //массив пуст
                        }
                        fromEnd.next = null;
                        last = fromEnd;
                    }
                }
                break;
            }

            fromStart = fromStart.next;
            fromEnd = fromEnd.prev;
        }
    }

    //Печатает "разряженный массив"
    public void printSparseArray() {
        SAItem item = start;

        if(start == null) {
            System.out.println("Массив пуст!");
            return;
        }

        do {
            System.out.println(item.key + " " + item.data);
            item = item.next;
        } while(item != null);
    }
}
