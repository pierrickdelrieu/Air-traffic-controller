package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;

public class IcyRunWaysOpt extends Option{

    public IcyRunWaysOpt() {
        super("Icy run ways", "None", "Add 2 hours wait time to all planes waiting in runway");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
        RunwayController.getInstance().addRunwayTimeToPlanes(2);
    }
}
