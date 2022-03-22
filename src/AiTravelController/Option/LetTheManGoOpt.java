package AiTravelController.Option;

import AiTravelController.AirTravelController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class LetTheManGoOpt extends Option{

    /**
     * Public constructor of the Let the Man Go Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public LetTheManGoOpt() {
        super("Let the man go", "None", "He crashes the plane into another random Waiting plane" +
                "and saves christmas. Remove the waiting plane (no cost) and kill 100 passengers.");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    public boolean isValid() {
        return true;
    }

    /**
     * Remove 1 waiting plane and increase the number of dead passengers by 100
     */
    public void apply() {
        WaitingPlaneController.removePlane(WaitingPlaneController.getRandomPlane()); // removing random plane
        AirTravelController.getInstance().increaseNumberDied(100); // killing 100 passengers
    }
}
