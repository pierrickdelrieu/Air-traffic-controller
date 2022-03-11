package Runway;

import java.util.Random;

public class RunwayController {

    public static final int RUNWAY_NB = 8;

    private static Runway[] runways = new Runway[RUNWAY_NB];

//    public static Runway[] getRunways() {return runways;}

    public static void removeRandomRunway() {
        Random rand = new Random();
        int nbRunway = rand.nextInt(7);

        runways[nbRunway] = null;
    }

    public static boolean hasRunway() {
        for (Runway runway: runways) {
            if (runway != null) {
                return true;
            }
        }
        return false;
    }

}
