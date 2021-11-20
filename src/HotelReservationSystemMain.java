

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class HotelReservationSystemMain {
    ArrayList<Hotel> hotelList = new ArrayList<>();






    public boolean addHotel(String hotelName, int rating, double weekdayRateRegular, double weekendRateRegular)
    {
        Hotel hotels = new Hotel();

        hotels.setHotelName(hotelName);
        hotels.setRating(rating);
        hotels.setWeekdayRegularCustomerPrice(weekdayRateRegular);
        hotels.setWeekendRegularCustomerPrice(weekendRateRegular);

        hotelList.add(hotels);

        return true;
    }

    public String getCheapestHotel(LocalDate startDate, LocalDate endDate) {
        int weekendsDays = 0;
        int weekdaysNumber;
        int weekendsNumber;
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);


        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekendsDays;
                    break;
                case SUNDAY:
                    ++weekendsDays;
                    break;
            }
            startDate = startDate.plusDays(1);
        }

         weekdaysNumber = numberOfDays - weekendsDays;
         weekendsNumber = weekendsDays;

        double cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerPrice()*weekendsNumber) + hotel.getWeekdayRegularCustomerPrice()*weekdaysNumber))
                .min()
                .orElse(Double.MAX_VALUE);

        ArrayList<Hotel> cheapestHotelList = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRegularCustomerPrice()*weekendsNumber + hotel.getWeekdayRegularCustomerPrice()*weekdaysNumber) <= cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));


        if (cheapestPrice != Double.MAX_VALUE) {

            System.out.println("Cheapest Hotel : \n" + cheapestHotelList.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
            return cheapestHotelList.get(0).getHotelName();
        }
        return null;
    }



}
