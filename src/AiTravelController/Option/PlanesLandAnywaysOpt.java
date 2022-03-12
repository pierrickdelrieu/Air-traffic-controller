package AiTravelController.Option;

public class PlanesLandAnywaysOpt extends Option{

    public PlanesLandAnywaysOpt() {
        super("Let the planes anyways", "None", "Counts as 100 passengers dying");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
    }
}
