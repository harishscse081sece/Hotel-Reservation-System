package com.hotel;

import java.util.ArrayList;

public class ReservationService {
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Reservation bookRoom(Customer customer, Room room, int days) {
        if (room.isAvailable()) {
            Reservation r = new Reservation(customer, room, days);
            reservations.add(r);
            return r;
        } else {
            return null; // Room not available
        }
    }

    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }
}
