package Element;

import RunwayWaiting.Runway;
import RunwayWaiting.RunwayController;
import RunwayWaiting.WaitingPlaneController;

public class Plane extends Element {

    enum PlaneType {WAITING, LANDED} ;
    public final int MAXFUEL = 24;

    private final String name;
    private int hourOfFuel;
    private final int nbPassenger;

    public Plane(String name, int hourOfFuel, int nbPassenger, int time) {
        super(time);
        this.name = name;
        this.hourOfFuel = hourOfFuel;
        this.nbPassenger = nbPassenger;
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

    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public boolean land() {
        Runway runway = RunwayController.getEmptyRunway();

        if (runway != null) {
            WaitingPlaneController.removePlane(this);
            runway.addElement(this);
            return true;
        }

        return false;
    }


    public String toString(PlaneType type) {
        if (type == PlaneType.WAITING) {
            return this.name + ": \n" +
                    this.hourOfFuel + " hour of fuel // " + this.nbPassenger + " passengers // " + this.getRunwayTime() + " hour needed on runway\n";
        } else if (type == PlaneType.LANDED) {
            return this.name + ": \n" +
                    this.getRunwayTime() + "h remaining \n";
        }
        return "";
    }

}
