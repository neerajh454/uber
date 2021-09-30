public class Driver extends User{

    private boolean isRiding;
    public STATUS status;

    enum STATUS {
        ONLINE, RIDING, OFFLINE;
    }

    public Driver(String name, String phone, double x, double y, STATUS status) {
        super(name, phone, x, y);
        this.status = status;
    }
    public void updateStatus(STATUS status){
        this.status = status;
    }
}
