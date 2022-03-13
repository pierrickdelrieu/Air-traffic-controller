package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class RefuseThemOpt extends Option{

    public RefuseThemOpt() {
        super("Refuse them", "None", "Counts as letting 50 people die");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void apply() {
        AirTravelController.getInstance().setNbOfDeadPeople(50);
    }
}
