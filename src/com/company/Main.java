package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello world from java!");
        Worker.Out();

        try (BufferedReader reader = new BufferedReader(new FileReader("d://file_java.txt"))) {
            String str = "";

            System.out.print("\n");

            while((str = reader.readLine()) != null) {
                System.out.println(str);
            }

            System.out.print("\n");
        }
        catch (IOException e) {
            System.out.print("I/O error: " + e);
        }
        finally {
            System.out.print("Finally!");
        }
    }
}
