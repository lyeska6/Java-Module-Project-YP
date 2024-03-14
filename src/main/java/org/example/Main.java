package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте! Я ваш калькулятор на этот вечер и я разделю ваш счёт.");
        Calculator calculator = new Calculator();
        calculator.makeList();
        calculator.printTotal();
        System.out.println("Спасибо за обращение. Буду ждать вас снова.");
    }

}

