package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class IcyRunWaysOpt extends Option{

    /**
     * Public constructor of the Icy Runway Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public IcyRunWaysOpt() {
        super("Icy run ways", "None", "Add 2 hours wait time to all planes waiting in runway");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    public boolean isValid() {
        return true;
    }

    /**
     * Add 2 hours of runway time for each plane waiting in runway
     */
    public void apply() {
        RunwayController.getInstance().addRunwayTimeToPlanes(2);
    }
}
