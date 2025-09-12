package com.hotel;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        RoomService roomService = new RoomService();
        ReservationService reservationService = new ReservationService();

        // Add sample customers
        Customer c1 = customerService.addCustomer("John Doe", "12345");
        Customer c2 = customerService.addCustomer("Jane Smith", "67890");

        // Book a room
        Reservation r1 = reservationService.bookRoom(c1, roomService.getAllRooms().get(0), 3);

        System.out.println("Current Reservations:");
        for (Reservation r : reservationService.getAllReservations()) {
            System.out.println(r.getCustomer().getName() + " booked room " + r.getRoom().getRoomNumber());
        }
    }
}
