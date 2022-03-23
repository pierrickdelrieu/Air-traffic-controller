package AiTravelController.UI;

import AiTravelController.AirTravelController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private ArrayList<OptionMenu> options = new ArrayList<>();

    public void addOptions(OptionMenu option) {
        options.add(option);
    }

    public void clearOption() { options.clear();}

    public ArrayList<OptionMenu> getOptions() {
        return options;
    }

    /**
     * Title of all page in the game
     */
    public void title() {
        System.out.println("                  -- AIR CONTROLLER SIMULATOR --                    ");
    }

    /**
     * Header of the page
     */
    public void header() {
        System.out.printf("                                             %d passengers killed\n", AirTravelController.getInstance().getNumberDied());
        System.out.printf("                                                  Current time: %d h\n", AirTravelController.getInstance().getNumberHour());
    }

    /**
     * Display board or array such as Array of Runways
     */
    public void displayBoard() {

    }

    /**
     * Update of the options.
     * This function is called every time the menu is called
     */
    public void setOptions() {

    }

    /**
     * Display all OptionMenu object of the menu
     * @param content Array of OptionMenu
     */
    public void displayOption(ArrayList<OptionMenu> content) {
        for (int i = 1; i <= content.size(); i++) {
            System.out.println(i + "  -  " + content.get(i-1).getContent());
        }
    }

    /**
     * User input of a number between two limits [min, max].
     * Securing of the input.
     * @param min int lower bound
     * @param max int upper bound
     * @return int -1 if the value is not a number or if the number is not included in the limits
     * and the value entered by the user otherwise
     */
    public int insertNumber(int min, int max) {

        Scanner keyboard = new Scanner(System.in);
        int select = -1;

        try {
            select = keyboard.nextInt();

            if ((min <= select) && (select <= max)) {
                return select;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Display and selection of the necessary menu options
     * @param content Array of OptionMenu
     * @return The OptionMenu select or null if the input is incorrect
     */
    public OptionMenu optionsSelection(ArrayList<OptionMenu> content) {

        System.out.println("\n                     ** Select an option **\n");

        displayOption(content);

        System.out.print("\nOption : ");

        int select = insertNumber(1, content.size());
        if(select != -1) {
            return content.get(select-1);
        } else {
            return null;
        }
    }

    /**
     * Other content of the menu
     */
    public void content() {

    }

    /**
     * Display all elements (title, header, content, options) of the menu
     */
    public final void show(){
        OptionMenu value = null;
        do {
            clearConsole();
            title();
            header();
            content();

            value = optionsSelection(getOptions());
        } while (value == null);

        value.apply();
    }

    /**
     * Removing all content of the console
     * Does not work in an IDE
     */
    public static void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}

    }

    /**
     * Pause the console
     *
     */
    public static void pause(){

        System.out.println("\n\nPress enter to quit ...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
