public class Hotel {
    String hotelName;
    double weekendRegCost;
    double weekdayRegCost;
    int rating;
    public Hotel() {

    }
    public Hotel(String hotelName, int rating, double weekdayRegCustomerCost, double weekdayRewardCustomerCost,
                 double weekendRegCustomerCost, double weekendRewardCustomerCost) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayRegCost= weekdayRegCustomerCost;
        this.weekendRegCost = weekendRegCustomerCost;
    }
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

     int getRating() {
        return rating;
    }

     void setRating(int rating) {
        this.rating = rating;
    }

     double getWeekdayRegularCustomerPrice() {
        return weekdayRegCost;
    }

     void setWeekdayRegularCustomerPrice(double weekdayRegularCustomerCost) {
        this.weekdayRegCost = weekdayRegularCustomerCost;
    }

     double getWeekendRegularCustomerPrice() {
        return weekendRegCost;
    }

     void setWeekendRegularCustomerPrice(double weekendRegularCustomerCost) {
        this.weekendRegCost = weekendRegularCustomerCost;
    }
    double getRegularCustomeerPrice(){
        return weekdayRegCost+weekendRegCost;
    }
    @Override
    public String toString() {
        return "Hotels [hotelName=" + hotelName + ", rating=" + rating + ", weekdayRegularCustomerPrice="
                + weekdayRegCost + ", weekendRegularCustomerPrice=" + weekendRegCost + "]";
    }

}
