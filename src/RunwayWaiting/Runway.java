package RunwayWaiting;

import Element.*;


public class Runway {
    private Element elements;

    public boolean isEmpty() {
        if (elements == null) {
            return true;
        }
        return false;
    }

    public void empties() {
        elements = null;
    }

    public boolean addElement(Element element) {
        if (elements != null) {
            elements = element;
            return true;
        }
        return false;
    }

    public void block(ObstacleType type, int timeOfBlocking) {
        addElement(new Obstacle(type, timeOfBlocking));
    }

}
