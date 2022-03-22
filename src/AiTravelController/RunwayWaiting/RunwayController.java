package AiTravelController.RunwayWaiting;

import AiTravelController.Element.Element;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class RunwayController {
    private RunwayController(){
        for (int i = 0; i < INIT_RUNWAY_NB; i++) {
            runways.add(new Runway());
        }
    }

    private static RunwayController instance = null;

    public static RunwayController getInstance() {
        if (instance == null) {
            instance = new RunwayController();
        }
        return instance;
    }

    public final int INIT_RUNWAY_NB = 8;

    private final ArrayList<Runway> runways = new ArrayList<>();

    public ArrayList<Runway> getRunways() {
        return runways;
    }

    public void clear() {
        for (Runway runway : runways) {
            runway.empties();
        }

        for (int i = 0; i < 8 - runways.size(); i++) {
            runways.add(new Runway());
        }
    }

    public void removeRunway(Runway runway){
        runways.remove(runway);
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
        if (number <= getNbEmptyRunway()) {
            Runway[] x = new Runway[number];

            Random rand = new Random();

            ArrayList<Integer> runwayIndex = new ArrayList<Integer>();
            for (int i = 0; i < number; i++) {
                int index;
                do {
                    index = rand.nextInt(runways.size());
                } while (!runways.get(index).isEmpty() || runwayIndex.contains(index));

                runwayIndex.add(index);
            }

            for (int i = 0; i<number; i++) {
                x[i] = runways.get(runwayIndex.get(i));
            }

            return x;
        }
        return null;
    }

    /**
     * Getter of N full random runway
     * @param number desired number of runways
     * @return Array of full runway
     */
    public Runway[] getNFullRandomRunway(int number) {
        if (number <= runways.size() - getNbEmptyRunway()) {
            Runway[] x = new Runway[number];

            Random rand = new Random();

            ArrayList<Integer> runwayIndex = new ArrayList<Integer>();
            for (int i = 0; i < number; i++) {
                int index;

                do {
                    index = rand.nextInt(runways.size());
                } while (runways.get(index).isEmpty() || runwayIndex.contains(index));

                runwayIndex.add(index);
            }

            for (int i = 0; i < runwayIndex.size(); i++ ) {
                x[i] = runways.get(runwayIndex.get(i));
            }

            return x;
        }
        return null;
    }

    /**
     * Check of whether there is a runway in the system
     * @return true if there is a runway in the system and false otherwise
     */
    public boolean hasRunway() {
        return runways.size() != 0;
    }

    /**
     * Getter of all empty runways
     * @return Array of all empty runways
     */
    public ArrayList<Runway> getAllEmptyRunways() {
        ArrayList<Runway> emptyRunway = new ArrayList<>();

        for (Runway runway: runways) {
            if (runway.isEmpty()) {
                emptyRunway.add(runway);
            }
        }
        return emptyRunway;
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
        if (number <= (runways.size() - getNbEmptyRunway())) {

            Runway[] ways = getNFullRandomRunway(number);

            for (Runway way: ways) {
                way.empties();
            }

        } else {
            for (Runway runway: getNFullRandomRunway(runways.size() - getNbEmptyRunway())) {
                runway.empties();
            }
        }
    }

    /**
     *
     * @param time
     */
    public void addRunwayTimeToPlanes(int time){
        for (Runway runway : runways) {
            Element element = runway.getElement();
            if (element != null && element.getClass().getName().equals("AiTravelController.Element.Plane"))
                element.increaseRunwayTime(time);
        }
    }
}
