public class Booking {
    private final Driver driver;
    private final Rider rider;
    private double endX, endY;
    public STATUS status;
    private long startAt;

    enum STATUS {
        BOOKED, CANCELLED, INPROCESS, COMPLETED;
    }

    public Booking(Driver driver, Rider rider) {
        this.driver = driver;
        this.rider = rider;
        this.status = STATUS.BOOKED;
        driver.updateStatus(Driver.STATUS.RIDING);
    }

    public static double getDistance(double startX, double startY, double endX, double endY){
            return Math.sqrt( Math.pow(startX-endX, 2) + Math.pow(startY-endY, 2));
    }

    public void endTrip(double x, double y){
        this.endX = x;
        this.endY = y;
        this.updateStatus(STATUS.COMPLETED);
    }

    public void updateStatus(STATUS status){
        this.status = status;
    }

    public void startTrip(double x, double y){
        this.endX = x;
        this.endY = y;
        this.startAt = System.currentTimeMillis();
        this.updateStatus(STATUS.INPROCESS);
    }
}
