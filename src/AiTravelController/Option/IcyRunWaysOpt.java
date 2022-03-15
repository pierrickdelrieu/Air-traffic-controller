package AiTravelController.Option;

import AiTravelController.RunwayWaiting.RunwayController;
import java.util.HashMap;

public class IcyRunWaysOpt extends Option{

    public IcyRunWaysOpt(HashMap<String, Integer> params) {
        super("Icy run ways", "None", "Add 2 hours wait time to all planes waiting in runway", params);
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
        RunwayController.getInstance().addRunwayTimeToPlanes(2);
    }
}
