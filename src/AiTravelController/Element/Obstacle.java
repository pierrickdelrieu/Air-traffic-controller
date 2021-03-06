package AiTravelController.Element;

public class Obstacle extends Element {

    private final ObstacleType type;

    public Obstacle(ObstacleType type, int time) {
        super(time);
        this.type = type;
    }

    /**
     * @return ObstacleType (enumeration) value of the obstacle type
     */
    public ObstacleType getType() {
        return this.type;
    }

    /**
     * @return a String which corresponds to the current obstacle type and its runway time
     */
    @Override
    public String toString() {
        switch (this.type) {
            case POLICE -> {return "  POLICE : " + getRunwayTime() + "h  ";}
            case PROTESTOR -> {return "PROTESTOR : " + getRunwayTime() + "h ";}
            default -> {return " BLOCKED : " + getRunwayTime() + "h ";}
        }
    }

}
