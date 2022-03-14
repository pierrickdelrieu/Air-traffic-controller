package AiTravelController.UI;

import AiTravelController.AirTravelController;


public class OptionMenu {
    private final String content;
    private final OptionType type;

    public OptionMenu(String content, OptionType type) {
        this.content = content;
        this.type = type;
    }

    /**
     * Getter of the content
     * @return String content of the option
     */
    public String getContent() {
        return content;
    }

    /**
     * Application of the redirection or the instructions to be carried out following the selected option
     */
    public void apply() {
        switch (type) {
            case MAIN_MENU -> {MainMenu.getInstance().show();}
            case WAITING_MENU -> {WaitingPlaneMenu.getInstance().show();}
            case LANDING_MENU -> {LandingPlaneMenu.getInstance().show();}
            case REQUEST_MENU -> {RequestMenu.getInstance().show();}
            case ABOUT_MENU -> {AboutMenu.getInstance().show();}
            case QUIT -> {System.exit(0);}
            case ADVANCE_HOUR_MENU -> {
                AirTravelController.getInstance().setNumberHour(AirTravelController.getInstance().getNumberHour() + 1);
                AdvanceHourMenu.getInstance().show();
            }
        }
    }
}
