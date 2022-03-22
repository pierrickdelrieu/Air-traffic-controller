package AiTravelController.Request;

import AiTravelController.Element.Element;
import AiTravelController.Option.Option;
import java.util.ArrayList;

public class Request implements Cloneable {

    private final double rarity;
    private final String title;
    private String desc;
    private final ArrayList<Option> options;



    public Request(double rarity, String title, String desc, ArrayList<Option> options) {
        this.rarity = rarity;
        this.title = title;
        this.desc = desc;
        this.options = options;
    }

    public Request(Request r) {
        this.rarity = r.rarity;
        this.title = r.title;
        this.desc = r.desc;
        this.options = r.options;
    }



    public boolean chooseOption(Option option) {
        if (options.contains(option)) {
            option.apply();
            return true;
        }
        return false;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescr() {
        return this.desc;
    }

    public void setDescr(String string) {
        this.desc = string;
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
        return "---- Request : " + this.getTitle() + " (" + (this.getRarity()) + "%) ---- \n" +
                this.getDescr() + "\n\n";
    }

    @Override
    public Request clone() {
        try {
            Request clone = (Request) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
