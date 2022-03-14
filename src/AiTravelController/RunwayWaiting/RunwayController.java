package AiTravelController.RunwayWaiting;

import AiTravelController.Element.Element;
import AiTravelController.Element.Plane;

import java.util.ArrayList;
import java.util.Random;

public class RunwayController {
    private RunwayController(){
        for (int i = 0; i < runways.length; i++) {
            runways[i] = new Runway();
        }
    }

    private static RunwayController instance = null;

    public static RunwayController getInstance() {
        if (instance == null) {
            instance = new RunwayController();
        }
        return instance;
    }

    public final int RUNWAY_NB = 8;

    private final Runway[] runways = new Runway[RUNWAY_NB];

    public Runway[] getRunways() {
        return runways;
    }


    /**
     * Reduce the blocking time of the element on all runways
     * @param hour int reduce time
     */
    public void reduceBlockingTimeOfElementsOnRunways(int hour) {
        for (Runway runway: runways) {
            runway.reduceTimeOfElement(hour);
        }
    }
    /**
     * Getter of N empty random runway
     * @param number desired number of runways
     * @return Array of empty runway
     */
    public Runway[] getNEmptyRandomRunway(int number) {
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

    /**
     * Getter of N full random runway
     * @param number desired number of runways
     * @return Array of full runway
     */
    public Runway[] getNFullRandomRunway(int number) {
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

    /**
     * Empty a random runway
     */
    public void emptiesRandomRunway() {
        Random rand = new Random();
        int nbRunway = rand.nextInt(7);

        runways[nbRunway].empties();
    }

    /**
     * Check of whether there is a runway in the system
     * @return true if there is a runway in the system and false otherwise
     */
    public boolean hasRunway() {
        for (Runway runway: runways) {
            if (runway != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Getter of all empty runways
     * @return Array of all empty runways
     */
    public ArrayList<Runway> getEmptyRunways() {
        ArrayList<Runway> emptyRunway = new ArrayList<>();

        for (Runway runway: runways) {
            if (runway.isEmpty()) {
                emptyRunway.add(runway);
            }
        }
        return emptyRunway;
    }


    /**
     * Getter of one empty runway
     * @return Empty runway
     */
    public Runway getEmptyRunway() {
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
    public int getNbEmptyRunway() {
        int cpt = 0;

        for (Runway runway: runways) {
            if (runway.isEmpty()) {
               cpt++;
            }
        }

        return cpt;
    }

    /**
     * Empty the elements of N random track
     * @param number int number of tracks to be emptied
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

    public static void addWaitingTimeToPlanesOnRunways(int time){
        for (Runway runway : instance.getRunways()) {
            Element element = runway.getElement();
            int total_time = element.getRunwayTime() + time;
            if (element.equals(Plane.class)) element.setRunwayTime(total_time);
        }
    }
}
