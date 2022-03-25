package AiTravelController.Option;

import AiTravelController.RunwayWaiting.WaitingPlaneController;

public class AirRefuelingOpt extends Option{

    /**
     * Public constructor of the Air Refueling Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public AirRefuelingOpt() {
        super("Air refueling", "At least one plan in air", "Adding 2 hour fuel to all waiting airplanes in air");
    }

    /**
     * @return true if there is at least one plane in air, false if not
     */
    @Override
    public boolean isValid() {
        return WaitingPlaneController.hasWaitingPlane();
    }

    /**
     * Add 2 hours of fuel to all the Waiting Planes in air
     */
    @Override
    public void apply() {
        WaitingPlaneController.addFuel(2);
    }
}
