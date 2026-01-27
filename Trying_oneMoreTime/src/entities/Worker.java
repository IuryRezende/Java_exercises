package entities;

import enums.WorkerLevel;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    private int[] dateIncome = new int[2];

    public Worker(){

    }

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    private List<HourContract> verifyContract(int month, int year){
        List<HourContract> contractsInThePeriod = new ArrayList<>();

        for(HourContract c : contracts){
            int c_year = c.getLocalDate().getYear();
            int c_month = c.getLocalDate().getMonthValue();

            if (c_year == year && c_month == month){
                contractsInThePeriod.add(c);
            }

        }
        return contractsInThePeriod;
    }

    public double income(Integer month, Integer year){
        double sum = baseSalary;
        List<HourContract> contractsInThePeriod = new ArrayList<>();

        contractsInThePeriod = verifyContract(month, year);

        for (HourContract c: contractsInThePeriod){
            sum += c.totalValue();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateIncome(int month, int year){
        dateIncome[0] = month;
        dateIncome[1] = year;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getDepartment(){
        return department.toString();
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public String toString(){
        return "Name: " + name
                + "Department: " + department
                + "Income for " + dateIncome[0] + dateIncome[1];
    }
}
