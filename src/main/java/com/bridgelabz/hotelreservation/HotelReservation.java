package com.bridgelabz.hotelreservation;
import java.util.ArrayList;

public class HotelReservation
{
    ArrayList<Hotel> hotelList = new ArrayList<>();
    public boolean addHotelDetails(String hotelName, int rates)
    {
        hotelList.add(new Hotel(hotelName,rates));
        return true;
    }
}
