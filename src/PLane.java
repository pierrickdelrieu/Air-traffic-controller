public class PLane {

    private int hour_fuel;
    private int number_passenger;
    private boolean is_waiting;
    private boolean is_landed;
    private int runway_time_needed;


    public int getHour_fuel() {
        return hour_fuel;
    }

    public void setHour_fuel(int hour_fuel) {
        this.hour_fuel = hour_fuel;
    }

    public int getNumber_passenger() {
        return number_passenger;
    }

    public void setNumber_passenger(int number_passenger) {
        this.number_passenger = number_passenger;
    }

    public boolean isIs_waiting() {
        return is_waiting;
    }

    public void setIs_waiting(boolean is_waiting) {
        this.is_waiting = is_waiting;
    }

    public boolean isIs_landed() {
        return is_landed;
    }

    public void setIs_landed(boolean is_landed) {
        this.is_landed = is_landed;
    }

    public int getRunway_time_needed() {
        return runway_time_needed;
    }

    public void setRunway_time_needed(int runway_time_needed) {
        this.runway_time_needed = runway_time_needed;
    }
}
