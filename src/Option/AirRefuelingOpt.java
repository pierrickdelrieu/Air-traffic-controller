package Option;

public class AirRefuelingOpt extends Option{

    public AirRefuelingOpt() {
        super("Air refueling", "At least one plan in air", "Adding maximum fuel to all waiting airplanes in air");
    }

    public boolean isValid() {
//        return WaitingPlaneControler.hasWaitingPlane();
        return true;
    }

    public void apply() {

    }
}