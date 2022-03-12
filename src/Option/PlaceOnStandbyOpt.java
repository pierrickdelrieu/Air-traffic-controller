package Option;

import Element.Plane;
import RunwayWaiting.RunwayController;
import RunwayWaiting.WaitingPlaneController;

public class PlaceOnStandbyOpt extends Option{

    public PlaceOnStandbyOpt() {
        super("Place on standby", "None", "The airplane will join the waiting list");
    }

    public boolean isValid() {
        return true;
    }

    public void apply(Plane plane) {
        WaitingPlaneController.addPlane(plane);
    }
}
