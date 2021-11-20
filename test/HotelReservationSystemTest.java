import org.junit.Assert;
import org.junit.Test;

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
}
