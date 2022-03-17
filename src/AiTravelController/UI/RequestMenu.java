package AiTravelController.UI;


import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Element.PlaneType;
import AiTravelController.Option.Option;
import AiTravelController.Request.PlaneRequest;
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
        HashMap<Integer, Option> options = new HashMap<>();
        HashMap<Integer, Request> requests = new HashMap<>();

        int cptTotOption = 1;
        for (Request request: AirTravelController.getInstance().getCurrentRequest()) {
            PlaneRequest r2 = (PlaneRequest) request;
            System.out.println("5 ---------- " + r2.getPlane().getHourOfFuel() + r2.getPlane().getRunwayTime() + r2.getPlane().getNbPassenger() + "---------- " );
            System.out.println("6 ---------- " + r2.getClass() + "  |  " + request.getClass());
            System.out.println("7 ---------- " + r2.equals(request));
            System.out.println(r2);
            System.out.println(request);

            for (Option option: request.getOptions()) {
                if (option.isValid()) {
                    System.out.println("** Option : " + cptTotOption + "  -  " + option);
                    options.put(cptTotOption, option);
                    requests.put(cptTotOption, request);
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
//                options.get(select).apply();
                if (!requests.get(select).chooseOption(options.get(select))) {
                    return null;
                }

                // Clear current request
                AirTravelController.getInstance().clearRequest(requests.get(select));
            }

            return goToMainMenu; // redirection
        }
    }
}


