package AiTravelController.UI;


import AiTravelController.AirTravelController;
import AiTravelController.Element.ObstacleType;
import AiTravelController.Element.Plane;
import AiTravelController.Element.PlaneType;
import AiTravelController.Option.Option;
import AiTravelController.Request.Request;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.ArrayList;
import java.util.HashMap;

public class WaitingPlaneMenu extends Menu {

    private WaitingPlaneMenu(){}

    private static WaitingPlaneMenu instance = null;

    public static WaitingPlaneMenu getInstance() {
        if (instance == null) {
            instance = new WaitingPlaneMenu();
        }
        return instance;
    }


    @Override
    public void header() {
        System.out.println("                     -- Waiting Plane Menu --                    \n");
    }


    @Override
    public OptionMenu optionsSelection(ArrayList<OptionMenu> content) {
        int cptTotOption = 1;
        HashMap<Integer, Plane> cpt = new HashMap<>();


        // Displaying the options
        if (RunwayController.getInstance().getNbEmptyRunway() != 0) {
            if (WaitingPlaneController.getPlane().size() == 0) {
                System.out.println("No waiting plane");
            } else {
                System.out.println("          ** Choose the plane you want to land **");

                for (Plane plane : WaitingPlaneController.getPlane()) {
                    System.out.println("** PLANE: " + cptTotOption + '\n' + plane.toString(MenuType.WAITING));
                    cpt.put(cptTotOption, plane);
                    cptTotOption++;
                }
            }
        } else {
            System.out.println("All runways are occupied. You can't land a plane.");
            for (Plane plane : WaitingPlaneController.getPlane()) {
                System.out.println("** " + plane.toString(MenuType.WAITING));
            }
        }


        OptionMenu goToMainMenu = new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU);
        System.out.println("\n** Option : " + cptTotOption + "  -  " + goToMainMenu.getContent());


        // Selection of an option
        System.out.print("\n\nChoose an Option : ");
        int select = insertNumber(1, cptTotOption);



        if(select == -1) {
            return null;
        } else {
            if (select != cptTotOption) {
                cpt.get(select).land();
            }

            return goToMainMenu; // redirection
        }




    }
}
