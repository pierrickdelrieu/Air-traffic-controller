package AiTravelController;

import AiTravelController.Element.Plane;
import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;
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
    public void decreaseNumberDied(int number) { this.numberDied -= number;}




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

    /**t
     * Change the number of dead people
     * @param number the number of dead people (positive number) or the number of save people (negative number)
     */
    public void addNbOfDeadPeople(int number){
        numberDied += number;
    }
}
