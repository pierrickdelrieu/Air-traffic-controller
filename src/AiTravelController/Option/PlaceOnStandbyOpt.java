package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class PlaceOnStandbyOpt extends ElementOption{

    /**
     * Public constructor of the Place On Standby Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public PlaceOnStandbyOpt() {
        super("Place on standby", "None", "The airplane will join the waiting list");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Add a plane to the Waiting Plane list
     */
    @Override
    public void apply() {
        WaitingPlaneController.addPlane((Plane) getElement());
    }
}
