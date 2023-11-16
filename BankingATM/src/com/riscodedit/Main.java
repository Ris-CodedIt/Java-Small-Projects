package com.riscodedit;

public class Main {
    public static void main(String[] args) {
        MenuProcess processFlow = new MenuProcess(new Process2023());

        System.out.println("Welcome, please enjoy your journey.");
        try{
            processFlow.EntryPart();
        }catch (Exception e){
            System.out.println("oops error: " + e.getMessage());
        }

    }
}
