package application;

import java.time.LocalDateTime;

import java.util.Scanner;
import entities.*;
import enums.OrderStatus;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        System.out.print("How many item to this order? ");
        int quantItems = sc.nextInt();
        sc.nextLine();

        Order order = new Order();
        order = new Order(LocalDateTime.now(), status, client);

        for (int i = 0; i < quantItems; i++){
            System.out.printf("Enter #%d item data:%n", i + 1);
            System.out.print("Product name: ");
            String prodName = sc.nextLine();

            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int prodQuant = sc.nextInt();
            sc.nextLine();

            Product product = new Product(prodName, prodPrice);
            OrderItem orderItem = new OrderItem(prodQuant, product);
            order.addItem(orderItem);
        }

        System.out.println(order.summary());
        System.out.println(order);





        sc.close();
    }
}