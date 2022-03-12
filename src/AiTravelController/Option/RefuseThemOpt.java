package AiTravelController.Option;

public class RefuseThemOpt extends Option{

    public RefuseThemOpt() {
        super("Refuse them", "None", "Counts as letting 50 people die");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
