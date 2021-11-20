import java.util.ArrayList;

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



}
