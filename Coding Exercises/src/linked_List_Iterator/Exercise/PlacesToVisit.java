package linked_List_Iterator.Exercise;

import java.util.*;

public class PlacesToVisit {

    LinkedList<String> citiesList = new LinkedList<>();

    private void printList() {

        Iterator<String> iterator = this.citiesList.iterator();
        while (iterator.hasNext()) {
            System.out.println("*Cities to visit in alphabetical order*\n");
            for (int y = 0; y < this.citiesList.size(); y++)
                System.out.println("[" + (y + 1) + "]" + iterator.next());
        }
        System.out.println("=========================");
    }

    private boolean addInOrder(LinkedList<String> linkedList, String newCity) {

        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                // Brisbane  -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    public void visit() {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        printMenu();
        int indexI = 0;
        int indexY = -1;

        while (!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {

                case 0:
                    System.out.println("Road Trip is over");
                    quit = true;
                    break;

                case 1:

                    if (this.citiesList.isEmpty()) {
                        System.out.println("\t\t-> Press 5 <-\n To add a destination in list");
                        break;
                    }
                    if (indexI < this.citiesList.size() & indexI >= 0) {
                        System.out.println("Now visiting " + this.citiesList.get(indexI));
                        indexI++;
                        indexY++;
                    } else {
                        System.out.println("Reached the end of the list: " + this.citiesList.get(indexI - 1));
                    }
                    break;

                case 2:

                    try {
                        if (indexY < this.citiesList.size() & indexY > -1) {
                            System.out.println("Now visiting " + this.citiesList.get(indexY - 1));
                            indexY--;
                            indexI--;
                        } else if (indexY == -1) {
                            System.out.println("\t\t-> Press 5 <-\n To add a destination in list");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("We are at the start of the list: " + this.citiesList.get(indexY));
                    }
                    break;

                case 3:
                    if (this.citiesList.isEmpty()) {
                        System.out.println("\t\t-> Press 5 <-\n To add a destination in list");
                    } else {
                        printList();
                    }
                    break;

                case 4:
                    printMenu();
                    break;

                case 5:
                    System.out.println("Add a city you want to visit");
                    String newCity = scanner.next();

                    if ( addInOrder(this.citiesList, newCity) ){
                    System.out.println(newCity + " added to the List");
                }
                break;
            }
        }
    }

    public void printMenu() {
        System.out.println("\tAvailable actions:\n\t-> Press 0-5 <- ");
        System.out.println("""
                0 - to quit
                1 - go to next city
                2 - go to previous city
                3 - print cities
                4 - print menu options
                5 - add new city""");
    }

}
