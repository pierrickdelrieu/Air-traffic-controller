package AiTravelController.Option;

import AiTravelController.Element.Plane;
import AiTravelController.RunwayWaiting.RunwayController;

import java.util.Random;

public class LetThemLandOpt extends Option{

    /**
     * Public constructor of the Let Them Land Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public LetThemLandOpt() {
        super("Let them land", "Free Runway", "Plane will occupy runway for 7 hours");
    }

    /**
     * @return ture if there is at least 1 free runway, false if not
     */
    public boolean isValid() {
        return RunwayController.getInstance().getNbEmptyRunway() >= 1;
    }

    /**
     * Let a plane land and occupies a runway for 7 hours
     */
    public void apply() {
        Random rand = new Random();
        Plane plane = new Plane(rand.nextInt(3, 5), rand.nextInt(100, 500), 7);
        plane.land();
    }
}
