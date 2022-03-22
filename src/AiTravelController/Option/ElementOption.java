package AiTravelController.Option;

import AiTravelController.Element.Element;

public abstract class ElementOption extends Option {
    private Element element;

    public ElementOption(String title, String requirement, String consq) {
        super(title, requirement, consq);
    }

    /**
     * Public getter to access to the private attribute of this Class
     * @return Element
     */
    public Element getElement() { return element; }

    /**
     * Public setter to set the reference of the private attribute of this Class
     * @param e : Element which will be the private attribute of this Class
     */
    public void setElement(Element e) {
        this.element = e;
    }
}
