package AiTravelController.Request;

import AiTravelController.Element.Plane;
import AiTravelController.Option.Option;
import AiTravelController.Option.OptionController;

import java.util.*;

enum RequestType {PLANE_REQUEST, DEFAULT};

public class RequestController {
    private static RequestController instance = null;
    private ArrayList<Request> requests = new ArrayList<Request>();;


    public static RequestController getInstance() {
        if (instance == null) {
            instance = new RequestController();
        }
        return instance;
    }


//    public Request getRequest(RequestType type, double rarity, String title, String desc, ArrayList<Option> options) {
//        return switch (type) {
//            case PLANE_REQUEST -> new PlaneRequest(rarity, title, desc, options);
//            case DEFAULT -> new Request(rarity, title, desc, options);
////            default -> new Request(rarity, title, desc, options);
//        };
//    }


    private RequestController(){
        // Options
        HashMap<String, Option> options = OptionController.getOptionsWithoutParams();



        Request planeLanding = new PlaneRequest(40.0, "Plane Landing",
                "Plane requests to land. It has %d hours of fuel left to wait. It needs %d hours of runway time." +
                        "\nIt has %d passengers.",
                new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))),
                Map.of("minHourOfFuel", 3,
                        "maxHourOfFuel", 5,
                        "minRunwayTime", 1,
                        "maxRunwayTime", 4,
                        "minNbPassenger", 100,
                        "maxNbPassenger", 500));
        requests.add(planeLanding);


        Request emergencyLanding = new PlaneRequest(5.0, "Emergency Landing",
                "Plane requests to land. It has %d hours of fuel left to wait. It requires %d hours of runway time." +
                        "\nIt has %d passengers.",
                new ArrayList<Option>(List.of(options.get("allowLanding"), options.get("placeOnStandby"))),
                Map.of("minHourOfFuel", 1,
                        "maxHourOfFuel", 3,
                        "minRunwayTime", 3,
                        "maxRunwayTime", 5,
                        "minNbPassenger", 100,
                        "maxNbPassenger", 500));
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





    /**
     * The options below are the ones you need to program into the training simulation.
     * The rarity determines the percent chance that request is chosen when randomly choosing a request.
     * Multiple of the same requests can happen in an hour.
     * @param number number of pick requests
     * @return an array with the selected requests
     */
    public ArrayList<Request> chooseRandomRequest(int number) {

        ArrayList<Request> chosenRequests = new ArrayList<>();

//        for(int i=0 ; i<number ; i++){
//            Random rand = new Random();
//
//            double nbRand = rand.nextDouble(100);
//            //System.out.println("nbRand : " + nbRand);
//
//            double min = 0.0;
//            double max = requests.get(0).getRarity();
//
//            for(int j = 0; j<requests.size(); j++){
//
//                //System.out.println("min : " + min + " max : " + max);
//                if( (min <= nbRand) && (nbRand < max ) ){
////                    chosenRequests.add(new Request(requests.get(i)));
//                    chosenRequests.add(requests.get(i).clone());
//                }
//
//                if(j < requests.size() - 1) {
//                    min += requests.get(j).getRarity();
//                    max += requests.get(j + 1).getRarity();
//                }
//            }
//        }

        chosenRequests.add(requests.get(0).clone());
        chosenRequests.add(requests.get(4).clone());

        return chosenRequests;
    }
}
