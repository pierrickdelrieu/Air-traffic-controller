package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.HashMap;

public class AllowLandingOpt extends Option{

    public AllowLandingOpt(HashMap<String, Integer> params) {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time", params);
    }

    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    @Override
    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].addElement(
                new Plane(new Integer[]{getParams().get("minHourOfFuel"), getParams().get("maxHourOfFuel")},
                        new Integer[]{getParams().get("minNbPassenger"), getParams().get("maxNbPassenger")},
                        new Integer[]{getParams().get("minHourOfRunway"), getParams().get("maxHourOfRunway")}));
    }
}