package AiTravelController.UI;

import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;

public class AboutMenu extends Menu {

    private AboutMenu(){}

    private static AboutMenu instance = null;

    public static AboutMenu getInstance() {
        if (instance == null) {
            instance = new AboutMenu();
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
        System.out.println("                         -- About Menu --                    \n");

    }


    @Override
    public void content() {

        System.out.println("""
                Welcome to the About Menu""");
    }
}
