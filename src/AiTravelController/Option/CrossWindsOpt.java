package AiTravelController.Option;

import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class CrossWindsOpt extends Option{

    public CrossWindsOpt() {
        super("Cross winds", "None", "Remove 1 hour of fuel from all waiting planes in air");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void apply() {
        WaitingPlaneController.removeFuelForAllPlane(1);
    }
}
