package service;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilTaxService brazilTaxService = new BrazilTaxService();

    public RentalService() {}

    public RentalService(Double pricePerDay, Double pricePerHour) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    public void processInvoice(CarRental carRental){
        double basicPayment;

        long quantDays = ChronoUnit.DAYS.between(carRental.getStart(), carRental.getFinish());
        long quantHours = ChronoUnit.HOURS.between(carRental.getStart(), carRental.getFinish());

        if (quantHours != 0L && quantHours % quantDays != 0){
            quantDays += 1;
            basicPayment = quantDays * pricePerDay;
        } else {
            basicPayment = quantHours * pricePerHour;
        }

        double tax = brazilTaxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
