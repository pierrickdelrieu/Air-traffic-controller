package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class IceStormOpt extends Option{

    public IceStormOpt() {
        super("Ice storm", "At least 1 runway", "Remove a runway");
    }

    public boolean isValid() {
        return RunwayController.getInstance().hasRunway();
    }

    public void apply() { RunwayController.removeFreeRunway(); }
}
