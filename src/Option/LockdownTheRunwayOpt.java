package Option;

public class LockdownTheRunwayOpt extends Option{

    public LockdownTheRunwayOpt() {
        super("Cross winds", "None", "Remove 1 hour of fuel from all waiting planes in air");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
