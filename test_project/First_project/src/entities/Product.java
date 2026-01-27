package entities;

public class Product {
    public String name;
    public double price;
    public int quant;

    public Product (String name, double price, int quant){
        this.name = name;
        this.price = price;
        this.quant = quant;
    }

    public String toString(){
        return "Product"
                + this.name
                + ", Price: "
                + this.price
                + ", Quant: "
                + this.quant;
    }

}
