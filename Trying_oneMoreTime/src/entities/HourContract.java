package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
    private LocalDate date;
    private double valuePerHour;
    private Integer durationHours;

    public HourContract(){

    }
    public HourContract(String date, double valuePerHour, Integer durationHours) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valuePerHour = valuePerHour;
        this.durationHours = durationHours;
    }

    public double totalValue(){
        return valuePerHour * durationHours;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return durationHours;
    }

    public void setHours(Integer durationHours) {
        this.durationHours = durationHours;
    }
}
