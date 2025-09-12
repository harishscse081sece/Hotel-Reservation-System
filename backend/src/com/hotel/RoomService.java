package com.hotel;

import java.util.ArrayList;

public class RoomService {
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomService() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    public ArrayList<Room> getAllRooms() { return rooms; }
}
