package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    // arrange
    public static void checkIn_should_Check_in(){
        Room availableRoom = new Room(2, 139.00, true, false, false);
        assertTrue(availableRoom.isAvailable());
        availableRoom.checkIn();
        assertFalse(availableRoom.isAvailable());
    }

    public static void checkIn_should_NotCheck_in_Because_Dirty(){
        Room dirtyRoom = new Room(2, 124.00, false, true, false);
        assertNotEquals(true, dirtyRoom.isAvailable());
        assertTrue(dirtyRoom.isDirty());
        dirtyRoom.checkIn();
        assertNotEquals(true, dirtyRoom.isAvailable());
        assertTrue(dirtyRoom.isDirty());
        dirtyRoom.cleanRoom();
        assertTrue(dirtyRoom.isAvailable());
        assertFalse(dirtyRoom.isDirty());
    }

    public static void checkIn_should_NotCheck_in_Because_Occupied(){
        Room occupiedRoom = new Room(2, 139.00, false, true, true);
        assertNotEquals(true, occupiedRoom.isAvailable());
        assertTrue(occupiedRoom.isOccupied());
        occupiedRoom.checkIn();
        assertNotEquals(true, occupiedRoom.isAvailable());
        assertTrue(occupiedRoom.isOccupied());
        occupiedRoom.checkOut();
        assertFalse(occupiedRoom.isOccupied());
    }

    public static void main(String[] args) {
        checkIn_should_Check_in();
        checkIn_should_NotCheck_in_Because_Dirty();
        checkIn_should_NotCheck_in_Because_Occupied();
    }

}