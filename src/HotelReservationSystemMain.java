import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystemMain {
    ArrayList<Hotel> hotelList = new ArrayList<>();

    Hotel hotels;



    public void addHotel(String hotelName,int rating, double weekdayRateRegular, double weekendRateRegular)
    {
        hotels = new Hotel();
        hotels.setHotelName(hotelName);
        hotels.setRating(rating);
        hotels.setWeekdayRegularCustomerPrice(weekdayRateRegular);
        hotels.setWeekendRegularCustomerPrice(weekendRateRegular);

        hotelList.add(hotels);

    }


}
