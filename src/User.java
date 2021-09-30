public abstract class User {
    String name;
    String phone;
    double x, y;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getX() {
        return x;
    }

    public User(String name, String phone, double x, double y) {
        this.name = name;
        this.phone = phone;
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void updateLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
}
