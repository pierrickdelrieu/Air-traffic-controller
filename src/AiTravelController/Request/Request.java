package AiTravelController.Request;

import AiTravelController.Option.Option;
import java.util.ArrayList;

public class Request {

    private final double rarity;
    private final String title;
    private final String desc;
    private final ArrayList<Option> options;


    public Request(double rarity, String title, String desc, ArrayList<Option> options) {
        this.rarity = rarity;
        this.title = title;
        this.desc = desc;
        this.options = options;
    }

    /**
     * Getter of rarity
     * @return double rarity of the request
     */
    public double getRarity() {
        return rarity;
    }

    /**
     * Getter of options
     * @return Array of request options
     */
    public ArrayList<Option> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "---- Request : " + this.title + " (" + (this.rarity) + "%) ---- \n" +
                this.desc + "\n\n";
    }

}
