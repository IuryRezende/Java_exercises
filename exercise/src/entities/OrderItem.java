package entities;

public class OrderItem {
    private int quantity = 0;
    private double price;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        setPrice(product.getPrice());
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName(){ return product.getName(); }

    public void setPrice(double price) {
        this.price = price;
    }

    public double subTotal(){
        return price * quantity;
    }


}
