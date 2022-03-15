package AiTravelController.Option;

import java.util.HashMap;

public abstract class Option {
    private final String title;
    private final String requirement;
    private final String consq;
    private HashMap<String, Integer> params;


    public Option(String title, String requirement, String consq, HashMap<String, Integer> params) {
        this.title = title;
        this.requirement = requirement;
        this.consq = consq;
        this.params = new HashMap<>(params);
    }

    public Option(String title, String requirement, String consq) {
        this.title = title;
        this.requirement = requirement;
        this.consq = consq;
    }

    public HashMap<String, Integer> getParams() {
        return params;
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
