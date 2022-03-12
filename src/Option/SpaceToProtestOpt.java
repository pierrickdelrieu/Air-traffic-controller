package Option;

import Element.ObstacleType;
import RunwayWaiting.Runway;
import RunwayWaiting.RunwayController;

public class SpaceToProtestOpt extends Option {
    public SpaceToProtestOpt() {
        super("Allow tem the space to protest", "Free runway", "One runway will be blocked for 10 hours");
    }

    public boolean isValid() {
        return RunwayController.hasRunway();
    }

    public void apply() {
        Runway[] randomRunway = RunwayController.getNEmptyRandomRunway(1);
        for (Runway runway: randomRunway) {
            runway.block(ObstacleType.PROTESTOR, 10);
        }
    }
}
