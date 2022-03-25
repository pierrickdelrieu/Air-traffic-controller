package AiTravelController.UI;

import AiTravelController.RunwayWaiting.Runway;
import AiTravelController.RunwayWaiting.RunwayController;

public class AboutMenu extends Menu {

    private AboutMenu(){}

    private static AboutMenu instance = null;

    public static AboutMenu getInstance() {
        if (instance == null) {
            instance = new AboutMenu();
        }
        instance.setOptions();
        return instance;
    }


    @Override
    public void setOptions() {
        clearOption();
        addOptions(new OptionMenu("Go to Main Menu", OptionType.MAIN_MENU));
    }


    @Override
    public void header() {
        System.out.println("                         -- About Menu --                    \n");
    }


    @Override
    public void content() {

        System.out.println("""
                Welcome to this air traffic controller simulation. The goal is to successfully pass 24 hours while responding to the different incoming requests.
                Each hour, between 1 and 3 requests appear.\s
                During this hour you can :\s
                    - See the waiting planes list
                    - See the runways and the landed planes
                    - See the requests
                
                """);

        System.out.println("""
                ** Requests and options **
                Each requests has several options, which are only available if the conditions are met.\s
                The simulation asks you to select options until there is no more left requests.\s
                Choose an option by paying attention to their consequences. It is up to you to analyze the situation.
                Type the number of the option you want to select and apply. You can't select an unfeasible option.
                
                After answering to all requests, you can pass an hour.
                
                """);

        System.out.println("""
                ** Waiting planes menu **
                At any moment, you can decide to land a waiting plane. Type the number of the plane you want to land.\s
                Be careful to watch their remaining fuel and to land them before it is too late.\s
                
                """);

        System.out.println("""
                ** Land a plane **
                You are no required to specify the runway on which the plane will land.
                Just select the option to land a plane or select a waiting plane in the waiting planes menu
                
                """);

        System.out.println("""
                ** Runways menu **
                At any time, you can observe the state of your runways to know if the planes are on them or if they are blocked.
                
                """);

        System.out.println("""
                ** Advance one hour **
                After answering to all requests, you will see in the main menu an option to pass an hour.
                
                """);

        System.out.println("""
                ** End of the simulation **
                The simulation stops when you reach 24 hours, or when 350 people died\s
                (sometimes, a plane have only one hour of fuel and carry more than 400 passengers, so be careful).
                
                """);

        System.out.println("""
                ** Credits **
                Méric Chenu, Pierrick Delrieu, Guillaume Dumas, Kais Zeghdoud.
                Done as part of a study project at Concordia University of Montreal.
                """);
    }
}
