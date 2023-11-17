package com.riscodedit;

import java.util.Scanner;

public class MenuProcessor {
    private MyProcessor myProcessor;
    private Scanner menuScanner = new Scanner(System.in);

    public MenuProcessor(MyProcessor myProcessor) {
        this.myProcessor = myProcessor;
    }

    public void firstMain(){

        int firstChoice;
        System.out.println("Please select what you want to do");
        System.out.println("1. View My Info");
        System.out.println("2. Change Password");
        System.out.println("3. Change Alternative Mail");
        System.out.println("4. Change MailBox Capacity");
        System.out.println("5. Exit");
        System.out.print("Choice: ");
        try{
            firstChoice = this.menuScanner.nextInt();
        }catch (Exception e){
            System.out.println("Sorry invalid input");
            return;
        }

        switch (firstChoice){
            case 1:
               this.myProcessor.displayDetails();
               this.mainOrExit();
                break;
            case 2:
               this.myProcessor.changePassword();
                this.mainOrExit();
                break;
            case 3:
                this.myProcessor.changeAlternateEmail();
                this.mainOrExit();
                break;
            case 4:
                this.myProcessor.changeMailboxCapacity();
                this.mainOrExit();
                break;
            case 5:
                System.out.println("Thank you for you time");
                break;
            default:
                System.out.println("invalid choice");
                this.firstMain();
                break;
        }

}



    public void mainOrExit(){
        int lastChoice;
        System.out.println("Please select What you want to do next");
        System.out.println("1. Main Menu");
        System.out.println("2. Exit");
        System.out.print("Choice: ");
        try{
            lastChoice = this.menuScanner.nextInt();
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
