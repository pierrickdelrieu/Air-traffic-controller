package Element;

public class Obstacle extends Element {

    private final int time;
    private final ObstacleType type;

    public Obstacle(ObstacleType type, int time) {
        this.type = type;
        this.time = time;
    }

    public int getTime() {
        return this.time;
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
