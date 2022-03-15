package AiTravelController.Option;

import AiTravelController.AirTravelController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import java.util.HashMap;

public class LetTheManGoOpt extends Option{

    public LetTheManGoOpt(HashMap<String, Integer> params) {
        super("Let the man go", "None", "He crashes the plane into another random Waiting plane" +
                "and saves christmas. Remove the waiting plane (no cost) and kill 100 passengers.", params);
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
        WaitingPlaneController.removePlane(WaitingPlaneController.getRandomPlane()); // removing random plane
        AirTravelController.getInstance().addNbOfDeadPeople(100); // killing 100 passengers
    }
}
