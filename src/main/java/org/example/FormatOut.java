package org.example;

public class FormatOut {

    static String formatNum(float n) {
        return String.format("%.2f", n);
    }

    static String formatRub(float n) {
        int fn = (int) n;
        int fnn = fn % 10;
        if (((fn >= 11)&&(fn <=14))||((fnn >= 5)||(fnn == 0))) {
            return "рублей";
        } else if (fnn == 1) {
            return "рубль";
        } else {
            return "рубля";
        }
    }

}
