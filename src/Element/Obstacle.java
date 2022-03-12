package Element;

public class Obstacle extends Element {

    private final ObstacleType type;

    public Obstacle(ObstacleType type, int time) {
        super(time);
        this.type = type;
    }

    public ObstacleType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case POLICE -> {return "P";}
            case PROTESTOR -> {return "M";}
            default -> {return "O";}
        }
    }

}
