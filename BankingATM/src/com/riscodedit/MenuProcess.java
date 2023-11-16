package com.riscodedit;

import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class MenuProcess {
    private Process process;

    public MenuProcess(Process process) {
        this.process = process;
    }


    public void  EntryPart(){
        boolean loggedIn = this.process.login();


        if(!loggedIn){
            System.out.println("Sorry, looks like you gave a wrong account or pin");
            return;
        }
        firstMain();

    }
    public void firstMain(){
        Scanner scanner = new Scanner(System.in);
        int firstChoice;
        System.out.println("Please select the account you want to access");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.println("3. Exit");
        System.out.print("Choice: ");
        try{
            firstChoice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }

        switch (firstChoice){
            case 1:
                this.process.setAccountType("savings");
                getSelectedAccount(true);
                break;
            case 2:
                this.process.setAccountType("checking");
                getSelectedAccount(false);
                break;
            case 3:
                System.out.println("Thank you for your time.");
                break;

            default:
                System.out.println("invalid choice");
                break;
        }


    }

    public void getSelectedAccount(boolean Savings){
        Scanner scanner = new Scanner(System.in);
        String accountName = Savings ? "Savings Account" : "Checking Account";
        int secondChoice;
        System.out.println("Please select What you want to do in you "+ accountName);
        System.out.println("1. Make Deposit");
        System.out.println("2. Make Withdrawal");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
        try{
            secondChoice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }
        switch (secondChoice){
            case 1:
                makeDeposit(Savings);
                break;
            case 2:
                makeWithDrawall(Savings);
                break;


            case 3:
                checkBalance(Savings);
                break;

            case 4:
                System.out.println("Thank you for your time.");
                break;

            default:
                System.out.println("invalid choice");
                break;
        }
    }


    public void makeDeposit(boolean Savings){
        Scanner scanner = new Scanner(System.in);
        NumberFormat numberFormater = NumberFormat.getCurrencyInstance(Locale.US);
        float ammount;
        float newBalance;
        System.out.println("enter the amount you want to deposit");
        try{
            ammount = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }



        newBalance = this.process.deposit(ammount);
        if(Savings){
            System.out.println("Your current Savings Account balance is: "+ numberFormater.format(newBalance));
            mainOrExit();
            return;
        }
        System.out.println("Your current Checking Account balance is: "+ numberFormater.format(newBalance));
        mainOrExit();
        return;
    }

    public void makeWithDrawall(boolean Savings){
        Scanner scanner = new Scanner(System.in);
        NumberFormat numberFormater = NumberFormat.getCurrencyInstance(Locale.US);
        float ammount;
        float newBalance;
        System.out.println("enter the amount you want to Withdraw");
        try{
            ammount = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }



        newBalance = this.process.withdraw(ammount);
        if(Savings){
            System.out.println("Your current Savings Account balance is: "+ numberFormater.format(newBalance) +"after withdrawing" + numberFormater.format(ammount));
            mainOrExit();
            return;
        }
        System.out.println("Your current Checking Account balance is: "+ numberFormater.format(newBalance)+"after withdrawing" + numberFormater.format(ammount));
        mainOrExit();
        return;
    }

    public void checkBalance(boolean Savings){
        NumberFormat numberFormater = NumberFormat.getCurrencyInstance(Locale.US);
        float newBalance = this.process.getBalance();
        if(Savings){
            System.out.println("Your current Savings Account balance is: "+ numberFormater.format(newBalance));
            mainOrExit();
            return;
        }
        System.out.println("Your current Checking Account balance is: "+ numberFormater.format(newBalance));
        mainOrExit();
        return;
    }

    public void mainOrExit(){
        Scanner scanner = new Scanner(System.in);
        int lastChoice;
        System.out.println("Please select What you want to do next");
        System.out.println("1. Main Menu");
        System.out.println("2. Exit");
        System.out.print("Choice: ");
        try{
            lastChoice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }

        switch (lastChoice){
            case 1:
                this.firstMain();
                break;
            case 2:
                System.out.println("Thank you for your time.");
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
    }
}
