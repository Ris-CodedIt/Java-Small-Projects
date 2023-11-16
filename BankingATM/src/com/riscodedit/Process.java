package com.riscodedit;

import java.util.HashMap;

public interface Process {

    float getBalance();
  ;
    float withdraw(float toWithdraw);

    float deposit(float toDeposit);
    HashMap<Long, Integer> initialize();

    boolean login();
    void setAccountType(String accountType);

}
