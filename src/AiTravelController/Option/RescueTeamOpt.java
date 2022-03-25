package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class RescueTeamOpt extends Option{

    /**
     * Public constructor of the Rescue Team Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public RescueTeamOpt() {
        super("Rescue team", "None", "Reduces the number of dead passengers by 100");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Remove 100 more dead people from the number of dead passengers
     */
    @Override
    public void apply() {
        AirTravelController.getInstance().decreaseNumberDied(100);
    }
}
