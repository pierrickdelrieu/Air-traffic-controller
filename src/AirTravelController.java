public class AirTravelController {

    private static int number_died;
    private static int number_hour;

    public AirTravelController(){
        number_died = 1;
        number_hour = 0;
    }

    public int getNumber_died() {
        return number_died;
    }
    public void setNumber_died(int number_died) {
        AirTravelController.number_died = number_died;
    }

    public int getNumber_hour() {
        return number_hour;
    }
    public void setNumber_hour(int number_hour) {
        AirTravelController.number_hour = number_hour;
    }

    public void pass_hour_removed_fuel(){
        number_hour += 1;
    }


}
