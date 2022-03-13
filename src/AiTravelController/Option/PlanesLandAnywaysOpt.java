package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class PlanesLandAnywaysOpt extends Option{

    public PlanesLandAnywaysOpt() {
        super("Let the planes anyways", "None", "Counts as 100 passengers dying");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void apply() {
        AirTravelController.getInstance().addNbOfDeadPeople(100);
    }
}
