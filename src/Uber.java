import java.util.HashMap;
import java.util.Map;

public class Uber {

    static HashMap<String, Driver> registeredDriver = new HashMap<>();
    static HashMap<String, Rider> registeredRider = new HashMap<>();

    public void registerRider(Rider rider){
        registeredRider.put(rider.phone, rider);
    }

    public void registerDriver(Driver driver){
        registeredDriver.put(driver.phone, driver);
    }

    public Booking bookARide(Rider rider){
        Booking booking;
        for (Map.Entry<String, Driver> entry: registeredDriver.entrySet()) {
            Driver driver = entry.getValue();
            double distance;
            if (driver.status == Driver.STATUS.ONLINE) {
                distance = Booking.getDistance(driver.x, driver.y, rider.x, rider.y);
                if (distance <= 3) {
                    // book a ride here.
                    booking = new Booking(driver, rider);
                    System.out.println("you cab has been booked with " + driver.name);
                    System.out.println(driver.status);
                    return booking;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Uber uber = new Uber();
        Driver driver1, driver2;
        Rider rider1, rider2;

        rider1 = new Rider("abc", "123", 1, 1);
        rider2 = new Rider("abc", "321", 2, 2);

        driver1 = new Driver("dri1", "783", 3, 3, Driver.STATUS.ONLINE);
        driver2 = new Driver("dri1", "784", 4, 4, Driver.STATUS.ONLINE);

        uber.registerRider(rider1);
        uber.registerRider(rider2);

        uber.registerDriver(driver1);
        uber.registerDriver(driver2);

        Booking booking = uber.bookARide(rider1);
        booking.startTrip(2, 3);
        System.out.println(booking.status);
        booking.endTrip(5, 7);
        System.out.println(booking.status);
    }
}
