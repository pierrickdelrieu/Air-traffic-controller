package AiTravelController;

import AiTravelController.Request.Request;
import AiTravelController.UI.*;


public class AirTravelController {

    private static AirTravelController instance;

    private AirTravelController(){} // fix instantiation of this classes

    private int numberDied = 0;
    private int numberHour = 0;
    private Request[] currentRequest = null;


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
    public void changeCurrentRequest(Request[] newRequests) {
        currentRequest = newRequests;
    }

    /**
     * Getter of currents requests
     * @return Array of current request
     */
    public Request[] getCurrentRequest() {
        return currentRequest;
    }

    /**
     * Deleting current requests
     * A request has been selected. The tour has no more current requests.
     */
    public void clearCurrentRequest() { currentRequest = null; }

    /**
     * Initialization of the game start data.
     * At the beginning of the game, the main menu is displayed.
     */
    public void run() { MainMenu.getInstance().show();}

    /**
     * Getter of number of deaths
     * @return int number of deaths
     */
    public int getNumberDied() {
        return numberDied;
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

    /**t
     * Change the number of dead people
     * @param number the number of dead people (positive number) or the number of save people (negative number)
     */
    public void setNbOfDeadPeople(int number){
        numberDied += number;
    }
}
