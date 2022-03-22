package AiTravelController.Option;

import AiTravelController.Element.Element;
import AiTravelController.RunwayWaiting.RunwayController;

public class AllowLandingOpt extends ElementOption{

    /**
     * Public constructor of the Allow Landing Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    /**
     * @return true if there is at least 1 empty runway, false if not
     */
    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    /**
     * Make a plane land on a runway and occupies it for stated time
     */
    @Override
    public void apply() {
        RunwayController.getInstance().getNEmptyRandomRunway(1)[0].addElement(getElement());
    }
}