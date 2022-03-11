package Option;

public class AllowLandingOpt extends Option{

    public AllowLandingOpt() {
        super("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
