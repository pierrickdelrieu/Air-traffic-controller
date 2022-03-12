package AiTravelController.UI;


public abstract class Menu {


    public void title() {
        System.out.println("                  -- Air Contoller Simulator --                    ");
    }

    public void header() {

    }

    public void displayTable() {

    }

    public int optionSelection() {
        return 0;
    }

    public void displayText(String text) {
        System.out.println(text);
    }

    public void show(){}

    public static void clearConsole(){}
}
