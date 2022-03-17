package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Option.AllowLandingOpt;
import AiTravelController.Option.EmptyRandomRunwayOpt;
import AiTravelController.Option.PlaceOnStandbyOpt;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;

import java.util.HashMap;
import java.util.Map;

public class OptionsUnitTest {

    public static boolean AllowLandingTest() {
        AllowLandingOpt option = new AllowLandingOpt();

        AirTravelController.getInstance();


        // ********** IsValid Test **********

        // At this moment all runway are empty, so the option is available
        if(!option.isValid()) {
            return false;
        }

//        LandingPlaneMenu.getInstance().displayBoard();

        for (Runway runway: RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane(3, 3,3));
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
        option.apply(new Plane(3,3,3));
        if (RunwayController.getInstance().getNbEmptyRunway() != 7) {
            return false;
        }

        return true;
    }


    public static boolean PlaceOnStanbyTest() {
        PlaceOnStandbyOpt option = new PlaceOnStandbyOpt();

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


    public static boolean EmptyRandomRunwayTest() {
        EmptyRandomRunwayOpt option = new EmptyRandomRunwayOpt();

        AirTravelController.getInstance();


        // ********** IsValid Test **********

        // At this moment all runway are empty, so the option is available
        if(!option.isValid()) {
            return false;
        }

//        LandingPlaneMenu.getInstance().displayBoard();

        for (Runway runway: RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane( 3,3,3));
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


}
