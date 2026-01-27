package org.example;

import model.entities.Account;
import model.exceptions.TransactionException;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            String number = sc.nextLine();

            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            sc.nextLine();


            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();

            acc.withdraw(withdrawAmount);

            System.out.println("New balance: " + acc.getBalance());

        }catch (TransactionException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error: " + e.getMessage());
        }
        sc.close();


    }
}