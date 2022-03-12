package Element;

public class Plane extends Element {

    enum PlaneType {WAITING, LANDED} ;


    private final String name;
    private int hourOfFuel;
    private final int nbPassenger;
    private int runwayTime;
    public final int MAXFUEL = 24;

    public Plane(String name, int hour_of_fuel, int number_passenger, int runway_time) {
        this.name = name;
        this.hourOfFuel = hour_of_fuel;
        this.nbPassenger = number_passenger;
        this.runwayTime = runway_time;
    }

    public int getHourOfFuel() {
        return hourOfFuel;
    }

    public void setHourOfFuel(int hour_of_fuel) {
        this.hourOfFuel = hour_of_fuel;
    }

    public int getNbPassenger() {
        return nbPassenger;
    }

    public int getRunwayTime() {
        return runwayTime;
    }

    public void setRunwayTime(int runway_time) {
        this.runwayTime = runway_time;
    }

    public String getName() {
        return name;
    }


    public String toString(PlaneType type) {
        if (type == PlaneType.WAITING) {
            return this.name + ": \n" +
                    this.hourOfFuel + " hour of fuel // " + this.nbPassenger + " passengers // " + this.runwayTime + " hour needed on runway\n";
        } else if (type == PlaneType.LANDED) {
            return this.name + ": \n" +
                    this.runwayTime + "h remaining \n";
        }
        return "";
    }

}
