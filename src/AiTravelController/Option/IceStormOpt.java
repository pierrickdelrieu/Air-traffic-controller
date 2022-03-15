package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class IceStormOpt extends Option{

    public IceStormOpt() {
        super("Ice storm", "At least 1 runway", "Remove a runway");
    }

    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    public void apply() {
        RunwayController runways = RunwayController.getInstance();
        runways.removeRunway(runways.getNEmptyRandomRunway(1)[0]);
    }
}
