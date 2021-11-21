

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class HotelReservationSystemMain {
    ArrayList<Hotel> hotelList = new ArrayList<>();
    double cheapestPrice;






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
    ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate){

        ArrayList<Integer> durationDetails = new ArrayList<Integer>();
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate)+1;
        int weekends = 0;
        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
                default:
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        int weekdays = numberOfDays - weekends;
        durationDetails.add(weekdays);
        durationDetails.add(weekends);
        return durationDetails;

    }

    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {

        ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
        int weekdaysNumber = durationDetails.get(0);
        int weekendsNumber = durationDetails.get(1);

        cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerPrice() * weekendsNumber) + hotel.getWeekdayRegularCustomerPrice() * weekdaysNumber))
                .min()
                .orElse(Double.MAX_VALUE);

        ArrayList<Hotel> cheapestHotel = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRegularCustomerPrice() * weekendsNumber + hotel.getWeekdayRegularCustomerPrice() * weekdaysNumber) == cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));

        if (cheapestPrice != Double.MAX_VALUE) {
            Iterator<Hotel> iterator = cheapestHotel.iterator();
            System.out.println("Cheap Hotels : \n");
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
            }
            return cheapestHotel;
        }
        return null;
    }
     Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate){

        ArrayList<Hotel> cheapestHotels = getCheapestHotel(startDate, endDate);
        Optional<Hotel> sortedHotelList = cheapestHotels.stream().max(Comparator.comparing(Hotel::getRating));
        System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: " + cheapestPrice);
        return sortedHotelList.get();
    }
    Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate) {

        ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
        int weekdaysNumber = durationDetails.get(0);
        int weekendsNumber = durationDetails.get(1);
        Optional<Hotel> sortedHotelList = hotelList.stream().max(Comparator.comparing(Hotel::getRating));
        double totalPrice = weekdaysNumber*sortedHotelList.get().getWeekdayRegularCustomerPrice()+ weekendsNumber*sortedHotelList.get().getWeekendRegularCustomerPrice();
        System.out.println("Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: " + totalPrice);
        return sortedHotelList.get();
    }



}
