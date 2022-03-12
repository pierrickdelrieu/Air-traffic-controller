package Element;

public abstract class Element {
    private int runwayTime;

    public Element(int runwayTime) {
        this.runwayTime = runwayTime;
    }

    public int getRunwayTime() {
        return runwayTime;
    }

    public void setRunwayTime(int runwayTime) {
        this.runwayTime = runwayTime;
    }
}
