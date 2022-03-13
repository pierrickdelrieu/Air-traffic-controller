package AiTravelController.RunwayWaiting;

import AiTravelController.Element.Plane;
import java.util.ArrayList;
import java.util.Random;

public class WaitingPlaneController {
    private static ArrayList<Plane> planes = new ArrayList<>();

    public static ArrayList<Plane> getPlane() {
        return planes;
    }

    /**
     *
     * @return
     */
    public static boolean isEmpty() {
        return planes.size() == 0;
    }

    /**
     *
     * @param hours
     */
    public static void removeFuel(int hours) {
        planes.forEach(plane -> plane.setHourOfFuel(plane.getHourOfFuel() - hours));
    }

    /**
     *
     * @return
     */
    public static boolean hasWaitingPlane(){
        return !planes.isEmpty();
    }

    /**
     *
     * @param p
     */
    public static void removePlane(Plane p){
        planes.remove(p);
    }

    /**
     *
     */
    public static void setFuelAtMaxForAllPlane(){
        planes.forEach((plane) -> plane.setHourOfFuel(plane.MAXFUEL));
    }

    /**
     *
     * @param hour
     */
    public static void removeFuelForAllPlane(int hour){
        planes.forEach((plane) -> plane.setHourOfFuel(plane.getHourOfFuel() - hour));
    }

    /**
     *
     * @param plane
     */
    public static void addPlane(Plane plane){
        planes.add(plane);
    }

    /**
     *
     * @return
     */
    public static Plane getRandomPlane(){
        Random rand = new Random();
        return planes.get(rand.nextInt(planes.size()));
    }
}
