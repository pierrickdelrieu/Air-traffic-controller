package AiTravelController.RunwayWaiting;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import java.util.ArrayList;
import java.util.Random;

public class WaitingPlaneController {
    private static ArrayList<Plane> planes = new ArrayList<>();

    public static ArrayList<Plane> getPlanes() {
        return planes;
    }

    public static void clear() {
        planes.clear();
    }

    /**
     * Verifies the size of the Array List that contains all the Waiting Planes
     * @return true if there is no waiting plane, false if there is
     */
    public static boolean isEmpty() {
        return planes.size() == 0;
    }

    /**
     * Remove the level of fuel hours from the Waiting Planes
     * @param hours : integer which corresponds to the number of fuel hour to remove
     */
    public static void removeFuel(int hours) {
        planes.forEach(plane -> plane.setHourOfFuel(plane.getHourOfFuel() - hours));
    }

    /**
     * Add fuel hours to the Waiting Planes
     * @param hours : integer which corresponds to the number of fuel hour to add
     */
    public static void addFuel(int hours){
        planes.forEach((plane) -> plane.increaseHourOfFuel(hours));
    }

    /**
     * Verifies if there is Waiting Planes on air or no
     * @return true if there is waiting plane, false else
     */
    public static boolean hasWaitingPlane(){
        return !planes.isEmpty();
    }

    /**
     * Remove a plane from the Waiting Planes
     * @param p : Plane to remove from the Waiting Plane Array List
     */
    public static void removePlane(Plane p){
        planes.remove(p);
    }

    /**
     * Add a plane to the Waiting Planes
     * @param plane : Plane to add to the Waiting Plane Array List
     */
    public static void addPlane(Plane plane){
        planes.add(plane);
    }

    /**
     * @return a random plane that is in the Waiting Planes Array List
     */
    public static Plane getRandomPlane(){
        Random rand = new Random();
        return planes.get(rand.nextInt(planes.size()));
    }

    /**
     * @param hour : integer that corresponds to the number of fuel hour to remove to all the Waiting Planes
     */
    public static void removeFuelForAllPlane(int hour){
        planes.forEach((plane) -> {
            plane.decreaseHourOfFuel(hour);
            if (plane.getHourOfFuel() <= 0) {
                AirTravelController.getInstance().increaseNumberDied(plane.getNbPassenger());
            }
        });
        planes.removeIf(each -> each.getHourOfFuel() <= 0);
    }
}
