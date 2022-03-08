public class main {
    public static void main(String[] args) {
        System.out.println("Hello word");
	    System.out.println("dev_guillaume");


        AirTravelController airTravelController = new AirTravelController();

        System.out.println("Test : " +
                airTravelController.getNumber_died() +
                airTravelController.getNumber_hour() );
        airTravelController.pass_hour_removed_fuel();
        System.out.println("Test : " +
                airTravelController.getNumber_died() +
                airTravelController.getNumber_hour() );


        Menu menu = new Menu();
        menu.displayMainMenu(airTravelController.getNumber_hour(), airTravelController.getNumber_died(), 2);

    }
}
