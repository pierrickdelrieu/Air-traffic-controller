package RunwayWaiting;

import Element.Plane;

import java.util.ArrayList;

public class WaitingPlaneController {
    private static ArrayList<Plane> planes = new ArrayList<>();



    public static boolean isEmpty() {
        if (planes.size() == 0) {
            return true;
        }
        return false;
    }

    public static void removeFuel(int hours) {
        planes.forEach(plane -> {
            plane.setHourOfFuel(plane.getHourOfFuel() - hours);
        });
    }
}
