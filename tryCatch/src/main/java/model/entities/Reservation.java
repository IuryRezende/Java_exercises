package model.entities;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Reservation {
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation() {}

    public Reservation(LocalDate checkin, LocalDate checkout, String roomNumber) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomNumber = roomNumber;
    }

    public long duration(LocalDate checkin, LocalDate checkout){
        long days = ChronoUnit.DAYS.between(checkin, checkout);
        return days;
    }

    public void updateDates(LocalDate checkin, LocalDate checkout){
        this.checkin = checkin;
        this.checkout = checkout;

    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: ")
                .append("Room " + roomNumber)
                .append(", check-in: " + checkin)
                .append(", check-out: " + checkout)
                .append(", " + duration(checkin, checkout) + " nights");

        return sb.toString();
    }
}
