package AiTravelController.Element;

import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.UI.MenuType;

import java.util.Random;


public class Plane extends Element {

    private final String name;
    private int hourOfFuel;
    private final int nbPassenger;

    public Plane(int hourOfFuel, int nbPassenger, int time) {
        super(time);
        Random rand = new Random();
        this.hourOfFuel = hourOfFuel;
        this.nbPassenger = nbPassenger;
        this.name = "PL" + rand.nextInt(10) + this.hourOfFuel + rand.nextInt(10) + getRunwayTime();
//        this.name = "PL" + this.hourOfFuel + getRunwayTime() + getNbPassenger();

    }


    /**
     * @return an integer which corresponds to the hour of fuel of the plane
     */
    public int getHourOfFuel() {
        return hourOfFuel;
    }

    /**
     * Setter of hour of fuel of the plane
     * @param hour : integer which corresponds to the new value of hourOfFuel
     */
    public void setHourOfFuel(int hour) {
        this.hourOfFuel = hour;
    }

    /**
     * @param hour : integer which corresponds to the number of fuel hour to add for a plane
     */
    public void increaseHourOfFuel(int hour) {
        this.hourOfFuel += hour;
    }

    /**
     * @param hour : integer which corresponds to the number of fuel hour to remove for a plane
     */
    public void decreaseHourOfFuel(int hour) {
        this.hourOfFuel -= hour;
    }


    /**
     * @return in number of passages on board the plane
     */
    public int getNbPassenger() {
        return nbPassenger;
    }

    /**
     * @return String name of the plane
     */
    public String getName() {
        return name;
    }

    /**
     * Landing of an plane. Removal of the plane from the list of waiting plane and addition of the plane on an empty runway
     * @return true if the plane has been done and false otherwise
     */
    public boolean land() {
        if (RunwayController.getInstance().getNbEmptyRunway() != 0) {
            Runway runway = RunwayController.getInstance().getNEmptyRandomRunway(1)[0];
            WaitingPlaneController.removePlane(this);
            runway.addElement(this);
            return true;
        }

        return false;
    }


    @Override
    public String toString(MenuType type) {
        if (type == MenuType.WAITING) {
            return this.name + ": \n" +
                    this.hourOfFuel + " hour of fuel || " + this.nbPassenger + " passengers || " + this.getRunwayTime() + " hour needed on runway\n";
        } else if (type == MenuType.LANDING) {
            return "PLANE " + this.name + " : " + this.getRunwayTime() + "h";
        }
        return "";
    }

}
