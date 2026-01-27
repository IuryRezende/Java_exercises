package model.entities;

import model.exceptions.TransactionException;

public class Account {
    private String number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() { }

    public Account(String number, String holder, Double balance, Double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }
    public void withdraw(Double amount){
        if (amount > withdrawLimit){
            throw new TransactionException("Withdraw error: The amount exceeds withdraw Limit");
        }
        if (amount > balance){
            throw new TransactionException("Withdraw error: The amount exceeds actual balance");
        }
        balance -= amount;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
