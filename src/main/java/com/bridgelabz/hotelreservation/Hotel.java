package com.bridgelabz.hotelreservation;

public class Hotel
{
    private String hotelName;
    private int rates;
    public Hotel(String hotelName,int rates)
    {
        this.hotelName = hotelName;
        this.rates = rates;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public int getRates()
    {
        return rates;
    }

    public void setRates(int rates)
    {
        this.rates = rates;
    }
}
