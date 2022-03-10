public class Plane {

    private String name;
    private int hour_of_fuel;
    private int number_passenger;
    private int runway_time;

    public Plane(String name, int hour_of_fuel, int number_passenger, int runway_time) {
        this.name = name;
        this.hour_of_fuel = hour_of_fuel;
        this.number_passenger = number_passenger;
        this.runway_time = runway_time;
    }

    public int getHour_of_fuel() {
        return hour_of_fuel;
    }

    public void setHour_of_fuel(int hour_of_fuel) {
        this.hour_of_fuel = hour_of_fuel;
    }

    public int getNumber_passenger() {
        return number_passenger;
    }

    public void setNumber_passenger(int number_passenger) {
        this.number_passenger = number_passenger;
    }

    public int getRunway_time() {
        return runway_time;
    }

    public void setRunway_time(int runway_time) {
        this.runway_time = runway_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
