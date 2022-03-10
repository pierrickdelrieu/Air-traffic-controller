import java.util.ArrayList;

public class PlaneController {

    private ArrayList<Plane> WaitingPlaneList;
    private ArrayList<Plane> Runways;

    public PlaneController(){
        WaitingPlaneList = new ArrayList<Plane>();
        Runways = new ArrayList<Plane>();
    }

    public ArrayList<Plane> getWaitingPlaneList() {
        return WaitingPlaneList;
    }

    public void setWaitingPlaneList(ArrayList<Plane> waitingPlaneList) {
        WaitingPlaneList = waitingPlaneList;
    }

    public int getNumberWaitingPlane(){
        return WaitingPlaneList.size();
    }

    public ArrayList<Plane> getRunways() {
        return Runways;
    }

    public void setRunways(ArrayList<Plane> runways) {
        Runways = runways;
    }

    public int getNumberOccupiedRunways(){
        return Runways.size();
    }

    public void addAWaitingPlane(Plane aPlane){
        WaitingPlaneList.add(aPlane);
    }

    public void landAPlane(Plane aPlane){
        Runways.add(aPlane);
        removeAWaitingPlane(aPlane);
    }

    public void removeAWaitingPlane(Plane aPlane){
        WaitingPlaneList.remove(aPlane);
    }

    public void removeALandedPlane(Plane aPlane){
        Runways.remove(aPlane);
    }


    public void change_hour_of_fuel(int number_of_change){
        for(Plane each : WaitingPlaneList){
            each.setHour_of_fuel(each.getHour_of_fuel() + number_of_change);
        }
        for(Plane each : WaitingPlaneList){
            if(each.getHour_of_fuel() <= 0){
                System.out.printf("Flight %s crashed due to lack of fuel. Number of deaths: %d \n", each.getName(), each.getNumber_passenger());
                AirTravelController.setNumber_died(each.getNumber_passenger());
                removeAWaitingPlane(each);
            }
        }
    }

    public void change_hour_of_occupies_runways(int number_of_change){
        for(Plane each : Runways){
            each.setRunway_time(each.getRunway_time() + number_of_change);
        }
        for(Plane each : Runways){
            if(each.getRunway_time() <= 0){
                removeALandedPlane(each);
            }
        }
    }

    public void addBlockingRunways(int number_hour_of_blocking){
        Plane blockingPlane = new Plane("Block Runway", 0, 0, number_hour_of_blocking);
        if(Runways.size() < AirTravelController.getNumber_runways()) {
            Runways.add(blockingPlane);
        }
    }




}
