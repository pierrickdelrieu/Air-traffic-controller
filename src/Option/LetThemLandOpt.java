package Option;

public class LetThemLandOpt extends Option{

    public LetThemLandOpt() {
        super("Let them land", "None", "Plane will occupy runway for 7 hours");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
