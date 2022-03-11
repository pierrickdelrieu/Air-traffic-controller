package Request;

import Option.Option;
import Option.OptionController;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RequestController {
    private static ArrayList<Request> requests = null;

    public static ArrayList<Request> getRequest() {
        if (requests == null) {
            requests = new ArrayList<Request>();

            // Options
            HashMap<String, Option> options = OptionController.getOptions();


            Request planeLanding = new Request(0.4, "Plane Landing",
                    "Plane requests to land. It has [3-5] hours of fuel left to wait. It needs [1-4] hours of runway time. It has [100-500] passengers",
                    new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
            requests.add(planeLanding);

            //...
        }
        return requests;
    }

    /**
     * The options below are the ones you need to program into the
     * training simulation.
     * The rarity determines the percent chance that request is chosen
     * when randomly choosing a request. Multiple of the same requests
     * can happen in an hour.
     * @param number
     * @return
     */
    public static Request[] chooseRandomRequest(int number) {
        return null;
    }
}
