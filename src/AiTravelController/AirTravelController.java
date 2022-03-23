package AiTravelController;

import AiTravelController.Element.Plane;
import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.UI.*;

import java.util.ArrayList;
import java.util.Random;


public class AirTravelController {

    private static AirTravelController instance;

    private AirTravelController(){} // fix instantiation of this classes

    private int numberDied = 0;
    private int numberHour = 0;
    private ArrayList<Request> currentRequest = new ArrayList<>();

    private final int MAX_HOUR = 24;
    private final int MAX_KILL = 350;

    /**
     * Static method to get or create instance of Singleton AirTravelController Class
     */
    public static AirTravelController getInstance(){
        if (instance == null) {
            instance = new AirTravelController();
        }
        return instance;
    }


    /**
     * Update of the current round requests
     * @param newRequests Array of new request
     */
    public void replaceCurrentRequest(ArrayList<Request> newRequests) {
        currentRequest.clear();
        currentRequest.addAll(newRequests);
    }

    /**
     * Getter of currents requests
     * @return Array of current request
     */
    public ArrayList<Request> getCurrentRequest() {
        return currentRequest;
    }

    /**
     * Deleting current requests
     * A request has been selected. The tour has no more current requests.
     */
    public void clearRequest(Request request) {
        currentRequest.remove(request);
    }

    /**
     * Initialization of the game start data.
     * At the beginning of the game, the main menu is displayed.
     */
    public void run() {
        Random rand = new Random();
        int nbRequest = 1 + rand.nextInt(3);

        AirTravelController.getInstance().replaceCurrentRequest(RequestController.getInstance().chooseRandomRequest(nbRequest));
        MainMenu.getInstance().show();
    }

    /**
     * Getter of number of deaths
     * @return int number of deaths
     */
    public int getNumberDied() {
        return numberDied;
    }
    public void increaseNumberDied(int number) { this.numberDied += number;}
    public void decreaseNumberDied(int number) {
        if (this.numberDied - number < 0) {
            this.numberDied = 0;
        } else {
            this.numberDied -= number;
        }
    }




    /**
     * Getter of number of hours in the game
     * @return int number of hours in the game
     */
    public int getNumberHour() {
        return numberHour;
    }

    /**
     * Setter of number of hours in the game
     * @param number_hour int new value of number of hours in the game
     */
    public void setNumberHour(int number_hour) {numberHour = number_hour;}


    /**
     * Reinitialize the instance of RunwayController and WaitingPlaneController
     * Set the number of hour and the number of dead passengers to 0
     * This function is used in the UnitTest verification
     */
    public void clear() {
        this.setNumberHour(0);
        this.numberDied = 0;
        RunwayController.getInstance().clear();
        WaitingPlaneController.clear();
    }

    public int getMAX_HOUR() {
        return MAX_HOUR;
    }

    public int getMAX_KILL() {
        return MAX_KILL;
    }
}
