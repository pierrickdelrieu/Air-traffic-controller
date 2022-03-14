package AiTravelController.UI;


import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Element.PlaneType;
import AiTravelController.Option.Option;
import AiTravelController.Request.Request;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<Integer, Option> cpt = new HashMap<>();
        int cptTotOption = 1;
        for (Request request: AirTravelController.getInstance().getCurrentRequest()) {
            System.out.println(request);

            for (Option option: request.getOptions()) {
                if (option.isValid()) {
                    System.out.println("** Option : " + cptTotOption + "  -  " + option);
                    cpt.put(cptTotOption, option);
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
                cpt.get(select).apply();

//                AirTravelController.getInstance().getCurrentRequest()[cptRequest].getOptions().get(cptOption).apply();

                // Clear current request
                AirTravelController.getInstance().clearCurrentRequest();
            }

            return goToMainMenu; // redirection
        }
    }
}


