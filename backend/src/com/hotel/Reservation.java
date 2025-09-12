package com.hotel;

public class Reservation {
    private Customer customer;
    private Room room;
    private int days;

    public Reservation(Customer customer, Room room, int days) {
        this.customer = customer;
        this.room = room;
        this.days = days;
        room.setAvailable(false);
    }

    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public int getDays() { return days; }
    public int getTotalCost() { return days * 1000; } // Simple cost calculation
}
