package AiTravelController.UI;

import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;

public class LandingPlaneMenu extends Menu {

    private LandingPlaneMenu(){}

    private static LandingPlaneMenu instance = null;

    public static LandingPlaneMenu getInstance() {
        if (instance == null) {
            instance = new LandingPlaneMenu();
        }
        instance.setOptions();
        return instance;
    }


    @Override
    public void setOptions() {
        clearOption();
        addOptions(new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU));
    }


    @Override
    public void header() {
        System.out.println("                     -- Landing Plane Menu --                    \n");
    }

    @Override
    public void displayBoard() {
        for (Runway runway: RunwayController.getInstance().getRunways()) {
            System.out.println(runway);
        }
    }

    @Override
    public void content() {
//        RunwayController.getInstance().getEmptyRunway().block(ObstacleType.POLICE, 3);
//        RunwayController.getInstance().getEmptyRunway().addElement(new Plane("H234", 4, 200, 5));
//        RunwayController.getInstance().getEmptyRunway().block(ObstacleType.PROTESTOR, 5);
        displayBoard();
    }
}
