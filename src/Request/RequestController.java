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
                    "Plane requests to land. It has [3-5] hours of fuel left to wait. It needs [1-4] hours of runway time. It has [100-500] passengers.",
                    new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
            requests.add(planeLanding);

            Request emergencyLanding = new Request(0.05, "Emergency Landing",
                    "Plane requests to land. It has [1-3] hours of fuel left to wait. It requires [3-5] hours of runway time. It has [100-500] passengers.",
                    new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
            requests.add(emergencyLanding);

            Request fundingEvent = new Request(0.1, "Funding Event",
                    "Increase in funding allows for one of the following bonuses.",
                    new ArrayList<Option>(List.of(options.get("emptyRandomRunway"), options.get("rescueTeam"), options.get("airRefueling"))));
            requests.add(fundingEvent);

            Request jumboJet = new Request(0.15, "Jumbo Jet",
                    "A large aircraft carrying [300-600] passengers with [4-6] hours of fuel wishes to land. It needs [4-6] hours of runway time.",
                    new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
            requests.add(jumboJet);

            Request badWeather = new Request(0.1, "Bad weather",
                    "Select a bad weather event.",
                    new ArrayList<Option>(List.of(options.get("crossWinds"), options.get("icyRunWays"), options.get("iceStorm"))));
            requests.add(badWeather);

            Request snakesOnThePlanes = new Request(0.1, "Snakes on the planes",
                    "Enough is enough! \n A pilot is reporting that their plane is being overrun by snakes. They want to land at your airport.",
                    new ArrayList<Option>(List.of(options.get("letThemLand"), options.get("refuseThem"))));
            requests.add(snakesOnThePlanes);

            Request protests = new Request(0.05, "Protests",
                    "A group of protestors are blocking the runway claiming that your airplanes are dropping chemtrails which has caused the following health issues: \"makes their toothpaste taste like mint.\"",
                    new ArrayList<Option>(List.of(options.get("spaceToProtest"), options.get("getPoliceInvolved"), options.get("planesLandAnyways"))));
            requests.add(protests);

            Request johnMcclain = new Request(0.05, "John McClane",
                    "Security reports of a man hijacking a plane on the runway. He claims he needs to stop the terrorists from stealing christmas. Do you lock down the runway or let them go?",
                    new ArrayList<Option>(List.of(options.get("lockDownTheRunway"), options.get("letTheManGo"))));
            requests.add(johnMcclain);

        }
        return requests;
    }

    /**
     * The options below are the ones you need to program into the training simulation.
     * The rarity determines the percent chance that request is chosen when randomly choosing a request.
     * Multiple of the same requests can happen in an hour.
     * @param number number of pick requests
     * @return the selected requests
     */
    public static Request[] chooseRandomRequest(int number) {

        return null;
    }

    public static void main(String[] args) {
        //Request[] r = chooseRandomRequest(3);
        requests.get(1).toString();


    }
}
