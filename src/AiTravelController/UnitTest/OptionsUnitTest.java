package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Option.*;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.UI.LandingPlaneMenu;
import AiTravelController.UI.MenuType;
import AiTravelController.UI.WaitingPlaneMenu;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class OptionsUnitTest {


    /**
     * Displays the boolean result of each UnitTest Option
     */
    public static void MainOptionsUnitTest(){

        System.out.println("AirRefuelingTest : " + AirRefuelingTest());
        System.out.println("AllowLandingTest : " + AllowLandingTest());
        System.out.println("CrossWindsTest : " + CrossWindsTest());
        System.out.println("EmptyRandomRunwayTest : " + EmptyRandomRunwayTest());
        System.out.println("GetPoliceInvolvedTest : " + GetPoliceInvolvedTest());

        System.out.println("IceStormTest : " + IceStormTest());
        System.out.println("IcyRunwaysTest : " + IcyRunwaysTest());
        System.out.println("LetTheManGoTest : " + LetTheManGoTest());
        System.out.println("LetThemLandTest : " + LetThemLandTest());
        System.out.println("LockdownTheRunwayTest : " + LockdownTheRunwayTest());

        System.out.println("PlaceOnStandbyTest : " + PlaceOnStandbyTest());
        System.out.println("PlanesLandAnywaysTest : " + PlanesLandAnywaysTest());
        System.out.println("RefuseThemTest : " + RefuseThemTest());
        System.out.println("RescueTeamTest : " + RescueTeamTest());
        System.out.println("SpaceToProtestTest : " + SpaceToProtestTest());

    }

    /**
     * @return true if all Planes in air have been refueled, false if not
     */
    public static boolean AirRefuelingTest(){
        AirTravelController.getInstance();
        AirRefuelingOpt option = new AirRefuelingOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********

        // clear the waiting plane list
        for(Plane each : WaitingPlaneController.getPlanes()){
            WaitingPlaneController.removePlane(each);
        }

        // we have no waiting plane, so the option is not valid
        if(option.isValid()){
            return false;
        }

        WaitingPlaneController.addPlane(new Plane( 2,2,2));
        // we have one waiting plane, so the option is valid
        if(!option.isValid()){
            return false;
        }

        WaitingPlaneController.addPlane(new Plane(2,2,2));
        // we have two waiting plane, so the option is valid
        if(!option.isValid()){
            return false;
        }

        // ********** Apply Test **********

        int previousFuelOfPlane1 = WaitingPlaneController.getPlanes().get(0).getHourOfFuel();
        int previousFuelOfPlane2 = WaitingPlaneController.getPlanes().get(1).getHourOfFuel();

        option.apply();

        if(WaitingPlaneController.getPlanes().get(0).getHourOfFuel() == previousFuelOfPlane1)
            return false;

        if(WaitingPlaneController.getPlanes().get(1).getHourOfFuel() == previousFuelOfPlane2)
            return false;

        return true;
    }

    /**
     * @return true if the landing of a plane succeeds, false if not
     */
    public static boolean AllowLandingTest() {
        AllowLandingOpt option = new AllowLandingOpt();
        option.setElement(new Plane( 3, 3, 3));

        AirTravelController.getInstance();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********

        // At this moment all runway are empty, so the option is available
        if (!option.isValid()) {
            return false;
        }


//        LandingPlaneMenu.getInstance().displayBoard();

        for (Runway runway : RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane( 3, 3, 3));
        }

        // Now, all runway are full
        if (option.isValid()) {
            System.out.println(2);
            return false;
        }
//        LandingPlaneMenu.getInstance().displayBoard();


        // ********** Apply Test **********
        // Clear Runway
        if (RunwayController.getInstance().getNFullRandomRunway(8) == null) {
            return false;
        }
        for (Runway runway : RunwayController.getInstance().getNFullRandomRunway(8)) {
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

    /**
     * @return true if the fuel level of all Planes in air have been decreased by 1 hour, false if not
     */
    public static boolean CrossWindsTest() {
        AirTravelController.getInstance();
        CrossWindsOpt option = new CrossWindsOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;

        // ********** Apply Test **********

        // clear the waiting plane list
        while (WaitingPlaneController.hasWaitingPlane()){
            WaitingPlaneController.removePlane(WaitingPlaneController.getPlanes().get(0));
        }

        WaitingPlaneController.addPlane(new Plane( 2,2,2));
        WaitingPlaneController.addPlane(new Plane( 1,2,2));
        WaitingPlaneController.addPlane(new Plane( 2,2,2));

        option.apply();

        /*
        // display waiting plane
        for(Plane each : WaitingPlaneController.getPlanes()){
            System.out.println(each.toString(MenuType.WAITING));
        }
        System.out.println("\n");
        */

        if(WaitingPlaneController.getPlanes().size() != 2) {
            System.out.println("Error in removing plane test2 from waiting list");
            return false;
        }

        if( WaitingPlaneController.getPlanes().get(0).getHourOfFuel() != 1 )
            return false;
        if( WaitingPlaneController.getPlanes().get(1).getHourOfFuel() != 1 )
            return false;

        return true;
    }

    /**
     * @return true if a random runway have been emptied, false if not
     */
    public static boolean EmptyRandomRunwayTest(){
        EmptyRandomRunwayOpt option = new EmptyRandomRunwayOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********

        // we clear all runways
        for (Runway each: RunwayController.getInstance().getRunways()) {
            each.empties();
        }
        if (RunwayController.getInstance().getNbEmptyRunway() != 8) {
            return false;
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have no full runway, so the option is not valid
        if(option.isValid())
            return false;

        //we fill in a runway
        for (Runway each: RunwayController.getInstance().getNEmptyRandomRunway(2)) {
            each.addElement(new Plane( 2,2,2));
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have a full runway, so the option is valid
        if(!option.isValid())
            return false;

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have two full runways, so the option is valid
        if(!option.isValid())
            return false;

        // ********** Apply Test **********

        int previousNumberOfEmptyRunways = RunwayController.getInstance().getNbEmptyRunway();

//        LandingPlaneMenu.getInstance().displayBoard();
//        System.out.println(RunwayController.getInstance().getNbEmptyRunway());
        option.apply();

//        System.out.println(RunwayController.getInstance().getNbEmptyRunway());
//        LandingPlaneMenu.getInstance().displayBoard();

        if(RunwayController.getInstance().getNbEmptyRunway() != previousNumberOfEmptyRunways + 1)
            return false;


        return true;
    }

    /**
     *
     * @return true if 2 runways have been blocked for 4 hours, false if not
     */
    public static boolean GetPoliceInvolvedTest(){
        GetPoliceInvolvedOpt option = new GetPoliceInvolvedOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********

        //LandingPlaneMenu.getInstance().displayBoard();

        //we fill in all the runways
        for (Runway each: RunwayController.getInstance().getAllEmptyRunways()) {
            each.addElement(new Plane(2,2,2));
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        // All runway are full, so the option is not valid
        if(option.isValid()) {
            return false;
        }

        // now we clear 1 runway
        RunwayController.getInstance().getRunways().get(0).empties();

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have 1 free runway, so the option is not valid
        if(option.isValid()) {
            return false;
        }

        // now we clear 1 other runway
        RunwayController.getInstance().getRunways().get(1).empties();

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have 2 free runway, so the option is valid
        if(!option.isValid()) {
            return false;
        }


        // we clear all runways
        for (Runway each: RunwayController.getInstance().getRunways()) {
            each.empties();
        }

        if (RunwayController.getInstance().getNbEmptyRunway() != 8) {
            return false;
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        // ********** Apply Test **********

        if (RunwayController.getInstance().getNEmptyRandomRunway(2) == null) {
            return false;
        }

        option.apply();
        //LandingPlaneMenu.getInstance().displayBoard();

        return RunwayController.getInstance().getNbEmptyRunway() == 6;
    }

    /**
     * @return true if a runway have been definitively removed, false if not
     */
    public static boolean IceStormTest() {
        IceStormOpt option = new IceStormOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        if (!option.isValid()) return false; //the 8 runways are empty sor isValid() must be true

        option.apply(); // removing an empty runway

        int count = 0;
        for (Runway runway : RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane( 3, 3, 3));
            count++;
        }

        return count == 7; //7 runways should be used by the added planes
    }

    /**
     * @return true if the runway time of all the Planes on runways have been increased by 2 hours, false if not
     */
    public static boolean IcyRunwaysTest() {
        IcyRunWaysOpt option = new IcyRunWaysOpt();

        // Clean system
        AirTravelController.getInstance().clear();


        if (RunwayController.getInstance().getNbEmptyRunway() != 8) {
            System.out.println("1");
            return false;
        }

        if (!option.isValid()) {
            System.out.println("2");
            return false;
        }

        Runway[] runway = RunwayController.getInstance().getNEmptyRandomRunway(1); //getting an empty runway
        runway[0].addElement(new Plane( 0, 0, 1)); //adding a plane in it

        option.apply(); // adding 2 hours wait time to the plane

        return runway[0].getElement().getRunwayTime() == 3;
    }

    /**
     * @return true if a waiting plane on air have been removed and 100 passengers killed, false if not
     */
    public static boolean LetTheManGoTest() {
        LetTheManGoOpt option = new LetTheManGoOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        if (!option.isValid()) return false; // no requirements so isValid must return true

        WaitingPlaneController.addPlane(new Plane( 2, 100, 0));

        option.apply(); //removing a random waiting plane and killing 100 passengers

        if (AirTravelController.getInstance().getNumberDied() != 100 || WaitingPlaneController.hasWaitingPlane())
            return false;

        return true;
    }

    /**
     * @return true if a plane lands and occupies a runway for 7 hours, false if not
     */
    public static boolean LetThemLandTest() {
        LetThemLandOpt option = new LetThemLandOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        if (!option.isValid()) return false; //at least 1 empty runway

        option.apply();

        if (RunwayController.getInstance().getNbEmptyRunway() != 7) return false; //7 empty runways should be free

        for (Runway runway : RunwayController.getInstance().getRunways()) { //loop to find the landed plane
            if (runway.getElement() != null && runway.getElement().getRunwayTime() != 7) //runwayTime should be set at 7
                return false;
        }
        return true;
    }

    /**
     * @return true if a runway have been blocked for 8 hours, false if not
     */
    public static boolean LockdownTheRunwayTest() {
        LockdownTheRunwayOpt option = new LockdownTheRunwayOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        if (!option.isValid()) return false;

        option.apply();

        if (RunwayController.getInstance().getNbEmptyRunway() != 7) return false;

        for (Runway runway : RunwayController.getInstance().getRunways()) {
            if (runway.getElement() != null && runway.getElement().getRunwayTime() != 8) return false;
        }

        return true;
    }

    /**
     * @return true if a plane joins the waiting planes, false if not
     */
    public static boolean PlaceOnStandbyTest() {
        PlaceOnStandbyOpt option = new PlaceOnStandbyOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********
        if (!option.isValid()) // no requirements so isValid must return true
            return false;

        // ********** Apply Test **********
        int previousNumberOfWaitingPlane = WaitingPlaneController.getPlanes().size();

        option.apply();

        return WaitingPlaneController.getPlanes().size() == previousNumberOfWaitingPlane + 1;

    }

    /**
     * @return true if the planes lands and 100 passengers have been killed, false if not
     */
    public static boolean PlanesLandAnywaysTest(){
        PlanesLandAnywaysOpt option = new PlanesLandAnywaysOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        int previousNumberOfDead = AirTravelController.getInstance().getNumberDied();
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == previousNumberOfDead + 100;

    }

    /**
     * @return true if 50 people died, false if not
     */
    public static boolean RefuseThemTest(){
        RefuseThemOpt option = new RefuseThemOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        int previousNumberOfDead = AirTravelController.getInstance().getNumberDied();
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == previousNumberOfDead + 50;

    }

    /**
     * @return true if the number of dead passenger have been reduced by 100, false if not
     */
    public static boolean RescueTeamTest(){
        RescueTeamOpt option = new RescueTeamOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        AirTravelController.getInstance().increaseNumberDied(200);
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == 200 - 100;

    }

    /**
     * @return true if a runway have been blocked for 10 hours, false if not
     */
    public static boolean SpaceToProtestTest(){
        SpaceToProtestOpt option = new SpaceToProtestOpt();

        // Clean system
        AirTravelController.getInstance().clear();

        // ********** IsValid Test **********

        //LandingPlaneMenu.getInstance().displayBoard();

        //we fill in all the runways
        for (Runway each: RunwayController.getInstance().getAllEmptyRunways()) {
            each.addElement(new Plane( 2,2,2));
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        // All runway are full, so the option is not valid
        if(option.isValid()) {
            return false;
        }

        // now we clear 1 runways
        for (Runway each: RunwayController.getInstance().getNFullRandomRunway(1)) {
            each.empties();
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        //we have 1 free runway, so the option is valid
        if(!option.isValid()) {
            return false;
        }

        // we clear all runways
        for (Runway each: RunwayController.getInstance().getRunways()) {
            each.empties();
        }

        if (RunwayController.getInstance().getNbEmptyRunway() != 8) {
            return false;
        }

        //LandingPlaneMenu.getInstance().displayBoard();

        // ********** Apply Test **********

        if (RunwayController.getInstance().getNEmptyRandomRunway(1) == null) {
            return false;
        }

        option.apply();
        //LandingPlaneMenu.getInstance().displayBoard();

        return RunwayController.getInstance().getNbEmptyRunway() == 7;

    }

}
