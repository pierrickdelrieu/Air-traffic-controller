package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class LetThemLandOpt extends Option{

    public LetThemLandOpt() {
        super("Let them land", "Free Runway", "Plane will occupy runway for 7 hours");
    }

    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    public void apply() {
        Plane plane = WaitingPlaneController.getRandomPlane();
        plane.land();
        plane.setRunwayTime(7);
    }
}
