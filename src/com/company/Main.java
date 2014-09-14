package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        SparseArray sparseArray = new SparseArray();
        ArrayList<String> values = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int action = -1, key;

        while(true) {
            System.out.println("===Действия===");
            System.out.println("1. Вставить элемент в начало");
            System.out.println("2. Вставить элемент в конец");
            System.out.println("3. Вставить по произвольному ключу");
            System.out.println("4. Получить значение(я) по указанному ключу");
            System.out.println("5. Удалить по ключу");
            System.out.println("6. Печать массива(<ключ - значение>)");
            System.out.println("7. Выйти из приложения");
            System.out.println("==============");

            System.out.print("Введите команду...");
            action = Integer.parseInt(br.readLine());

            switch(action) {
                case 1:
                    System.out.print("Введите значение...");
                    sparseArray.insertToStart(br.readLine());
                    break;
                case 2:
                    System.out.print("Введите значение...");
                    sparseArray.insertToEnd(br.readLine());
                    break;
                case 3:
                    System.out.print("Введите значение ключа...");
                    key = Integer.parseInt(br.readLine());
                    System.out.print("Введите значение...");
                    sparseArray.insertElement(key, br.readLine());
                    break;
                case 4:
                    System.out.print("Введите значение ключа...");
                    key = Integer.parseInt(br.readLine());
                    values = sparseArray.getByKey(key);
                    if(values.isEmpty()) {
                        System.out.println("Не найдено значений по указанному ключу");
                    } else {
                        System.out.println("Ключ - " + key);
                        for(String item : values) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Введите значение ключа...");
                    key = Integer.parseInt(br.readLine());
                    sparseArray.deleteByKey(key);
                    break;
                case 6:
                    System.out.println("Вывод значений...");
                    sparseArray.printSparseArray();
                    break;
                case 7:
                    System.out.println("Пока!");
                    return;
                default:
                    System.out.println("Неверная команда!");
                    break;
            }
        }
    }
}
