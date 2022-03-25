package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class EmptyRandomRunwayOpt extends Option{

    /**
     * Public constructor of the Empty Random Runway Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public EmptyRandomRunwayOpt() {
        super("Empty random runway", "1 full runway", "Empties a random runway.");
    }

    /**
     * @return true if there is at least 1 full runway, false if not
     */
    @Override
    public boolean isValid() {
        return RunwayController.getInstance().getNbFullRunway() >= 1;
    }

    /**
     * Empties a random full runway
     */
    @Override
    public void apply() {
        RunwayController.getInstance().emptiesNRandomRunway(1);
    }
}
