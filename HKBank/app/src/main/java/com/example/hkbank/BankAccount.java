package com.example.hkbank;

public class BankAccount {

    private String phone;
    private String email;
    private String accountHName;
    private String balance;
    private String pin;
    public int a = 60;

    void setPhone(String phone){
        this.phone = phone;
    }
    String getPhone(){
        return phone;
    }

    void setEmail(String email){
        this.email = email;
    }
    String getEmail(){
        return email;
    }

    void setAccountHName(String accountHName){
        this.accountHName = accountHName;
    }
    String getAccountHName(){
        return accountHName;
    }

    void setBalance(String balance){
        this.balance = balance;
    }
    String getBalance(){
        return balance;
    }

    void setPin(String pin){
        this.pin = pin;
    }
    String getPin(){
        return pin;
    }
}
