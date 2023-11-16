package com.riscodedit;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Process2023 implements Process{

    private  Account account;
    private  String  accountType;
    private float  toWithdrawOrDeposit;


    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public Process2023() {

    }



    @Override
    public float getBalance() {
        if(this.accountType.equals("checking")){
            return this.account.getCheckingAccount();
        } else if(this.accountType.equals("savings")) {
            return this.account.getSavingAccount();
        }
        throw new IllegalArgumentException("please select a valid account type");
    }

    @Override
    public float withdraw(float toWithdraw) {
        float balance;
        float difference;
        if(this.accountType.equals("checking")){
            balance =  this.account.getCheckingAccount();
            if(balance< toWithdraw)
                throw new IllegalArgumentException("the amount you are trying to withdraw is greater than your account balance");

             difference = balance- toWithdraw;

            this.account.setCheckingAccount(difference);
            return  difference;

        } else if(this.accountType.equals("savings")) {
            balance =  this.account.getSavingAccount();
            if(balance< toWithdraw)
                throw new IllegalArgumentException("the amount you are trying to withdraw is greater than your account balance");

            difference = balance- toWithdraw;

            this.account.setSavingAccount(difference);
            return  difference;
        }
        throw new IllegalArgumentException("please select a valid account type");
    }

    @Override
    public float deposit(float toDeposit) {
        if(toDeposit<= 0)
            throw new IllegalArgumentException("Deposit amount should be greater than 0");
        if(this.accountType.equals("checking")){
            this.account.setCheckingAccount(this.account.getCheckingAccount()+toDeposit);
            return this.account.getCheckingAccount();
        } else if(this.accountType.equals("savings")) {
            this.account.setSavingAccount(this.account.getSavingAccount()+toDeposit);
            return this.account.getSavingAccount();
        }
        throw new IllegalArgumentException("please select a valid account type");
    }

    @Override
    public HashMap<Long, Integer> initialize() {
// this is to initialise values to use when login in
        HashMap<Long, Integer> loginAccounts = new HashMap<Long, Integer>();
        loginAccounts.put(9678994355L,1924);
        loginAccounts.put(9678994344L,1945);
        loginAccounts.put(9678994366L,1966);

        return loginAccounts;
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        long loginAcc;
        int loginPin;
        boolean loggedIn = false;
        while(true){
            try{
                System.out.print("Please enter your account number");
                loginAcc = scanner.nextLong();
                System.out.print("Please enter your pin number");
                loginPin = scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("please note that only numeric values are accepted");
            }
        }

        HashMap<Long,Integer> accountList = this.initialize();

        for(Entry<Long,Integer> account : accountList.entrySet()){
            if(account.getKey() == loginAcc && account.getValue() == loginPin)
                loggedIn = true;
        }


        this.account = new Account(loginAcc,0.0F,0.0F,loginPin);


    return loggedIn;



    }
}
