package AiTravelController.Option;

import AiTravelController.AirTravelController;

public class RefuseThemOpt extends Option{

    /**
     * Public constructor of the Refuse Them Option
     * Setting the title, requirement, and consequence to apply this option
     */
    public RefuseThemOpt() {
        super("Refuse them", "None", "Counts as letting 50 people die");
    }

    /**
     * @return always true because there is no requirement for this option
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Add 50 more dead people to the number of dead passengers
     */
    @Override
    public void apply() {
        AirTravelController.getInstance().increaseNumberDied(50);
    }
}
