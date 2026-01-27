package org.example;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.*;
import exceptions.TimeException;
import service.RentalService;

public class Main {

    public static String limpar(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").start().waitFor();
            return "Deu certo";
        } catch (Exception e){
            return "Deu errado";
        }
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        CarRental cr = new CarRental();
        RentalService service = new RentalService();

        while (true) {
            try {
                System.out.println(limpar());
                System.out.println("\nEntre com os dados do aluguel");
                System.out.print("Modelo do carro: ");
                String carModel = sc.nextLine();
                cr.setVehicle(new Vehicle(carModel));

                System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
                LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
                cr.setStart(start);

                System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
                LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
                cr.setFinish(finish);

                System.out.print("Entre com o preço por hora: ");
                double pricePerHour = sc.nextDouble();
                service.setPricePerHour(pricePerHour);

                System.out.print("Entre com o preço por dia: ");
                double pricePerDay = sc.nextDouble();
                service.setPricePerDay(pricePerDay);

                service.processInvoice(cr);

                System.out.println(cr.getFatura());

                sc.close();
                break;

            } catch (TimeException e) {
                System.out.println("Error: " + e);

            } catch (RuntimeException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
