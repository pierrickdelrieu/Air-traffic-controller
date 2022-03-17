package AiTravelController.Option;

import AiTravelController.Element.Element;

public abstract class ElementOption extends Option {
    private Element element;

    public ElementOption(String title, String requirement, String consq) {
        super(title, requirement, consq);
    }

    public Element getElement() { return element; }

//    @Override
//    public void apply() {
//        if (element != null) {
//            System.out.println("Option is apply specific");
//            apply(element);
//        } else {
//            System.out.println("Option is apply main");
//            super.apply();
//        }
//    }

//    public void apply(Element e) {
//
//    }

    public void setElement(Element e) {
        this.element = e;
    }
}
