package AiTravelController.RunwayWaiting;

import AiTravelController.Element.Element;
import java.util.ArrayList;
import java.util.Random;

public class RunwayController {

    private static RunwayController instance = null;
    private final ArrayList<Runway> runways = new ArrayList<>();
    public final int INIT_RUNWAY_NB = 8;

    /**
     * Private class constructor that can be called to get its instance only
     */
    private RunwayController(){
        for (int i = 0; i < INIT_RUNWAY_NB; i++) {
            runways.add(new Runway());
        }
    }

    /**
     * Static method to get or create instance of Singleton Runway Controller Class
     */
    public static RunwayController getInstance() {
        if (instance == null) {
            instance = new RunwayController();
        }
        return instance;
    }

    /**
     * @return an Array List of all the runways
     */
    public ArrayList<Runway> getRunways() {
        return runways;
    }

    /**
     * Remove a runway from the Array List of Runways
     * @param runway : Runway to remove
     */
    public void removeRunway(Runway runway){
        runways.remove(runway);
    }

    public void clear() {
        for (Runway runway : runways) {
            runway.empties();
        }
        for (int i = 0; i < 8 - runways.size(); i++) {
            runways.add(new Runway());
        }
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
        if (number <= getNbFullRunway()) {
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
     * @return an integer that corresponds to the number of full runway
     */
    public int getNbFullRunway() {
        return runways.size() - getNbEmptyRunway();
    }

    /**
     * Empty the elements of N random track
     * @param number int number of tracks to be emptied
     */
    public void emptiesNRandomRunway(int number) {
        if (number <= (getNbFullRunway())) {

            Runway[] ways = getNFullRandomRunway(number);

            for (Runway way: ways) {
                way.empties();
            }

        } else {
            for (Runway runway: getNFullRandomRunway(getNbFullRunway())) {
                runway.empties();
            }
        }
    }

    /**
     * @param time : integer which corresponds to the runway time to add to Planes on runways
     */
    public void addRunwayTimeToPlanes(int time){
        for (Runway runway : runways) {
            Element element = runway.getElement();
            if (element != null && element.getClass().getName().equals("AiTravelController.Element.Plane"))
                element.increaseRunwayTime(time);
        }
    }
}
