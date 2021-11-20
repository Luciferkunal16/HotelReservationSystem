import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelReservationSystemTest {

    @Test
    public void givenHotelDetailsWhenValuesAreEntered_ShoulReturnTrue() {

        HotelReservationSystemMain hotelReservation = new HotelReservationSystemMain();
        boolean HotelTest1 = hotelReservation.addHotel("Lakewood", 5, 110, 90);
        Assert.assertTrue(HotelTest1);
        boolean HotelTest2 = hotelReservation.addHotel("Bridgewood", 3, 16, 60);
        Assert.assertTrue(HotelTest2);

    }
    @Test
    public void givenHotel_shouldReturnCheapHotel(){

        HotelReservationSystemMain hotelReservation = new HotelReservationSystemMain();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 3, 160, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = hotelReservation.getCheapestHotel(startDate, endDate);
        Assert.assertEquals("Lakewood", hotelName);
    }
}
