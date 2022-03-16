package AiTravelController.Option;
import AiTravelController.RunwayWaiting.*;
import AiTravelController.Element.*;

public class SpaceToProtestOpt extends Option {
    public SpaceToProtestOpt() {
        super("Allow them the space to protest", "Free runway", "One runway will be blocked for 10 hours");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    @Override
    public void apply() {
        Runway[] randomRunway = RunwayController.getInstance().getNEmptyRandomRunway(1);
        for (Runway runway: randomRunway) {
            runway.block(ObstacleType.PROTESTOR, 10);
        }
    }
}
