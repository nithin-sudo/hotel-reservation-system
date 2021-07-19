package com.bridgelabz.hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest
{
    HotelReservation hotelReservation = new HotelReservation();
    @Test
    public void addingMultipleHotels()
    {
        boolean isValidOne = hotelReservation.addHotelDetails("LakeWood",110);
        Assertions.assertTrue(isValidOne);
        boolean isValidTwo = hotelReservation.addHotelDetails("BridgeWood",160);
        Assertions.assertTrue(isValidTwo);
        boolean isValidThree = hotelReservation.addHotelDetails("RidgeWood",220);
        Assertions.assertTrue(isValidThree);
    }
}
