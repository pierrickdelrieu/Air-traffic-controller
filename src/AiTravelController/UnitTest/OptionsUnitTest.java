package AiTravelController.UnitTest;

import AiTravelController.AirTravelController;
import AiTravelController.Element.Obstacle;
import AiTravelController.Element.ObstacleType;
import AiTravelController.Element.Plane;
import AiTravelController.Option.AllowLandingOpt;
import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;
import AiTravelController.RunwayWaiting.WaitingPlaneController;
import AiTravelController.UI.LandingPlaneMenu;
import AiTravelController.UI.MainMenu;

public class OptionsUnitTest {

//    public static boolean AllowLandingTest() {
//        AllowLandingOpt option = new AllowLandingOpt();
//
//        AirTravelController.getInstance();
//
//
//        // ********** IsValid Test **********
//
//        // At this moment all runway are empty, so the option is available
//        if(!option.isValid()) {
//            return false;
//        }
//
////        LandingPlaneMenu.getInstance().displayBoard();
//
//        for (Runway runway: RunwayController.getInstance().getAllEmptyRunways()) {
//            runway.addElement(new Plane("Plane Test", 3,3,3));
//        }
//        // Now, all runway are full
//        if(option.isValid()) {
//            return false;
//        }
//
////        LandingPlaneMenu.getInstance().displayBoard();
//
//
//
//        // ********** Apply Test **********
//
//
//        return true;
//    }
}
