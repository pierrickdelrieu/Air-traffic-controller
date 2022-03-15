package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;

import java.util.Random;

public class LetThemLandOpt extends Option{

    public LetThemLandOpt() {
        super("Let them land", "Free Runway", "Plane will occupy runway for 7 hours");
    }

    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    public void apply() {
        Random rand = new Random();
        Plane plane = new Plane("AH1004", rand.nextInt(3, 5), rand.nextInt(100, 500), 7);
        plane.land();
    }
}
