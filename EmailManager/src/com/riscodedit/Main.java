package com.riscodedit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        String firstName;
        String lastname;

        System.out.println("Welcome to your email management system");

        System.out.print("May I have your first Name: ");
        firstName = mainScanner.nextLine();
        System.out.print("May I have your last name: ");
        lastname = mainScanner.nextLine();

        Email newEmail = new Email(firstName,lastname);

        MyProcessor2023 processor2023 = new MyProcessor2023(newEmail);

        processor2023.completeSetup();

        MenuProcessor menuProcessor = new MenuProcessor(processor2023);

        menuProcessor.firstMain();

    }
}
