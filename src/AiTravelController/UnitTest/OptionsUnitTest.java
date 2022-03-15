package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Option.*;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.ArrayList;
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

        return count == 7; //7 runways should be used by the added planes
    }


    public static boolean IcyRunwaysTest(){
        AirTravelController.getInstance();
        IcyRunWaysOpt option = new IcyRunWaysOpt();

        if (!option.isValid()) return false;

        Runway[] runway = RunwayController.getInstance().getNEmptyRandomRunway(1); //getting an empty runway
        runway[0].addElement(new Plane("Plane Test", 0,0,1)); //adding a plane in it

        option.apply(); // adding 2 hours wait time to the plane

        return runway[0].getElement().getRunwayTime() == 3;
    }


    public static boolean LetTheManGoTest(){
        AirTravelController.getInstance();
        LetTheManGoOpt option = new LetTheManGoOpt();

        if (!option.isValid()) return false; // no requirements so isValid must return true

        WaitingPlaneController.addPlane(new Plane("test Plane",2,100,0));

        option.apply(); //removing a random waiting plane and killing 100 passengers

        if (AirTravelController.getInstance().getNumberDied() != 100 || WaitingPlaneController.hasWaitingPlane() )
            return false;

        return true;
    }


    public static boolean LetThemLandTest(){
        AirTravelController.getInstance();
        LetThemLandOpt option = new LetThemLandOpt();

        if(!option.isValid()) return false; //at least 1 empty runway

        option.apply();

        if (RunwayController.getInstance().getNbEmptyRunway() != 7) return false; //7 empty runways should be free

        for (Runway runway: RunwayController.getInstance().getRunways()) { //loop to find the landed plane
            if (runway.getElement() != null && runway.getElement().getRunwayTime() != 7) //runwayTime should be set at 7
                return false;
        }
        return true;
    }


    public static boolean LockdownTheRunwayTest(){
        AirTravelController.getInstance();
        LockdownTheRunwayOpt option = new LockdownTheRunwayOpt();

        if(!option.isValid()) return false;

        option.apply();

        if(RunwayController.getInstance().getNbEmptyRunway() != 7) return false;

        for (Runway runway: RunwayController.getInstance().getRunways()){
            if(runway.getElement() != null && runway.getElement().getRunwayTime() != 8) return false;
        }

        return true;
    }

}
