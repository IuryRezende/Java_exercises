package org.example.model;

public abstract class HumanModel {
    private String name;
    private double life;
    private int naturalDefense;
    private int naturalDodge;
    private int naturalMana;

    public HumanModel() {}

    public HumanModel(String name, double life, int naturalDefense ) {
        this.name = name;
        this.life += life;
        this.naturalDefense += naturalDefense;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getLife() { return life; }

    public void setLife(Double life) { this.life = life; }

    public double getNaturalDefense() { return naturalDefense; }

    public void setNaturalDefense(int naturalDefense) { this.naturalDefense = naturalDefense; }

    public void attack(){}

    public void defense(){}

    public void dodge(){}
}
