import java.util.Scanner;

public class Menu {

    public Menu(){
        System.out.println("\t -- Welcome to the Air contoller simulator -- \n" +
                "Your mission, if you accept it, is to make sure all plane land during those 24 hour." +
                "Good luck, agent !");

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

    //public void displayRunwayMenu(Runway[] runway, )
    //public void displayWaitingPlanesMenu()

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
