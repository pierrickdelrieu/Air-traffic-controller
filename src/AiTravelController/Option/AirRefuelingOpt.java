package AiTravelController.Option;

import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class AirRefuelingOpt extends Option{

    public AirRefuelingOpt() {
        super("Air refueling", "At least one plan in air", "Adding maximum fuel to all waiting airplanes in air");
    }

    @Override
    public boolean isValid() {
        return WaitingPlaneController.hasWaitingPlane();
    }

    @Override
    public void apply() {
        WaitingPlaneController.setFuelAtMaxForAllPlane();
    }
}
