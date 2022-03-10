public class main {

    public static void main(String[] args) {
        System.out.println("Hello word");
	    System.out.println("dev_guillaume");

        /*
        AirTravelController airTravelController = new AirTravelController();

        System.out.println("Test : " +
                airTravelController.getNumber_died() +
                airTravelController.getNumber_hour() );
        airTravelController.pass_hour_removed_fuel();
        System.out.println("Test : " +
                airTravelController.getNumber_died() +
                airTravelController.getNumber_hour() );


        Menu menu = new Menu();
        menu.displayMainMenu(airTravelController.getNumber_hour(), airTravelController.getNumber_died(), 2);
        */

        PlaneController planeController = new PlaneController();
        Plane plane1 = new Plane("AF344", 3,200, 3 );
        Plane plane2 = new Plane("LH400", 1,50, 1 );
        Plane plane3 = new Plane("Sid714", 2,100, 2 );

        planeController.addAWaitingPlane(plane1);
        planeController.addAWaitingPlane(plane2);
        planeController.addAWaitingPlane(plane3);

        Menu menu = new Menu();

        System.out.println("");

        System.out.println("on affiche les avions en attente");
        menu.displayWaitingPlanesMenu(planeController);

        System.out.println(AirTravelController.getNumber_died());

        System.out.println("On retire 1h de fuel");
        planeController.change_hour_of_fuel(-1);
        menu.displayWaitingPlanesMenu(planeController);

        System.out.println(AirTravelController.getNumber_died());

        System.out.println("on affiche les pistes -> vide");
        menu.displayRunwayMenu(planeController);

        System.out.println("On fait atterir un avion -> le Sid714");
        planeController.landAPlane(planeController.getWaitingPlaneList().get(1));
        menu.displayRunwayMenu(planeController);
        menu.displayWaitingPlanesMenu(planeController);

        System.out.println("On bloque une piste pour 4h");
        planeController.addBlockingRunways(4);
        menu.displayRunwayMenu(planeController);

        System.out.println("on enlève 1h aux avions qui sont sur pistes");
        planeController.change_hour_of_occupies_runways(-1);
        menu.displayRunwayMenu(planeController);

        System.out.println("on enlève 1h aux avions qui sont sur pistes");
        planeController.change_hour_of_occupies_runways(-1);
        menu.displayRunwayMenu(planeController);




    }

}
