package com.company;

public class Main {

    public static void main(String[] args) {

        int vasyaAge = 12;
        int mishaAge = 32;
        int mashaAge = 11;
        int min = vasyaAge;
        int middle = mishaAge;
        int max = mashaAge;
        int buf;

        if (min > middle) {
            buf = middle;
            middle = min;
            min = buf;

        }
        if (middle > max) {
            buf = max;
            max = middle;
            middle = buf;
        }
        if (min > middle) {
            buf = middle;
            middle = min;
            min = buf;
        }
        System.out.println("Minimal = " + min +
                "\nMiddle  = " + middle +
                "\nMaximum = " + max);

    }
}
