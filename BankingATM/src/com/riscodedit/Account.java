package com.riscodedit;

public class Account {
    private long accountNumber;
    private float savingAccount;
    private float checkingAccount;
    private int pinNumber;

    public Account(long accountNumber, float savingAccount, float checkingAccount, int pinNumber) {
        this.accountNumber = accountNumber;
        this.savingAccount = savingAccount;
        this.checkingAccount = checkingAccount;
        this.pinNumber = pinNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(float savingAccount) {
        this.savingAccount = savingAccount;
    }

    public float getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(float checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
