package com.bridgelabz.hotelreservation;

public class Hotel
{
    private String hotelName;
    private int rates;
    private int weekDayRatesForRewards ;
    private int weekendRatesForRegular;
    private int weekendRatesForRewards;

    public Hotel(String hotelName, int rates, int weekDayRatesForRewards, int weekendRatesForRegular, int weekendRatesForRewards) {
        this.hotelName = hotelName;
        this.rates = rates;
        this.weekDayRatesForRewards = weekDayRatesForRewards;
        this.weekendRatesForRegular = weekendRatesForRegular;
        this.weekendRatesForRewards = weekendRatesForRewards;
    }

    public int getWeekDayRatesForRewards() {
        return weekDayRatesForRewards;
    }

    public void setWeekDayRatesForRewards(int weekDayRatesForRewards) {
        this.weekDayRatesForRewards = weekDayRatesForRewards;
    }

    public int getWeekendRatesForRegular() {
        return weekendRatesForRegular;
    }

    public void setWeekendRatesForRegular(int weekendRatesForRegular) {
        this.weekendRatesForRegular = weekendRatesForRegular;
    }

    public int getWeekendRatesForRewards() {
        return weekendRatesForRewards;
    }

    public void setWeekendRatesForRewards(int weekendRatesForRewards) {
        this.weekendRatesForRewards = weekendRatesForRewards;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }
}
