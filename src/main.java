import AiTravelController.Request.Request;
import AiTravelController.Request.RequestController;


public class main {

    public static void main(String[] args) {

//        AiTravelController.AirTravelController.getInstance().run();
        for (Request request: RequestController.getRequest()) {
            System.out.println(request);
        }

        System.out.println("Selected requests\n");
        Request[] selectedRequests = RequestController.chooseRandomRequest(3);
        for (Request each : selectedRequests) {
            System.out.println(each);
        }

    }



}
