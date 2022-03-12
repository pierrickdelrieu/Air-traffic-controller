package RunwayWaiting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunwayController {

    public static final int RUNWAY_NB = 8;

    private static final Runway[] runways = new Runway[RUNWAY_NB];

    public static Runway[] getNEmptyRandomRunway(int number) {
        Runway[] x = new Runway[number];

        Random rand = new Random();

        int nb = 1 + rand.nextInt(number);

        ArrayList<Integer> runwayIndex = new ArrayList<Integer>();

        for(int i = 0; i < nb; i++) {
            int index;
            do {
                index = rand.nextInt(number);
            } while (!runways[index].isEmpty() && !runwayIndex.contains(index));

            runwayIndex.add(index);
        }

        for (Integer index: runwayIndex) {
            x[index] = runways[runwayIndex.get(index)];
        }


        return runways;
    }

    public static Runway[] getNFullRandomRunway(int number) {
        Runway[] x = new Runway[number];

        Random rand = new Random();

        int nb = 1 + rand.nextInt(number);

        ArrayList<Integer> runwayIndex = new ArrayList<Integer>();

        for(int i = 0; i < nb; i++) {
            int index;
            do {
                index = rand.nextInt(number);
            } while (runways[index].isEmpty() && !runwayIndex.contains(index));

            runwayIndex.add(index);
        }

        for (Integer index: runwayIndex) {
            x[index] = runways[runwayIndex.get(index)];
        }


        return runways;
    }

    public static void emptiesRandomRunway() {
        Random rand = new Random();
        int nbRunway = rand.nextInt(7);

        runways[nbRunway].empties();
    }

    public static boolean hasRunway() {
        for (Runway runway: runways) {
            if (runway != null) {
                return true;
            }
        }
        return false;
    }


    public static ArrayList<Runway> getEmptyRunways() {
        ArrayList<Runway> emptyRunway = new ArrayList<>();

        for (Runway runway: runways) {
            if (runway.isEmpty()) {
                emptyRunway.add(runway);
            }
        }
        return emptyRunway;
    }


    public static Runway getEmptyRunway() {
        ArrayList<Runway> x = getEmptyRunways();

        if (x.size() != 0) {
            return x.get(0);
        }

        return null;
    }

    /**
     * Check if there is at least ${number} empty runway
     * @return a boolean of the condition
     */
    public static int getNbEmptyRunway() {
        int cpt = 0;

        for (Runway runway: runways) {
            if (runway.isEmpty()) {
               cpt++;
            }
        }

        return cpt;
    }

    /**
     *
     * @param number ok
     */
    public void emptiesNRandomRunway(int number) {
        if (number > (RUNWAY_NB - getNbEmptyRunway())) {
            Runway[] ways = getNFullRandomRunway(number);

            for (Runway way: ways) {
                way.empties();
            }

        } else {
            for (Runway runway: getEmptyRunways()) {
                runway.empties();
            }
        }
    }

    public Runway getRandomEmptyRunways() {

        return null;
    }

}
