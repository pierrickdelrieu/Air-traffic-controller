import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;


public class main {

    public static void main(String[] args) {

//        AiTravelController.AirTravelController.getInstance().run();
        for (Request request: RequestController.getRequest()) {
            System.out.println(request);
        }

    }



}
