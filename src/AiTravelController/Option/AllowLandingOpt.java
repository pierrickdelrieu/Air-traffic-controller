package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class AllowLandingOpt extends Option{

    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    @Override
    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].addElement(new Plane("H3R5", 0, 0, 3));
    }
}
