package Option;

import WaitingPlaneControler;

public class CrossWindsOpt extends Option{

    public CrossWindsOpt() {
        super("Cross winds", "None", "Remove 1 hour of fuel from all waiting planes in air");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() { WaitingPlaneControler.removeFuel(1); }
}
