package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class IceStormOpt extends Option{

    /**
     * Public constructor of the Ice Storm Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public IceStormOpt() {
        super("Ice storm", "At least 1 runway", "Remove a runway");
    }

    /**
     * @return true if there is at least 1 free runway, false if not
     */
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    /**
     * Remove a runway
     */
    public void apply() {
        RunwayController runways = RunwayController.getInstance();
        runways.removeRunway(runways.getNEmptyRandomRunway(1)[0]);
    }
}
