package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Plane;
import AiTravelController.Option.*;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.UI.LandingPlaneMenu;
import AiTravelController.UI.WaitingPlaneMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OptionsUnitTest {

    /* model

    public static boolean GetPoliceInvolvedTest(){
        AirTravelController.getInstance();
        GetPoliceInvolvedOpt option = new GetPoliceInvolvedOpt();

        // ********** IsValid Test **********




        // ********** Apply Test **********



        return true;
    }

     */

    public static boolean MainOptionsUnitTest(){

        System.out.println("Process all Options Unit Tests");

        if( !AirRefuelingTest() ){
            System.out.println("AirRefuelingTest is false");
            return false;
        }
        if( !AllowLandingTest() ){
            System.out.println("AllowLandingTest is false");
            return false;
        }
        if( !CrossWindsTest() ){
            System.out.println("CrossWindsTest is false");
            return false;
        }
        if( !EmptyRandomRunwayTest() ){
            System.out.println("EmptyRandomRunwayTest is false");
            return false;
        }
        if( !GetPoliceInvolvedTest() ){
            System.out.println("GetPoliceInvolvedTest is false");
            return false;
        }

        if( !IceStormTest() ){
            System.out.println("IceStormTest is false");
            return false;
        }
        if( !IcyRunwaysTest() ){
            System.out.println("IcyRunwaysTest is false");
            return false;
        }
        if( !LetTheManGoTest() ){
            System.out.println("LetTheManGoTest is false");
            return false;
        }
        if( !LetThemLandTest() ){
            System.out.println("LetThemLandTest is false");
            return false;
        }
        if( !LockdownTheRunwayTest() ){
            System.out.println("LockdownTheRunwayTest is false");
            return false;
        }

        if( !PlaceOnStandbyTest() ){
            System.out.println("PlaceOnStandbyTest is false");
            return false;
        }
        if( !PlanesLandAnywaysTest() ){
            System.out.println("PlanesLandAnywaysTest is false");
            return false;
        }
        if( !RefuseThemTest() ){
            System.out.println("RefuseThemTest is false");
            return false;
        }
        if( !RescueTeamTest() ){
            System.out.println("RescueTeamTest is false");
            return false;
        }
        if( !SpaceToProtestTest() ){
            System.out.println("SpaceToProtestTest is false");
            return false;
        }

        System.out.println("All tests passed with success");
        return true;
    }

    public static boolean AirRefuelingTest(){
        AirTravelController.getInstance();
        AirRefuelingOpt option = new AirRefuelingOpt();

        // ********** IsValid Test **********

        // clear the waiting plane list
        for(Plane each : WaitingPlaneController.getPlanes()){
            WaitingPlaneController.removePlane(each);
        }

        // we have no waiting plane, so the option is not valid
        if(option.isValid()){
            return false;
        }

        WaitingPlaneController.addPlane(new Plane("test1", 2,2,2));
        // we have one waiting plane, so the option is valid
        if(!option.isValid()){
            return false;
        }

        WaitingPlaneController.addPlane(new Plane("test2", 2,2,2));
        // we have two waiting plane, so the option is valid
        if(!option.isValid()){
            return false;
        }

        // ********** Apply Test **********

        option.apply();

        if(WaitingPlaneController.getPlanes().get(0).getHourOfFuel() != 4)
            return false;

        if(WaitingPlaneController.getPlanes().get(1).getHourOfFuel() != 4)
            return false;

        return true;
    }

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
        if (!option.isValid()) {
            return false;
        }

//        LandingPlaneMenu.getInstance().displayBoard();

        for (Runway runway : RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane("Plane Test", 3, 3, 3));
        }

        // Now, all runway are full
        if (option.isValid()) {
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

    public static boolean CrossWindsTest() {
        AirTravelController.getInstance();
        CrossWindsOpt option = new CrossWindsOpt();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;

        // ********** Apply Test **********

        // clear the waiting plane list
        for(Plane each : WaitingPlaneController.getPlanes()){
            WaitingPlaneController.removePlane(each);
        }

        option.apply();

        WaitingPlaneController.addPlane(new Plane("test1", 2,2,2));
        WaitingPlaneController.addPlane(new Plane("test2", 2,2,2));
        WaitingPlaneController.addPlane(new Plane("test3", 1,2,2));

        int previousHourOfFuelTest1 = WaitingPlaneController.getPlanes().get(0).getHourOfFuel();
        int previousHourOfFuelTest2 = WaitingPlaneController.getPlanes().get(1).getHourOfFuel();

        option.apply();

        if(WaitingPlaneController.getPlanes().size() != 2) {
            System.out.println("Error in removing plane from waiting list");
            return false;
        }

        if( WaitingPlaneController.getPlanes().get(0).getHourOfFuel() != 1 )
            return false;
        if( WaitingPlaneController.getPlanes().get(1).getHourOfFuel() != 1 )
            return false;

        return true;
    }

    public static boolean EmptyRandomRunwayTest(){
        AirTravelController.getInstance();
        EmptyRandomRunwayOpt option = new EmptyRandomRunwayOpt();

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
            each.addElement(new Plane("test", 2,2,2));
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

        option.apply();

        //LandingPlaneMenu.getInstance().displayBoard();

        if(RunwayController.getInstance().getNbEmptyRunway() != previousNumberOfEmptyRunways - 1)
            return false;


        return true;
    }

    public static boolean GetPoliceInvolvedTest(){
        AirTravelController.getInstance();
        GetPoliceInvolvedOpt option = new GetPoliceInvolvedOpt();

        // ********** IsValid Test **********

        //LandingPlaneMenu.getInstance().displayBoard();

        //we fill in all the runways
        for (Runway each: RunwayController.getInstance().getAllEmptyRunways()) {
            each.addElement(new Plane("police", 2,2,2));
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


    public static boolean IceStormTest() {
        AirTravelController.getInstance();
        IceStormOpt option = new IceStormOpt();

        if (!option.isValid()) return false; //the 8 runways are empty sor isValid() must be true

        option.apply(); // removing an empty runway

        int count = 0;
        for (Runway runway : RunwayController.getInstance().getAllEmptyRunways()) {
            runway.addElement(new Plane("Plane Test", 3, 3, 3));
            count++;
        }

        return count == 7; //7 runways should be used by the added planes
    }


    public static boolean IcyRunwaysTest() {
        AirTravelController.getInstance();
        IcyRunWaysOpt option = new IcyRunWaysOpt();

        if (!option.isValid()) return false;

        Runway[] runway = RunwayController.getInstance().getNEmptyRandomRunway(1); //getting an empty runway
        runway[0].addElement(new Plane("Plane Test", 0, 0, 1)); //adding a plane in it

        option.apply(); // adding 2 hours wait time to the plane

        return runway[0].getElement().getRunwayTime() == 3;
    }


    public static boolean LetTheManGoTest() {
        AirTravelController.getInstance();
        LetTheManGoOpt option = new LetTheManGoOpt();

        if (!option.isValid()) return false; // no requirements so isValid must return true

        WaitingPlaneController.addPlane(new Plane("test Plane", 2, 100, 0));

        option.apply(); //removing a random waiting plane and killing 100 passengers

        if (AirTravelController.getInstance().getNumberDied() != 100 || WaitingPlaneController.hasWaitingPlane())
            return false;

        return true;
    }


    public static boolean LetThemLandTest() {
        AirTravelController.getInstance();
        LetThemLandOpt option = new LetThemLandOpt();

        if (!option.isValid()) return false; //at least 1 empty runway

        option.apply();

        if (RunwayController.getInstance().getNbEmptyRunway() != 7) return false; //7 empty runways should be free

        for (Runway runway : RunwayController.getInstance().getRunways()) { //loop to find the landed plane
            if (runway.getElement() != null && runway.getElement().getRunwayTime() != 7) //runwayTime should be set at 7
                return false;
        }
        return true;
    }


    public static boolean LockdownTheRunwayTest() {
        AirTravelController.getInstance();
        LockdownTheRunwayOpt option = new LockdownTheRunwayOpt();

        if (!option.isValid()) return false;

        option.apply();

        if (RunwayController.getInstance().getNbEmptyRunway() != 7) return false;

        for (Runway runway : RunwayController.getInstance().getRunways()) {
            if (runway.getElement() != null && runway.getElement().getRunwayTime() != 8) return false;
        }

        return true;
    }

    public static boolean PlaceOnStandbyTest() {
        AirTravelController.getInstance();
        PlaceOnStandbyOpt option = new PlaceOnStandbyOpt(
                new HashMap<>(
                        Map.of("minHourOfFuel", 3,
                                "maxHourOfFuel", 5,
                                "minHourOfRunway", 1,
                                "maxHourOfRunway", 4,
                                "minNbPassenger", 100,
                                "maxNbPassenger", 500))
        );

        // ********** IsValid Test **********
        if (!option.isValid()) // no requirements so isValid must return true
            return false;

        // ********** Apply Test **********
        int previousNumberOfWaitingPlane = WaitingPlaneController.getPlanes().size();

        option.apply();

        return WaitingPlaneController.getPlanes().size() == previousNumberOfWaitingPlane + 1;

    }

    public static boolean PlanesLandAnywaysTest(){
        AirTravelController.getInstance();
        PlanesLandAnywaysOpt option = new PlanesLandAnywaysOpt();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        int previousNumberOfDead = AirTravelController.getInstance().getNumberDied();
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == previousNumberOfDead + 100;

    }

    public static boolean RefuseThemTest(){
        AirTravelController.getInstance();
        RefuseThemOpt option = new RefuseThemOpt();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        int previousNumberOfDead = AirTravelController.getInstance().getNumberDied();
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == previousNumberOfDead + 50;

    }

    public static boolean RescueTeamTest(){
        AirTravelController.getInstance();
        RescueTeamOpt option = new RescueTeamOpt();

        // ********** IsValid Test **********
        if(!option.isValid()) // no requirements so isValid must return true
            return false;


        // ********** Apply Test **********
        int previousNumberOfDead = AirTravelController.getInstance().getNumberDied();
        option.apply();

        return AirTravelController.getInstance().getNumberDied() == previousNumberOfDead - 100;

    }

    public static boolean SpaceToProtestTest(){
        AirTravelController.getInstance();
        SpaceToProtestOpt option = new SpaceToProtestOpt();

        // ********** IsValid Test **********

        //LandingPlaneMenu.getInstance().displayBoard();

        //we fill in all the runways
        for (Runway each: RunwayController.getInstance().getAllEmptyRunways()) {
            each.addElement(new Plane("test", 2,2,2));
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
