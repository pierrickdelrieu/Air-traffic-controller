package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class PlaceOnStandbyOpt extends Option{

    public PlaceOnStandbyOpt() {
        super("Place on standby", "None", "The airplane will join the waiting list");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public void apply(Plane plane) {
        WaitingPlaneController.addPlane(plane);
    }
}
