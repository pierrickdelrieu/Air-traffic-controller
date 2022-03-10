public class AirTravelController {

    private static int number_died;
    private static int number_hour;
    private static final int number_runways = 8;

    public AirTravelController(){
        number_died = 0;
        number_hour = 1;
    }

    public static int getNumber_runways() {
        return number_runways;
    }

    public static int getNumber_died() {
        return number_died;
    }
    public static void setNumber_died(int number_died) {
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
