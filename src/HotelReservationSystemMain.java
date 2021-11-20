import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;


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

    public  Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {
        Optional<Hotel> sortedHotelList = hotelList.stream().min(Comparator.comparing(Hotel::getRegularCustomeerPrice));
        return sortedHotelList.get();
    }



}
