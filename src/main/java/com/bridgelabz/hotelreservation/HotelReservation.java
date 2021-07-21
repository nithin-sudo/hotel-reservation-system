package com.bridgelabz.hotelreservation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelReservation
{
    ArrayList<Hotel> hotelList = new ArrayList<>();
    /**
     * Created a array list name as hotelList. Created a method addHotel to add the
     * hotels in the array list.
     *
     * @param hotel
     */
    public void addHotelDetails(Hotel hotel)
    {
        hotelList.add(hotel);
    }

    /**
     * added weekday and wekend rates.
     * @param startDate
     * @param lastDate
     * @return
     */
    public Hotel getCheapestHotel(LocalDate startDate, LocalDate lastDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);
        int cheapRate;
        Hotel cheapest = Collections.min(hotelList, Comparator.comparing(hotel -> hotel.getRates()));
        cheapRate = (int) ((daysBetween + 1) * cheapest.getRates());
        System.out.println("Cheapest Hotel Name: " + cheapest.getHotelName() + "\nTotal Rate: " + cheapRate);
        return cheapest;
    }
}
