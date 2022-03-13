package AiTravelController.UI;


import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Element.PlaneType;
import AiTravelController.Option.Option;
import AiTravelController.Request.Request;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.ArrayList;
import java.util.Scanner;

public class RequestMenu extends Menu {

    private RequestMenu(){    }

    private static RequestMenu instance = null;

    public static RequestMenu getInstance() {
        if (instance == null) {
            instance = new RequestMenu();
        }
        return instance;
    }


    @Override
    public void header() {
        System.out.println("                        -- Request Menu --                    \n");
    }


    /**
     * Display and selection of an option by the user
     * Application of the selected option to the systems
     * @param content Array of OptionMenu (never used)
     * @return Redirect to MainMenu or null if user input is incorrect
     */
    @Override
    public OptionMenu optionsSelection(ArrayList<OptionMenu> content) {

        System.out.println("                     ** Select an option **\n\n");

        // Displaying the options
        int cptTotOption = 1;
        for (Request request: AirTravelController.getInstance().getCurrentRequest()) {
            System.out.println(request);

            for (Option option: request.getOptions()) {
                if (option.isValid()) {
                    System.out.println("** Option : " + cptTotOption + "  -  " + option);
                    cptTotOption++;
                } else {
                    System.out.println("** Option : unavailable  -  " + option);
                }
                System.out.println("\n");
            }
            System.out.println("\n");
        }


        OptionMenu goToMainMenu = new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU);
        System.out.println("** Option : " + cptTotOption + "  -  " + goToMainMenu.getContent());


        // Selection of an option
        System.out.print("\n\nChoose an Option : ");

        int select = insertNumber(1, cptTotOption);

        // Verification of the option and application of the consequences
        if(select == -1) {
            return null;
        } else {
            if (select != cptTotOption) {
                // Application of option consequences
                int cptRequest = -1;
                int cptOption = 0;
                for (Request request: AirTravelController.getInstance().getCurrentRequest()) {
                    cptOption = -1;
                    cptRequest ++;

                    // Recovery of the option
                    for (Option option: request.getOptions()) {
                        if (option.isValid()) {
                            cptOption++;
                            cptTotOption++;
                        }
                        if (cptOption == cptTotOption-1) {
                            break;
                        }
                    }
                    if (cptOption == cptTotOption-1) {
                        break;
                    }
                }

                AirTravelController.getInstance().getCurrentRequest()[cptRequest].getOptions().get(cptOption).apply();

                // Clear current request
                AirTravelController.getInstance().clearCurrentRequest();
            }

            return goToMainMenu; // redirection
        }
    }
}


