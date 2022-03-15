package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.HashMap;

public class PlaceOnStandbyOpt extends Option{

    public PlaceOnStandbyOpt(HashMap<String, Integer> params) {
        super("Place on standby", "None", "The airplane will join the waiting list", params);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public void apply() {
        WaitingPlaneController.addPlane(
                new Plane(new Integer[]{getParams().get("minHourOfFuel"), getParams().get("maxHourOfFuel")},
                        new Integer[]{getParams().get("minNbPassenger"), getParams().get("maxNbPassenger")},
                        new Integer[]{getParams().get("minHourOfRunway"), getParams().get("maxHourOfRunway")}));
    }
}
