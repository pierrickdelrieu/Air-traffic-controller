package Element;

public class Obstacle extends Element {
    public static enum ObstacleType {PROTESTOR};

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
        if (this.type == ObstacleType.PROTESTOR) {
            return "M";
        }
        return "";
    }

}
