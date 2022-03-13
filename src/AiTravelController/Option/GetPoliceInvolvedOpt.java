package AiTravelController.Option;

import AiTravelController.Element.ObstacleType;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;

public class GetPoliceInvolvedOpt extends Option{
    public GetPoliceInvolvedOpt() {
        super("Get police involved", "2 Free runways", "Two run ways will be blocked for 4 hours");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getNbEmptyRunway() >= 2;
    }

    @Override
    public void apply() {
        Runway[] randomRunway = RunwayController.getNEmptyRandomRunway(2);

        for (Runway runway: randomRunway) {
            runway.block(ObstacleType.POLICE, 4);
        }
    }
}