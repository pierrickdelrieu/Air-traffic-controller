package AiTravelController.Option;

import AiTravelController.AirTravelController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.Element.Plane;

public class LetTheManGoOpt extends Option{

    public LetTheManGoOpt() {
        super("Let the man go", "None", "He crashes the plane into another random Waiting plane" +
                "and saves christmas. Remove the waiting plane (no cost) and kill 100 passengers.");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {
        int number_died = AirTravelController.getInstance().getNumber_died();
        AirTravelController.getInstance().setNumber_died(number_died + 100);
        WaitingPlaneController.removePlane(WaitingPlaneController.getRandomPlane());
    }
}
