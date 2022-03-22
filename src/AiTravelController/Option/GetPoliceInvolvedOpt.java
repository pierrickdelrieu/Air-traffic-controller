package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;

public class GetPoliceInvolvedOpt extends Option{

    /**
     * Public constructor of the Get Police Involved Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public GetPoliceInvolvedOpt() {
        super("Get police involved", "2 Free runways", "Two run ways will be blocked for 4 hours");
    }

    /**
     * @return true if there is at least 2 free runways, false if not
     */
    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 2;
    }

    /**
     * Block 2 runways for 4 hours
     */
    @Override
    public void apply() {
        Runway[] randomRunway = RunwayController.getInstance().getNEmptyRandomRunway(2);
        for (Runway runway: randomRunway) {
            runway.block(ObstacleType.POLICE, 4);
        }
    }
}
