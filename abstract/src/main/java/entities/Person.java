package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected String name;
    protected Double anualRent;
    private List<Person> personList = new ArrayList<>();

    public Person() {}

    public Person(Double anualRent, String name) {
        this.anualRent = anualRent;
        this.name = name;
    }

    public abstract String payTax();

    public void addTaxPayer(Person person){
        personList.add(person);
    }

}
