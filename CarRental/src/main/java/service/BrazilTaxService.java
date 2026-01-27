package service;

public class BrazilTaxService {
    public BrazilTaxService() {}

    public double tax(double amount){
        return amount <= 100 ? amount * 0.2 : amount * 0.15;
    }
}
