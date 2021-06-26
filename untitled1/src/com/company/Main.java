package com.company;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;

public class Main {

    public static void out(int number) {
        System.out.println(number);

    }

    public static int ink(int number2) {
        return ++number2;

    }
    public static int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    public static void main(String[] args) {
        int b = input();

        b = ink(b);

        out(b);

    }


}


