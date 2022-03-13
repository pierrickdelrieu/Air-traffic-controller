package AiTravelController.UI;

import AiTravelController.AirTravelController;
import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;

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



    public void content() {
        if (AirTravelController.getInstance().getNumberDied() >= 350) {
            System.out.println("                      ***** GAME OVER *****");
            System.exit(0);
        } else if (AirTravelController.getInstance().getNumberHour() > 24){
            System.out.println("                    ***** YOU HAVE WON *****");
            System.exit(0);
        } else {
            Random rand = new Random();
            int nbRequest = 1 + rand.nextInt(3);

            AirTravelController.getInstance().changeCurrentRequest(RequestController.getInstance().chooseRandomRequest(nbRequest));
            System.out.println("Number of new requests coming in : " + nbRequest);
        }
    }
}