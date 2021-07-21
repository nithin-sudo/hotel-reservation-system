package com.bridgelabz.hotelreservation;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation
{
    ArrayList<Hotel> hotelList = new ArrayList<>();
    Map<String, Integer> minRateInRegular = new HashMap<>();
    Hotel result1;
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
    /**
     * weekEndData is a method through which calculate the cheapest hotel for
     * weekends also. dateList is use to store the date in the form of list traverse
     * the date list using advance for loop.
     * day of week is use to calculate the day at that particular date.
     * @return
     */
    public HashMap<String, Integer> weekEndData(LocalDate startDate, LocalDate lastDate) {
        List<LocalDate> dateList = startDate.datesUntil(lastDate).collect(Collectors.toList());
        dateList.add(lastDate);
        for (LocalDate localDate : dateList) {
            DayOfWeek dayOfWeek2 = DayOfWeek.from(localDate);
            if (dayOfWeek2.equals(DayOfWeek.SATURDAY) || dayOfWeek2.equals(DayOfWeek.SUNDAY)) {
                for (Hotel hotel : hotelList) {
                    hotel.totalRegularRate += hotel.getRates();
                }
            } else {
                for (Hotel hotel : hotelList) {
                    hotel.totalRegularRate += hotel.getRates();
                }
            }
        }
        result1 = hotelList.get(0);
        for (Hotel hotel : hotelList) {
            if (result1.totalRegularRate > hotel.totalRegularRate) {
                result1 = hotel;
                minRateInRegular.put(hotel.getHotelName(), hotel.totalRegularRate);
            }
        }
        minRateInRegular.put(result1.getHotelName(), result1.totalRegularRate);
        for (Hotel hotel : hotelList) {
            if (hotel.totalRegularRate == result1.totalRegularRate) {
                minRateInRegular.put(hotel.getHotelName(), hotel.totalRegularRate);
            }
        }
        return null;
    }

    /**
     * this function is use to find the cheapest hotel.
     * @return
     */
    public List<Map.Entry<String, Integer>> findCheapestRegularHotels(LocalDate startDate, LocalDate lastDate) {
        weekEndData(startDate, lastDate);
        System.out.println("Min Rate Hotels");
        minRateInRegular.forEach((key, value) -> System.out.println("Hotel Name: " + key + "\nTotal Rate: " + value));

        return null;
    }

    /**
     * adding hotel ratings
     * @param hotel
     * @param rating
     */
    public void hotelRatings(Hotel hotel,int rating)
    {
        hotel.setRatings(rating);
    }
    public HashMap<Integer, List<Map.Entry<String, Integer>>> cheapestBestRatedHotel(LocalDate startDate, LocalDate endDate)
    {
        try
        {
            HashMap<String, Integer> cheapHotelsWithBestRating = new HashMap<String, Integer>(); //created list for hotels having minimum rating
            List<Map.Entry<String, Integer>> cheapHotels = findCheapestRegularHotels(startDate, endDate);
            for (Hotel hotel : hotelList)
            {
                for (Map.Entry<String, Integer> cheapHotel : cheapHotels)
                {
                    if (cheapHotel.getKey().equals(hotel.getHotelName()))
                    {
                        cheapHotelsWithBestRating.put(hotel.getHotelName(),hotel.getRatings());
                    }
                }
            }
            int maxRating = cheapHotelsWithBestRating.entrySet().stream().max((entry1,entry2) -> entry1.getValue().compareTo(entry2.getValue())).get().getValue();
            List<Map.Entry<String, Integer>> maxRatedHotel = cheapHotelsWithBestRating.entrySet().stream().filter(price -> price.getValue().equals(maxRating)).collect(Collectors.toList());
            HashMap<Integer ,List<Map.Entry<String, Integer>>> bestRatedHotels = new HashMap<Integer, List<Map.Entry<String,Integer>>>();
            bestRatedHotels.put(cheapHotels.get(0).getValue(), maxRatedHotel);
            return bestRatedHotels;
        }
        catch (Exception e)
        {
            System.out.println("Invalid dates");
            return null;
        }
    }
    public HashMap<Integer, List<Map.Entry<String, Integer>>> bestRatingHotel(LocalDate startDate, LocalDate endDate)
    {
        HashMap<String, Integer> hotelPricesList = weekEndData(startDate, endDate);
        HashMap<String, Integer> hotelsWithBestRating = new HashMap<String, Integer>(); //created list for hotels having minimum rating
        for (Hotel hotel : hotelList)
        {
            hotelsWithBestRating.put(hotel.getHotelName(),hotel.getRatings());
        }
        List<Map.Entry<String, Integer>> maxRatedHotel = getBestRated(hotelsWithBestRating);
        HashMap<Integer ,List<Map.Entry<String, Integer>>> bestRatedHotels = new HashMap<Integer, List<Map.Entry<String,Integer>>>();
        bestRatedHotels.put(hotelPricesList.get(maxRatedHotel.get(0).getKey()), maxRatedHotel);
        return bestRatedHotels;
    }
    private List<Map.Entry<String, Integer>> getBestRated(HashMap<String, Integer> hotelsWithBestRating)
    {
        int maxRating = hotelsWithBestRating.entrySet().stream().max((entry1,entry2) -> entry1.getValue().compareTo(entry2.getValue())).get().getValue();
        List<Map.Entry<String, Integer>> maxRatedHotel = hotelsWithBestRating.entrySet().stream().filter(price -> price.getValue().equals(maxRating)).collect(Collectors.toList());
        return maxRatedHotel;
    }
}
