package AiTravelController.UI;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Request.PlaneRequest;
import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.ArrayList;
import java.util.Random;

public class AdvanceHourMenu extends Menu {
    private AdvanceHourMenu(){}

    @Override
    public void setOptions() {
        clearOption();
        addOptions(new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU));
    }

    private static AdvanceHourMenu instance = null;

    public static AdvanceHourMenu getInstance() {
        if (instance == null) {
            instance = new AdvanceHourMenu();
        }
        instance.setOptions();
        return instance;
    }


    @Override
    public void content() {
        if (AirTravelController.getInstance().getNumberDied() >= AirTravelController.getInstance().getMAX_KILL()) {
            System.out.println("                      ***** GAME OVER *****");
            System.out.println("You kill too many people");
            pause();
            System.exit(0);
        } else if (AirTravelController.getInstance().getNumberHour() >= AirTravelController.getInstance().getMAX_HOUR()){
            System.out.println("                    ***** YOU HAVE WON *****");
            pause();
            System.exit(0);
        } else {
            Random rand = new Random();
            int nbRequest = 1 + rand.nextInt(3);

            AirTravelController.getInstance().replaceCurrentRequest(RequestController.getInstance().chooseRandomRequest(nbRequest));
            System.out.println("Number of new requests coming in : " + nbRequest);
        }
    }
}
