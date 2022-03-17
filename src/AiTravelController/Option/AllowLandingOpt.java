package AiTravelController.Option;

import AiTravelController.Element.Element;
import AiTravelController.RunwayWaiting.RunwayController;

public class AllowLandingOpt extends ElementOption{

    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    @Override
    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].addElement(getElement());
    }
}