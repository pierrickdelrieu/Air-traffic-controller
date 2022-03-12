package Option;

import RunwayWaiting.RunwayController;

public class IceStormOpt extends Option{

    public IceStormOpt() {
        super("Ice storm", "At least 1 runway", "Remove a runway");
    }

    public boolean isValid() {
        return RunwayController.hasRunway();
    }

    public void apply() {
        RunwayController.removeRandomRunway();
    }
}
