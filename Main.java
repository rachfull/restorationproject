import java.io.FileNotFoundException;
import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        boolean validInput = false;

        System.out.println("Welcome to the Rachel's Restoration Project!\n");
        System.out.println("\"We gladly declare that the promised Restoration goes forward through continuing revelation. " +
                " The earth will never again be the same, as God will \n'gather together in one all things in Christ.'\"");
        System.out.println("\n--Russell M. Nelson\n");

        while (!validInput) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Press \"c\" to continue or \"e\" to exit the program: ");
            char cont = scanner.next().charAt(0);

            if (cont == 'c') {
                Menu newMenu = new Menu();

                validInput = true;
                System.out.println("\nBegin your search for Book of Mormon scriptures about restored doctrine by viewing the following menu:\n");
                newMenu.initializeOptions();
                System.out.println(newMenu.printMenu());

                boolean enterInput = false;
                String menuOption = null;
                boolean secondaryOption = false; //whether topic is part of a larger topic
                boolean secondRound = false;

                while (!enterInput) {
                    Scanner menuScanner = new Scanner(System.in);
                    System.out.print("Enter your choice here and press \"ENTER\": ");

                    menuOption = menuScanner.next();
                    if (menuOption.equalsIgnoreCase("m")) {
                        System.out.println(newMenu.printMenu()); //print menu
                    } else if (menuOption.equalsIgnoreCase("e")) {
                        break; //exit program
                    } else if (menuOption.equalsIgnoreCase("d")) {
                        newMenu.initializeSubOptions();
                        System.out.println(newMenu.printDoctrineChrist()); //submenu for doctrine of christ
                        if (secondRound) {
                            break;
                        }
                        secondRound = true;
                    } else if (menuOption.equalsIgnoreCase("s")) {
                        newMenu.initializeSubOptions();
                        System.out.println(newMenu.printPlan()); //submenu for plan of salvation
                        if (secondRound) {
                            break;
                        }
                        secondRound = true;
                    } else if (menuOption.equalsIgnoreCase("c")) {
                        newMenu.initializeSubOptions();
                        System.out.println(newMenu.printCommandments()); //submenu for commandments
                        if (secondRound) {
                            secondaryOption = false;
                            break;
                        }
                        secondRound = true;
                        secondaryOption = true;
                    } else if ((!(newMenu.getOptions().contains(menuOption))) && (!(newMenu.getSubOptions().contains(menuOption)))) {
                        System.out.println("Press \"m\" to see the menu again or enter a different option from the menu: ");
                    } else {
                        enterInput = true;
                    }
                }

                if (menuOption.equalsIgnoreCase("e")) {
                    System.out.println("Exiting program.");
                    break;
                }
                String response = null;
                try {
                    Parser parser = new Parser();
                    response = parser.chooseParse(menuOption, secondaryOption);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                if (response != null) {
                    System.out.println(response);
                    System.out.println("Check for an output file with scriptures related to a topic or read them in the console!"+ '\n');
                    validInput = false;
                } else {
                    System.out.println("Something went wrong while displaying the scriptures.");
                }

            } else if (cont == 'e') {
                System.out.println("Exiting program.");
                break;
            }
        }
    }


}
