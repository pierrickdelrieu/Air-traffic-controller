package AiTravelController.Option;


public abstract class Option {
    private final String title;
    private final String requirement;
    private final String consq;

    public Option(String title, String requirement, String consq) {
        this.title = title;
        this.requirement = requirement;
        this.consq = consq;
    }

    /**
     *
     * @return
     */
    public boolean isValid() {
        return false;
    }

    /**
     *
     */
    public void apply() {

    }

    @Override
    public String toString() {

        return title + '\n' +
                "Requirements : " + requirement + '\n' +
                "Consequences : " + consq;
    }
}
