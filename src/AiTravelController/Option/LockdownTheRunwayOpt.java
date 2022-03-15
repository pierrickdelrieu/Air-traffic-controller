package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.RunwayController;
import java.util.HashMap;

public class LockdownTheRunwayOpt extends Option{

    public LockdownTheRunwayOpt(HashMap<String, Integer> params) {
        super("Lockdown the runway", "Free runway", "One runway will be blocked for 8 hours", params);
    }

    public boolean isValid() { return RunwayController.getInstance().getNbEmptyRunway() >= 1;}

    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].block(ObstacleType.OTHER, 8);
    }
}
