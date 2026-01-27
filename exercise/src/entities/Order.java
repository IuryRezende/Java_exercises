package entities;

import enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();

    public Order(){

    }
    public Order(LocalDateTime moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public String summary(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append(String.format("Order moment: %s%n", moment.format(fmt1)));
        sb.append(String.format("Order status: %s%n", status));
        sb.append("Client: ")
                .append(client.getName())
                .append(" ")
                .append(client.getBirthDate().format(fmt2))
                .append(" - ")
                .append(client.getEmail());

        return sb.toString();
    }


    public double totalValue(){
        double totalValue = 0;
        for (OrderItem o : orderItem){
            totalValue += o.subTotal();
        }
        return totalValue;
    }

    public void addItem(OrderItem orderItem){
        this.orderItem.add(orderItem);
    }
    public void removeItem(OrderItem orderItem){
        this.orderItem.remove(orderItem);
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() { return client; }

    public void setClient(Client client) {
        this.client = client;
    }

    public String orderItemToString(){
        StringBuilder sb = new StringBuilder();
        for (OrderItem o : orderItem){
            sb.append(o.getProductName())
                    .append(String.format(", $ %.2f, ", o.getPrice()))
                    .append(String.format("Quantity: %d, ", o.getQuantity()))
                    .append(String.format("Subtotal: %.2f%n", o.subTotal()));
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order items: \n")
                .append(orderItemToString())
                .append(String.format("Total price: $ %.2f", totalValue()));

        return sb.toString();
    }
}
