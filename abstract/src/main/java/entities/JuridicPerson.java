package entities;

public class JuridicPerson extends Person{

    private Integer numberOfEmployers;
    private Double tax;

    public JuridicPerson() { super(); }

    public JuridicPerson(String name, Double anualRent, Integer numberOfEmployers) {
        super(anualRent, name);
        this.numberOfEmployers = numberOfEmployers;
        tax = this.numberOfEmployers > 10 ? 0.14 : 0.16;
    }

    @Override
    public String payTax() {
        return name + ": $ " + String.format("%.2f", anualRent * tax);
    }

    public Integer getNumberOfEmployers() {
        return numberOfEmployers;
    }

    public void setNumberOfEmployers(Integer numberOfEmployers) {
        this.numberOfEmployers = numberOfEmployers;
    }
}
