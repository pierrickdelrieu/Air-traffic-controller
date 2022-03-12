package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class AllowLandingOpt extends Option{

    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getNbEmptyRunway() == 1;
    }

    @Override
    public void apply() {
        WaitingPlaneController.getRandomPlane().land();
    }
}
