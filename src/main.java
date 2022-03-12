import Option.Option;
import Option.CrossWindsOpt;
import Request.Request;
import Request.RequestController;


public class main {

    public static void main(String[] args) {

//        AirTravelController.getInstance().run();
        for (Request request: RequestController.getRequest()) {
            System.out.println(request);
        }



    }

}
