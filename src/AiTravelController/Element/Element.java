package AiTravelController.Element;
public abstract class Element {
    private int runwayTime;

    public Element(int runwayTime) {
        this.runwayTime = runwayTime;
    }

    /**
     * @return int value of the current remaining runway time
     */
    public int getRunwayTime() {
        return runwayTime;
    }

    /**
     * Allows to increment or decrement the waiting time on the track according to the increase of the number of hours of the game
     * @param runwayTime new time needed on the runway
     */
    public void setRunwayTime(int runwayTime) {
        this.runwayTime = runwayTime;
    }
}
