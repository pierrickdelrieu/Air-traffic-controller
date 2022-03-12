package AiTravelController.RunwayWaiting;

import AiTravelController.Element.*;


public class Runway {
    private Element elements;

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        if (elements == null) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void empties() {
        elements = null;
    }

    /**
     *
     * @param element
     * @return
     */
    public boolean addElement(Element element) {
        if (elements != null) {
            elements = element;
            return true;
        }
        return false;
    }

    /**
     *
     * @param type
     * @param timeOfBlocking
     */
    public void block(ObstacleType type, int timeOfBlocking) {
        addElement(new Obstacle(type, timeOfBlocking));
    }

}
