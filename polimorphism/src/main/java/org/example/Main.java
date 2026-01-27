package org.example;


import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee company = new Employee();

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfEmployees; i++){
            System.out.printf("%nEmployee #%d data%n", i+1);
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String employeeName = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();


            if (outsourced == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                Employee outsourcedEmployee = new OutsourcedEmployee(employeeName, hours, valuePerHour, additionalCharge);
                company.addEmployers(outsourcedEmployee);
            } else {
                Employee employee = new Employee(employeeName, hours, valuePerHour);
                company.addEmployers(employee);
            }
            sc.nextLine();

        }

        for (Employee e : company.getEmployers()){
            e.payment();
        }

        System.out.println("\n\nPAYMENT: ");
        for (Employee e : company.getEmployers()){
            System.out.print(e.toString());
        }

        sc.close();
    }
}