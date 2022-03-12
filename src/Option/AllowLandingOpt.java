package Option;

import RunwayWaiting.RunwayController;
import RunwayWaiting.WaitingPlaneController;

public class AllowLandingOpt extends Option{

    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    public boolean isValid() {
        return RunwayController.getNbEmptyRunway() == 1;
    }

    public void apply() {
        WaitingPlaneController.getRandomPlane().land();
    }
}
