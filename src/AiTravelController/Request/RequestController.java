package AiTravelController.Request;

import AiTravelController.Option.Option;
import AiTravelController.Option.OptionController;


import java.util.*;

public class RequestController {
    private RequestController(){
        requests = new ArrayList<Request>();

        // Options
        HashMap<String, Option> options = OptionController.getOptions();


        Request planeLanding = new Request(40.0, "Plane Landing",
                "Plane requests to land. It has [3-5] hours of fuel left to wait. It needs [1-4] hours of runway time." +
                        "\nIt has [100-500] passengers.",
                new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
        requests.add(planeLanding);

        Request emergencyLanding = new Request(5.0, "Emergency Landing",
                "Plane requests to land. It has [1-3] hours of fuel left to wait. It requires [3-5] hours of runway time." +
                        "\nIt has [100-500] passengers.",
                new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
        requests.add(emergencyLanding);

        Request fundingEvent = new Request(10.0, "Funding Event",
                "Increase in funding allows for one of the following bonuses.",
                new ArrayList<Option>(List.of(options.get("emptyRandomRunway"), options.get("rescueTeam"), options.get("airRefueling"))));
        requests.add(fundingEvent);

        Request jumboJet = new Request(15.0, "Jumbo Jet",
                "A large aircraft carrying [300-600] passengers with [4-6] hours of fuel wishes to land." +
                        "\nIt needs [4-6] hours of runway time.",
                new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))));
        requests.add(jumboJet);

        Request badWeather = new Request(10.0, "Bad weather",
                "Select a bad weather event.",
                new ArrayList<Option>(List.of(options.get("crossWinds"), options.get("icyRunWays"), options.get("iceStorm"))));
        requests.add(badWeather);

        Request snakesOnThePlanes = new Request(10.0, "Snakes on the planes",
                "Enough is enough!\nA pilot is reporting that their plane is being overrun by snakes. They want to land at your airport.",
                new ArrayList<Option>(List.of(options.get("letThemLand"), options.get("refuseThem"))));
        requests.add(snakesOnThePlanes);

        Request protests = new Request(5.0, "Protests",
                "A group of protestors are blocking the runway claiming that your airplanes are dropping chemtrails," +
                        "\nwhich has caused the following health issues: \"makes their toothpaste taste like mint.\"",
                new ArrayList<Option>(List.of(options.get("spaceToProtest"), options.get("getPoliceInvolved"), options.get("planesLandAnyways"))));
        requests.add(protests);

        Request johnMcclain = new Request(5.0, "John McClane",
                "Security reports of a man hijacking a plane on the runway. He claims he needs to stop the terrorists from stealing christmas." +
                        "\nDo you lock down the runway or let them go?",
                new ArrayList<Option>(List.of(options.get("lockDownTheRunway"), options.get("letTheManGo"))));
        requests.add(johnMcclain);
    }

    private static RequestController instance = null;
    private ArrayList<Request> requests = null;


    public static RequestController getInstance() {
        if (instance == null) {
            instance = new RequestController();
        }
        return instance;
    }



    /**
     * The options below are the ones you need to program into the training simulation.
     * The rarity determines the percent chance that request is chosen when randomly choosing a request.
     * Multiple of the same requests can happen in an hour.
     * @param number number of pick requests
     * @return an array with the selected requests
     */
    public Request[] chooseRandomRequest(int number) {

        Request[] chosenRequests = new Request[number];

        int nbRequests = requests.size();

        for(int i=0 ; i<number ; i++){

            Random rand = new Random();
            double nbRand = rand.nextDouble(100);
            //System.out.println("nbRand : " + nbRand);

            double min = 0.0;
            double max = requests.get(0).getRarity();

            for(int j = 0; j<nbRequests; j++){

                //System.out.println("min : " + min + " max : " + max);
                if( (min <= nbRand) && (nbRand < max ) ){
                    chosenRequests[i] = requests.get(j);
                }

                if(j < nbRequests - 1) {
                    min += requests.get(j).getRarity();
                    max += requests.get(j + 1).getRarity();
                }
            }
        }

        return chosenRequests;
    }
}
