package org.example;

import model.entities.Reservation;
import model.exceptions.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Reservation reservation = new Reservation();

        try {
            System.out.print("Room number: ");
            String roomNumber = sc.nextLine();
            reservation.setRoomNumber(roomNumber);

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
            reservation.setCheckin(checkin);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);
            reservation.setCheckout(checkout);

            if (reservation.duration(checkin, checkout) < 1){
                throw new exceptions("Invalid date, the checkout may be minimun 1 day after");
            }

            System.out.println(reservation);


        } catch (exceptions e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}