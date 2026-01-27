package application;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


import entities.*;
import enums.WorkerLevel;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Department department = new Department();


        System.out.print("Enter departament's name: ");
        department.setName(sc.nextLine());

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();

        System.out.print("Base salary: ");
        double salary = sc.nextDouble();

        Worker person = new Worker(name, WorkerLevel.valueOf(level), salary, department);

        System.out.println("How many contracts to this worker? ");
        int quantContract = sc.nextInt();


        for (int i=0; i<quantContract; i++){
            sc.nextLine();
            System.out.printf("Enter contract #%d data:%n", i + 1);
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.nextLine();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (Hours): ");
            int durationHours = sc.nextInt();

            HourContract contract = new HourContract(date, valuePerHour, durationHours);
            person.addContract(contract);
        }
        sc.nextLine();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String dateIncome = sc.nextLine();
        int[] date = Arrays.stream(dateIncome.split("/")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Name: " + person.getName());
        System.out.println("Department: " + person.getDepartment());
        System.out.println("Income for: " + person.income(date[0], date[1]));



    }
}