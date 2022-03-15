package AiTravelController.Element;

import AiTravelController.UI.MenuType;

import java.util.Random;

public abstract class Element {
    private int runwayTime;

    public Element(int runwayTime) {
        this.runwayTime = runwayTime;
    }

    public Element(Integer[] runwayTime) {
        Random rand = new Random();
        this.runwayTime = rand.nextInt((runwayTime[1] - runwayTime[0]) + 1) + runwayTime[0];
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

    public void increaseRunwayTime(int runwayTime) {
        this.runwayTime += runwayTime;
    }

    public void decreaseRunwayTime(int runwayTime) {
        this.runwayTime -= runwayTime;
    }


    public String toString(MenuType landed) {
        return "";
    }
}
