package entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;
    private List<Employee> employers = new ArrayList<>();

    public Employee() { }

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public double payment(){ return hours * valuePerHour; }

    public void addEmployers(Employee employee){ employers.add(employee); }

    public List<Employee> getEmployers(){ return employers; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getHours() { return hours; }

    public void setHours(Integer hours) { this.hours = hours; }

    public Double getValuePerHour() { return valuePerHour; }

    public void setValuePerHour(Double valuePerHour) { this.valuePerHour = valuePerHour; }

    @Override
    public String toString(){ return getName() + " - $ " + payment() + "\n"; }
}
