package model.entities;

import exceptions.TimeException;

import javax.print.DocFlavor;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarRental {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private LocalDateTime start;
    private LocalDateTime finish;

    private Vehicle vehicle;
    private Invoice invoice;

    private void checkTimeException(LocalDateTime start, LocalDateTime finish) throws TimeException{
        if (finish.isBefore(start)){
            throw new TimeException("Error: the finish date can't be before start date");
        }
    }

    public CarRental() {}

    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) throws TimeException{

        checkTimeException(start, finish);

        this.finish = finish;
        this.start = start;
        this.vehicle = vehicle;
    }

    public LocalDateTime getFinish() { return finish; }

    public void setFinish(LocalDateTime finish) throws TimeException{
        checkTimeException(start, finish);
        this.finish = finish;
    }

    public LocalDateTime getStart() { return start; }

    public void setStart(LocalDateTime start) throws TimeException {
        this.start = start;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getFatura(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nFATURA: \n")
                .append(String.format("BasicPayment: $ %.2f\n", invoice.getBasicPayment()))
                .append(String.format("Tax: $ %.2f\n", invoice.getTax()))
                .append(String.format("Total payment: %.2f", invoice.getTotalPayment()));

        return sb.toString();
    }
}
