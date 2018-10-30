package ui;

import model.InputScreen;
import model.ListOfUniClasses;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TimetableScreen implements InputScreen {

    private ListOfUniClasses louc = new ListOfUniClasses();

    // EFFECTS: creates a new TimetableScreen object.
    public TimetableScreen() {

    }

    // EFFECTS: gets input from the user to decide whether they want to add classes or view classes.
    public int handleOptions(Scanner user_input) {
        int addOrView;
        while (true) {
            try {
                System.out.println("What do you want to do?");
                System.out.println("1. View Classes\n2. Add Classes\n3. Remove Classes\n4. Remove Textbook from Class\n" +
                        "5. Add Textbooks\n6. View Textbooks");
                addOrView = user_input.nextInt();
                user_input.nextLine();
                if (addOrView == 1) {
                    return 1;
                } else if (addOrView == 2) {
                    return 2;
                } else if (addOrView == 3) {
                    return 3;
                } else if (addOrView == 4) {
                    return 4;
                } else if (addOrView == 5) {
                    return 5;
                } else if (addOrView == 6) {
                    return 6;
                } else {
                    System.out.println("Enter a valid choice.");
                }
            }
            catch (InputMismatchException n) {
                System.out.println("You must enter an integer.");
                user_input.nextLine();
            }
        }
    }

    public void addingItemDetails() {
        System.out.println("All classes must have the following fields:");
        System.out.println("-> A class Type (LECTURE/LAB/DISCUSSION/TUTORIAL)\n-> A name\n" +
                "-> A professor\n-> A location\n-> A start time\n-> An end time.\n-> Days of the week");
        System.out.println("N.B. Start and End Time must be in 24hr format e.g. 1400 = 2 pm.");
        System.out.println("N.B. Enter the number that corresponds to the day e.g. Monday = 1, Thursday = 4 etc.");
    }

    // MODIFIES: this
    // EFFECTS: allows user to create a new UniClass and then saves the created UniClass.
    public void addToListObject(Scanner user_input) {
        addingItemDetails();
        louc.addUniClass(user_input);
    }

    // MODIFIES: this
    // EFFECTS: loads all classes from a file into the classList.
    public int loadItemsIntoListObject() {
        String filename = "listofclasses.csv";
        String currentClass;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentClass = bufferedReader.readLine()) != null) {
                louc.loadSingleItem(currentClass);
            }
        } catch (FileNotFoundException fnfex) {
            return 1;
        } catch (IOException ioex) {
            return 2;
        }
        return 0;
    }

    public void removeItem(Scanner user_input) {
        louc.removeItem(user_input);
    }

    public void removeTextbook(Scanner user_input) {
        louc.removeTextbook(user_input);
    }

    public void saveList() {
        louc.saveList();
    }

    public void printStoredItems() {
        louc.printItems();
    }

    public void printTextbooks() {
        louc.printTextbooks();
    }

    public void addTextbook(Scanner user_input) {
        louc.addTextbook(user_input);
    }

    public ListOfUniClasses getListOfUniClasses() {
        return louc;
    }

}
