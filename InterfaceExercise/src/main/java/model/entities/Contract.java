package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private String number;
    private LocalDate data;
    private Double totalValue;
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private List<Installment> installmentList = new ArrayList<>();

    public Contract(){}

    public Contract(String number, LocalDate data, Double totalValue) {
        this.number = number;
        this.data = data;
        this.totalValue = totalValue;
    }

    public void addInstallment(Installment installment){
        installmentList.add(installment);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getInstallmentsReport(){
        StringBuilder sb = new StringBuilder();
        for (Installment i : installmentList){
            sb.append(i.getDueDate().format(fmt) + " - " + i.getAmount() + "\n");
        }

        return sb.toString();
    }
}
