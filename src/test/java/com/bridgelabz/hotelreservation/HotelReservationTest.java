package com.bridgelabz.hotelreservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest
{
    HotelReservation hotelReservation = new HotelReservation();
    @Test
    public void addingMultipleHotels()
    {
        Hotel firstHotel = new Hotel("Lakewood",110 );
        Hotel secondHotel = new Hotel("Bridgewood",160);
        Hotel ThirdHotel = new Hotel("Ridgewood",220);
        hotelReservation.addHotelDetails(firstHotel);
        hotelReservation.addHotelDetails(secondHotel);
        hotelReservation.addHotelDetails(ThirdHotel);
        Assertions.assertEquals("Lakewood",hotelReservation.hotelList.get(0).getHotelName());
    }
}
