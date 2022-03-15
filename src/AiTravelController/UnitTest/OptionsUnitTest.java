package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Option.AllowLandingOpt;
import AiTravelController.Option.IceStormOpt;
import AiTravelController.Option.PlaceOnStandbyOpt;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.HashMap;
import java.util.Map;

public class OptionsUnitTest {

    public static boolean AllowLandingTest() {
        AllowLandingOpt option = new AllowLandingOpt(new HashMap<>(
                Map.of("minHourOfFuel", 3,
                        "maxHourOfFuel", 5,
                        "minHourOfRunway", 1,
                        "maxHourOfRunway", 4,
                        "minNbPassenger", 100,
                        "maxNbPassenger", 500)));

        AirTravelController.getInstance();


        // ********** IsValid Test **********

        // At this moment all runway are empty, so the option is available
        if(!option.isValid()) {
            return false;
        }

//        LandingPlaneMenu.getInstance().displayBoard();

        for (Runway runway: RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane("Plane Test", 3,3,3));
        }

        // Now, all runway are full
        if(option.isValid()) {
            return false;
        }
//        LandingPlaneMenu.getInstance().displayBoard();




        // ********** Apply Test **********
        // Clear Runway
        if (RunwayController.getInstance().getNFullRandomRunway(8) == null) {
            return false;
        }
        for (Runway runway: RunwayController.getInstance().getNFullRandomRunway(8)) {
            runway.empties();
        }
//        LandingPlaneMenu.getInstance().displayBoard();
        if (RunwayController.getInstance().getNFullRandomRunway(8) != null) {
            return false;
        }


        // Apply
        if (RunwayController.getInstance().getNEmptyRandomRunway(1) == null) {
            return false;
        }
        option.apply();
        if (RunwayController.getInstance().getNbEmptyRunway() != 7) {
            return false;
        }

        return true;
    }


    public static boolean PlaceOnStanbyTest() {
        PlaceOnStandbyOpt option = new PlaceOnStandbyOpt(new HashMap<>(
                Map.of("minHourOfFuel", 3,
                        "maxHourOfFuel", 5,
                        "minHourOfRunway", 1,
                        "maxHourOfRunway", 4,
                        "minNbPassenger", 100,
                        "maxNbPassenger", 500)));

        AirTravelController.getInstance();


        // ********** Apply Test **********
        // Apply
        if (WaitingPlaneController.hasWaitingPlane()) {
            return false;
        }
        option.apply();
        if (!WaitingPlaneController.hasWaitingPlane()) {
            return false;
        }

        return true;
    }

    public static boolean IceStormTest(){
        AirTravelController.getInstance();
        IceStormOpt option = new IceStormOpt();

        if(!option.isValid()) return false; //the 8 runways are empty sor isValid() must be true

        option.apply(); // removing an empty runway

        int count = 0;
        for (Runway runway: RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane("Plane Test", 3,3,3));
            count++;
        }

        if (count != 7) return false; //7 runways should be used by the added planes

        return true;
    }

    public static boolean IcyRunwaysTest(){
        return true;
    }

    public static boolean LetTheManGoTest(){
        return true;
    }

    public static boolean LetThemLandTest(){
        return true;
    }

    public static boolean LockdownTheRunwayTest(){
        return true;
    }

    public static boolean IceStormOpt(){
        return true;
    }
}
