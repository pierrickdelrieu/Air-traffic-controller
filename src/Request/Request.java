package Request;

import Option.Option;
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

    @Override
    public String toString() {
        String opts = "";
        for (Option option: options) {
            opts += option.toString() + "\n\n";
        }

        return this.title + "  |  " + this.rarity + "\n" +
                this.desc + "\n\n" +
                "***** Options *****\n"
                + opts;
    }

}
