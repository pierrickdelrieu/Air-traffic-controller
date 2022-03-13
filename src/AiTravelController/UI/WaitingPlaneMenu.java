package AiTravelController.UI;


import AiTravelController.Element.ObstacleType;
import AiTravelController.Element.Plane;
import AiTravelController.Element.PlaneType;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class WaitingPlaneMenu extends Menu {

    private WaitingPlaneMenu(){}

    @Override
    public void setOptions() {
        clearOption();
        addOptions(new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU));
    }

    private static WaitingPlaneMenu instance = null;

    public static WaitingPlaneMenu getInstance() {
        if (instance == null) {
            instance = new WaitingPlaneMenu();
        }
        instance.setOptions();
        return instance;
    }


    @Override
    public void header() {
        System.out.println("                     -- Waiting Plane Menu --                    \n");
    }

    @Override
    public void displayBoard() {
        if (WaitingPlaneController.getPlane().size() == 0) {
            System.out.println("No waiting plane");
        } else {
            System.out.println("                          ** PLANES **");
            for (Plane plane : WaitingPlaneController.getPlane()) {
                System.out.println(plane.toString(MenuType.WAITING));
            }
        }
        System.out.print("\n\n");
    }

    @Override
    public void content() {
//        WaitingPlaneController.addPlane(new Plane("H234", 4, 200, 5));
//        WaitingPlaneController.addPlane(new Plane("H234", 4, 200, 5));
        displayBoard();
    }

}
