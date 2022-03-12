package Option;

import RunwayWaiting.RunwayController;

public class IceStormOpt extends Option{

    public IceStormOpt() {
        super("Ice storm", "At least 1 runway", "Remove 1 hour of fuel from all waiting planes in air");
    }

    public boolean isValid() {
        return RunwayController.hasRunway();
    }

    public void apply() {
        RunwayController.removeRandomRunway();
    }
}
