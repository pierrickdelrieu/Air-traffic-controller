package AiTravelController.Option;

import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class CrossWindsOpt extends Option{

    /**
     * Public constructor of the Cross Winds Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public CrossWindsOpt() {
        super("Cross winds", "None", "Remove 1 hour of fuel from all waiting planes in air");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Remove 1 hour of fuel from all waiting planes in air
     */
    @Override
    public void apply() {
        WaitingPlaneController.removeFuelForAllPlane(1);
    }
}
