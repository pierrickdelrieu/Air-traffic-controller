package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.RunwayController;

public class LockdownTheRunwayOpt extends Option{

    public LockdownTheRunwayOpt() {
        super("Lockdown the runway", "Free runway", "One runway will be blocked for 8 hours");
    }

    public boolean isValid() { return RunwayController.getInstance().getNbEmptyRunway() >= 1;}

    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].block(ObstacleType.OTHER, 8);
    }
}
