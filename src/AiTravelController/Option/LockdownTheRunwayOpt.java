package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.RunwayController;

public class LockdownTheRunwayOpt extends Option{

    /**
     * Public constructor of the Lockdown The Runway Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public LockdownTheRunwayOpt() {
        super("Lockdown the runway", "Free runway", "One runway will be blocked for 8 hours");
    }

    /**
     * @return true if there is at least 1 free runway, false if not
     */
    public boolean isValid() { return RunwayController.getInstance().getNbEmptyRunway() >= 1;}

    /**
     * Block a runway for 8 hours
     */
    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].block(ObstacleType.OTHER, 8);
    }
}
