package AiTravelController.RunwayWaiting;

import AiTravelController.Element.*;
import AiTravelController.UI.MenuType;


public class Runway {
    private Element element = null;

    public Element getElement(){return element;}

    /**
     * Reduce time of element.
     * This function is called when the main game time is advanced.
     * @param hour int number of hours has decreased
     */
    public void reduceTimeOfElement(int hour) {
        if (element != null) {
            element.setRunwayTime(element.getRunwayTime() - hour);
        }
    }

    /**
     * Check if runway has an element
     * @return true if runway is empty and false otherwise
     */
    public boolean isEmpty() {
        return element == null;
    }

    /**
     * Empty the runway
     */
    public void empties() {
        element = null;
    }

    /**
     * Add element to the runway if the runway is empty
     * @param element element to add
     * @return true if the element has been added and false otherwise
     */
    public boolean addElement(Element element) {
        if (this.element == null) {
            this.element = element;
            return true;
        }
        return false;
    }

    /**
     * Block the runway
     * @param type Type of obstacle
     * @param timeOfBlocking blocking time
     */
    public void block(ObstacleType type, int timeOfBlocking) {
        addElement(new Obstacle(type, timeOfBlocking));
    }


    @Override
    public String toString() {
        if (element != null) {
            if (element.getClass().getName().equals("AiTravelController.Element.Plane")) {
                return "----------  " + element.toString(MenuType.LANDING) + "  ----------";
            } else {
                return "-----------  " + element + "  -----------";
            }
        }
        return "-----------------------------------------";
    }

}
