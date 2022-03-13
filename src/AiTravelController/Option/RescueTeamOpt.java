package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class RescueTeamOpt extends Option{

    public RescueTeamOpt() {
        super("Rescue team", "None", "Reduces the number of dead passengers by 100");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void apply() {
        AirTravelController.getInstance().addNbOfDeadPeople(-100);
    }
}
