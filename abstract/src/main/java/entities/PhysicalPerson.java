package entities;

public class PhysicalPerson extends Person{

    private Double healthCosts;
    private Double tax;

    public PhysicalPerson() { super(); }

    public PhysicalPerson(String name, double anualRent, Double healthCosts) {
        super(anualRent, name);
        this.healthCosts = healthCosts;
        tax = this.anualRent >= 20000.00 ? 0.25 : 0.15;
    }

    @Override
    public String payTax(){

        return name + ": $ " + String.format("%.2f", (anualRent * tax) - (healthCosts * 0.5));
    }


}
