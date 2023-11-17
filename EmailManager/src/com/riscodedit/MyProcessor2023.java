package com.riscodedit;

import java.util.Scanner;

public class MyProcessor2023 implements MyProcessor{

    private Email email;
    private Scanner processorScanner = new Scanner(System.in);

    public MyProcessor2023(Email email) {
        this.email = email;
    }
    @Override
    public void completeSetup() {
        this.email.setPassword(this.generatePassword());
        this.setDepartment();
    }
    @Override
    public void setDepartment() {
        System.out.println("Please choose department\n1. Sales\n2. Development\n3. Accounting\n0. none\nChoice: ");
        int deptChoice;
        while(true){
            try {
                deptChoice = this.processorScanner.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("only numeric values are allowed");
            }
        }

        switch (deptChoice) {
            case 0:
                this.email.setDepartment("None");
                break;
            case 1:
                this.email.setDepartment("Sales");
                break;
            case 2:
                this.email.setDepartment("Development");
                break;
            case 3:
                this.email.setDepartment("Accounting");
                break;
            default:
                System.out.println("invalid Input, Try again");
                this.setDepartment();
                break;
        }
    }

    @Override
    public String generatePassword() {
        final int PASSWORD_LENGTH = 8;
        String passwordCharacters = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789qwertyuiopasdfghjklzxcvbnm@#$&";
        // generating an 8 character password;

        char[] password = new char[PASSWORD_LENGTH];
        for(int i=0; i<PASSWORD_LENGTH;i++){
            int rand = (int)(Math.random()*passwordCharacters.length());
            password[i] = passwordCharacters.charAt(rand);
        }

        return new String(password);
    }


    @Override
    public int checkMailboxCapacity() {
        return this.email.getMailboxCapacity();
    }



    @Override
    public void changePassword() {
        String newPassword;
        System.out.println("Can I have your new password, must be at least 8 characters long");
        while(true){
            newPassword = processorScanner.nextLine();
            if(newPassword.length() >= 8){
                break;
            }
            System.out.println("The password is not 8 characters long, please try again:");
        }

        this.email.setPassword(newPassword);
        System.out.println("Your new Password has been set as:" + newPassword);

    }

    @Override
    public void changeMailboxCapacity() {
        System.out.println("your current mail box capacity is: " + this.email.getMailboxCapacity());
        System.out.println("Please enter the new capacity you want");

        int newCapacity;

        while (true){
            try{
                newCapacity = processorScanner.nextInt();
                break;
            }
            catch (Exception e){
                System.out.println("only numeric values are allowed");
            }
        }

        this.email.setMailboxCapacity(newCapacity);
        System.out.println("Your new mailbox capacity is:" + newCapacity);

    }

    @Override
    public void changeAlternateEmail() {
        System.out.println("sorry this feature is coming soon");
    }

    @Override
    public void displayDetails() {
        System.out.println("Listed below are your details please take note of them.");
        System.out.println("First Name: " + this.email.getFirstName());
        System.out.println("Last Name: "+ this.email.getLastName());
        System.out.println("Department: " + this.email.getDepartment());
        System.out.println("Email: " + this.email.getEmail());
        System.out.println("Password: "+ this.email.getPassword());
        System.out.println("Mailbox Capacity: "+ this.email.getMailboxCapacity()+"MB");
        System.out.println("Alternative Email: "+ this.email.getAlternateEmail());

    }
}
