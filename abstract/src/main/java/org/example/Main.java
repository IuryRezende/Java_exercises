package org.example;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numOfTaxPayers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numOfTaxPayers; i++){
            System.out.printf("%nTax payer #%d data: %n", i+1);

            System.out.print("Individual or company (i/c)? ");
            char typeOfPerson = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String nameOfPerson = sc.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if(typeOfPerson == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpend = sc.nextDouble();
                sc.nextLine();

                Person person = new PhysicalPerson(nameOfPerson, anualIncome, healthExpend);
                personList.add(person);

            } else {
                System.out.print("Number of employees: ");
                int numOfEmployees = sc.nextInt();
                sc.nextLine();

                Person person = new JuridicPerson(nameOfPerson, anualIncome, numOfEmployees);
                personList.add(person);
            }
        }

        System.out.println("TAXES PAID");
        for (Person p : personList){
            System.out.println(p.payTax());
        }

        sc.close();
    }
}