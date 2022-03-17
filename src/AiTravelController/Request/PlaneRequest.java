package AiTravelController.Request;

import AiTravelController.Element.Element;
import AiTravelController.Element.Plane;
import AiTravelController.Option.ElementOption;
import AiTravelController.Option.Option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlaneRequest extends Request implements Cloneable {
    private Plane plane;
    private HashMap<String, Integer> params = new HashMap<>();

    public PlaneRequest(double rarity, String title, String desc, ArrayList<Option> options, Map<String, Integer> params) {
        super(rarity, title, desc, options);
        this.params.putAll(params);
    }

    public Plane getPlane() {
        return plane;
    }


    private void initialize() {
        Random rand = new Random();
        int hourOfFuelParams = this.params.get("minHourOfFuel") + rand.nextInt(this.params.get("maxHourOfFuel") - this.params.get("minHourOfFuel"));
        int nbPassengerParams = this.params.get("minNbPassenger") + rand.nextInt(this.params.get("maxNbPassenger") - this.params.get("minNbPassenger"));
        int runwayTimeParams = this.params.get("minRunwayTime") + rand.nextInt(this.params.get("maxRunwayTime") - this.params.get("minRunwayTime"));

        System.out.println("************" + hourOfFuelParams + "  -  " + runwayTimeParams + "  -  " + nbPassengerParams);
        System.out.println("--- " + getDescr());
        setDescr(String.format(getDescr(), hourOfFuelParams, runwayTimeParams, nbPassengerParams));
        System.out.println("--- " + getDescr());


        this.plane = new Plane(hourOfFuelParams, nbPassengerParams, runwayTimeParams);

        for (Option option: getOptions()) {
            ((ElementOption) option).setElement(this.plane);
        }
    }


    @Override
    public boolean chooseOption(Option option) {
        if (getOptions().contains(option)) {
            System.out.println("Option is apply correctly");
            option.apply();
            return true;
        }
        System.out.println("Option is apply incorrectly");

        return false;
    }

    @Override
    public PlaneRequest clone() {
        PlaneRequest clone = (PlaneRequest) super.clone();
        clone.initialize();
        return clone;
    }
}
