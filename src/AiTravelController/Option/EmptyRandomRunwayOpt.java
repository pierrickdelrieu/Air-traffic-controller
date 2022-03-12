package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class EmptyRandomRunwayOpt extends Option{

    public EmptyRandomRunwayOpt() {
        super("Empty random runway", "1 full runway", "Empties a random runway.");
    }

    @Override
    public boolean isValid() {
        return RunwayController.getNbEmptyRunway() - RunwayController.RUNWAY_NB == 0;
    }

    @Override
    public void apply() {
        RunwayController.emptiesRandomRunway();
    }
}
