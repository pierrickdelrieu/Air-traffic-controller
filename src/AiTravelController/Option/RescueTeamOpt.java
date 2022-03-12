package AiTravelController.Option;

public class RescueTeamOpt extends Option{

    public RescueTeamOpt() {
        super("Rescue team", "None", "Reduces the number of dead passengers by 100");
    }

    public boolean isValid() {
        return true;
    }

    public void apply() {

    }
}
