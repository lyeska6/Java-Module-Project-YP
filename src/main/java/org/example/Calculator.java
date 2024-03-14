package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    float totalCost = 0.00f;
    int numOfP;

    ArrayList<Product> pList = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    Calculator() {
        System.out.println("Укажите количество человек,на которое нужно разделить счёт (целое число больше 1)");
        this.numOfP = 0;
        while (numOfP == 0) {
            if (scan.hasNextInt()) {
                numOfP = scan.nextInt();
                if (numOfP == 1) {
                    System.out.println("Нет смысла ничего считать и делить");
                    numOfP = 0;
                } else if (numOfP < 1) {
                    System.out.println("Некорректное значение для подсчета");
                    numOfP = 0;
                }
            } else {
                scan.next();
                System.out.println("Ошибка. Введено неверное значение");
            }
        }
    }



    static Product getProd() {
        System.out.println("Укажите название товара");
        String name = scan.next();
        System.out.println("Введите стоимость товара в формате 'рубли,копейки'");
        float cost;
        while (true) {
            if (scan.hasNextFloat()) {
                cost = scan.nextFloat();
                if (cost <= 0) {
                    System.out.println("Значение некорректно");
                } else {
                    break;
                }
            } else {
                System.out.println("Данные введены некорректно");
                scan.next();
            }
        }
        return new Product(name, cost);
    }

    void makeList() {
        while (true) {
            System.out.println("Давайте добавим новый товар");
            Product newProd = Calculator.getProd();
            pList.add(newProd);
            totalCost += newProd.cost;
            System.out.println("Товар успешно добавлен в список!\nДобавили все товары? Напишите 'Завершить'\nХотите добавить новый товар? Введите любой символ");
            String cont;
            cont = scan.next();
            if ("завершить".equalsIgnoreCase(cont.trim())) {
                break;
            }
        }
    }

    public void printTotal() {
        System.out.println("Добавленные товары:");
        for (Product one : pList) {
            System.out.println(one.name);
        }
        FormatOut form = new FormatOut();
        float ans = (float) totalCost / numOfP;
        String ansCost = form.formatNum(ans);
        String ansRub = form.formatRub(ans);
        System.out.println("Каждый человек должен заплатить " + ansCost + " " + ansRub);
    }
}

