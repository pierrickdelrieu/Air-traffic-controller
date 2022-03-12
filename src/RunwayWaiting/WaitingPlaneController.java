package RunwayWaiting;

import Element.Plane;
import java.util.ArrayList;
import java.util.Random;

public class WaitingPlaneController {
    private static ArrayList<Plane> planes = new ArrayList<>();

    public static boolean isEmpty() {
        return planes.size() == 0;
    }

    public static void removeFuel(int hours) {
        planes.forEach(plane -> plane.setHourOfFuel(plane.getHourOfFuel() - hours));
    }

    public static boolean hasWaitingPlane(){
        return !planes.isEmpty();
    }

    public static void removePlane(Plane p){
        planes.remove(p);
    }

    public static void setFuelAtMaxForAllPlane(){
        planes.forEach((plane) -> plane.setHourOfFuel(plane.MAXFUEL));
    }

    public static void removeFuelForAllPlane(int hour){
        planes.forEach((plane) -> plane.setHourOfFuel(plane.getHourOfFuel() - hour));
    }

    public static void addPlane(Plane plane){
        planes.add(plane);
    }

    public static Plane getRandomPlane(){
        Random rand = new Random();
        return planes.get(rand.nextInt(planes.size()));
    }
}
