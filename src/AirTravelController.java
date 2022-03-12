import UI.*;

public class AirTravelController {

    private static AirTravelController instance;

    private AirTravelController(){} // fix instancifiaction of this classes

    private int numberDied = 0;
    private int numberHour = 0;


    public static AirTravelController getInstance(){
        if (instance == null) {
            instance = new AirTravelController();
        }
        return instance;
    }


    public void run() {
        MenuController.run();
    }

    public int getNumber_died() {
        return numberDied;
    }

    public void setNumber_died(int number_died) {
        numberDied = number_died;
    }

    public int getNumberHour() {
        return numberHour;
    }

    public void setNumberHour(int number_hour) {
        numberHour = number_hour;
    }

    /**
     * Change the number of dead people
     * @param number the number of dead people (positive number) or the number of save people (negative number)
     */
    public void setNbOfDeadPeople(int number){
        numberDied += number;
    }

    public void pass_hour_removed_fuel(){
        numberHour += 1;
    }
}
