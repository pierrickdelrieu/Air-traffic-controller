package AiTravelController.Option;
import AiTravelController.RunwayWaiting.*;
import AiTravelController.Element.*;

public class SpaceToProtestOpt extends Option {
    /**
     * Public constructor of the Space To Protest Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public SpaceToProtestOpt() {
        super("Allow them the space to protest", "Free runway", "One runway will be blocked for 10 hours");
    }

    /**
     * @return true if there is at least 1 free runway, false if not
     */
    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    /**
     * Block an empty random runway for 10 hours
     */
    @Override
    public void apply() {
        Runway[] randomRunway = RunwayController.getInstance().getNEmptyRandomRunway(1);
        for (Runway runway: randomRunway) {
            runway.block(ObstacleType.PROTESTOR, 10);
        }
    }
}
