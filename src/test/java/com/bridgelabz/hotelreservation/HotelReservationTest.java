package com.bridgelabz.hotelreservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTest
{
    HotelReservation hotelReservation = new HotelReservation();
    /**
     * This test method is use to check , if the hotel is added the return true .
     */
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
    /**
     * This method is used to check the cheapest hotel between the given data range
     *
     */
    @Test
    public void givenDateRange_ShouldReturnCheapestHotel() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate lastDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        Hotel cheapestHotel = hotelReservation.getCheapestHotel(startDate, lastDate);
        Assertions.assertEquals("LakeWood", cheapestHotel.getHotelName());
    }
}
