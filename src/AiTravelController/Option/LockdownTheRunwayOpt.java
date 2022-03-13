package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.RunwayController;

import java.util.Objects;

public class LockdownTheRunwayOpt extends Option{

    public LockdownTheRunwayOpt() {
        super("Lockdown the runway", "Free runway", "One runway will be blocked for 8 hours");
    }

    public boolean isValid() { return RunwayController.hasRunway();}

    public void apply() {
        Objects.requireNonNull(RunwayController.getEmptyRunway()).block(ObstacleType.OTHER, 8);
    }
}
