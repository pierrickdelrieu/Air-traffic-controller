package Runway;

import Element.Element;

import java.util.ArrayList;

public class Runway {
    private ArrayList<Element> elements = new ArrayList<>();

    public boolean isEmpty() {
        if (elements.size() == 0) {
            return true;
        }
        return false;
    }

}
