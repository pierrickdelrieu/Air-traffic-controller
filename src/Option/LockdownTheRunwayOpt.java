package Option;

public class LockdownTheRunwayOpt extends Option{

    public LockdownTheRunwayOpt() {
        super("Lockdown the runway", "Free runway", "One runway will be blocked for 8 hours");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
