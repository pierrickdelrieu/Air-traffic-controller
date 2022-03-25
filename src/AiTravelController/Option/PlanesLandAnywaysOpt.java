package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class PlanesLandAnywaysOpt extends Option{

    /**
     * Public constructor of the Planes Land Anyway Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public PlanesLandAnywaysOpt() {
        super("Let the planes anyways", "None", "Counts as 100 passengers dying");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Add 100 more dead people to the number of dead passengers
     */
    @Override
    public void apply() {
        AirTravelController.getInstance().increaseNumberDied(100);
    }
}
