package AiTravelController.UI;

import AiTravelController.AirTravelController;

public class MainMenu extends Menu {

    private MainMenu(){}

    private static MainMenu instance = null;

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        instance.setOptions();
        return instance;
    }

    @Override
    public void setOptions() {
        clearOption();
        addOptions(new OptionMenu("Go to Waiting Planes Menu", OptionType.WAITING_MENU));
        addOptions(new OptionMenu("Go to Runway Menu", OptionType.LANDING_MENU));

        if (AirTravelController.getInstance().getCurrentRequest().size() == 0) {
            addOptions(new OptionMenu("Advance to the next hour", OptionType.ADVANCE_HOUR_MENU));
        } else {
            addOptions(new OptionMenu("Go to Request Menu", OptionType.REQUEST_MENU));
        }
        addOptions(new OptionMenu("Go to About Menu", OptionType.ABOUT_MENU));


        addOptions(new OptionMenu("Leave the game", OptionType.QUIT));
    }
}
