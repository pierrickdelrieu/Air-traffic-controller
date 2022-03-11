package Option;

public abstract class Option {
    private String title;
    private String requirement;
    private String consq;


    public Option(String title, String requirement, String consq) {
        this.title = title;
        this.requirement = requirement;
        this.consq = consq;
    }


    public boolean isValid() {
        return false;
    }

    public void apply() {

    }

    @Override
    public String toString() {

        return title + '\n' +
                "Requirements : " + requirement + '\n' +
                "Consequences : " + consq;
    }
}
