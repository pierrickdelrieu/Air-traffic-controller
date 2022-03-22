package AiTravelController.Option;

import AiTravelController.AirTravelController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class LetTheManGoOpt extends Option{

    public LetTheManGoOpt() {
        super("Let the man go", "None", "He crashes the plane into another random Waiting plane " +
                "and saves christmas. Remove the waiting plane (no cost) and kill 100 passengers.");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
        WaitingPlaneController.removePlane(WaitingPlaneController.getRandomPlane()); // removing random plane
        AirTravelController.getInstance().increaseNumberDied(100); // killing 100 passengers
    }
}
