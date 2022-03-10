import java.util.Scanner;

public class Menu {

    public Menu(){
        System.out.println("""
                \t -- Welcome to the Air contoller simulator --
                Your mission, if you accept it, is to make sure all plane land during those 24 hour.Good luck, agent ! \n
                """);

    }

    public void displayMainMenu(int current_hour, int current_killed, int number_of_request){
        System.out.println("\t -- Main Menu --");
        System.out.printf("""
                        Current hour : %d h
                        Current number of dead : %d
                        """
                , current_hour, current_killed);

        System.out.println("""
                1 - Runways
                2 - Waiting planes
                """);

        if(number_of_request > 0){
            System.out.println("3 - Requests menu");
        }
        else{
            System.out.println("3 - Advanced hour");
        }

        System.out.println("Your choice : ");
        int choice = getSecureValueFromUser(1,3);

    }

    public void displayWaitingPlanesMenu(PlaneController planeController){

        System.out.printf("\t--- Waiting planes : %d ---\n", planeController.getNumberWaitingPlane());

        for(Plane each : planeController.getWaitingPlaneList()){
            System.out.printf("""
                            %s :
                            %d hour of fuel // %d passengers // %d hour needed on runway \n
                            """,
                    each.getName(), each.getHour_of_fuel(), each.getNumber_passenger(), each.getRunway_time()
            );
        }

        System.out.println("\n");

    }

    public void displayRunwayMenu(PlaneController planeController){

        System.out.printf("\t--- Runways : %d / %d occupied ---\n", planeController.getNumberOccupiedRunways(), AirTravelController.getNumber_runways());

        for(Plane each : planeController.getRunways()){
            System.out.printf("""
                            %s :
                            %s h remaining \n
                            """,
                    each.getName(), each.getRunway_time()
            );
        }

        System.out.println("\n");

    }

    //public void ()

    public void displayAdvanceHourScreen(int currentTime, int nbRequest, int nbPass, int nbKill){
        System.out.printf("currentTime : %d\nnewTime : ", currentTime);
    }





    public static int getSecureValueFromUser(int min, int max) {
        boolean ok = false;
        int value = 0;

        do {
            try {
                Scanner scan = new Scanner(System.in);
                value = scan.nextInt();
                if ((value >= min) && (value <= max)) {
                    ok = true;
                } else {
                    System.out.println("Error. Input is not between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Error. Input is not an integer.");
            }

        } while (!ok);

        return value;
    }



}
