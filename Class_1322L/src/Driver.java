import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Dispatcher dispatch = new Dispatcher();
        Scanner in = new Scanner(System.in);

        boolean quit = false;
        while(!quit) {
            System.out.println("Menu\n\n Enter the number of the option you want. \n" +
                    "1) Add Bus \n" +
                    "2) Add Person to Bus \n " +
                    "3) Remove Bus \n" +
                    "4) Remove Person \n" +
                    "5) List Passengers \n" +
                    "6) List Buses \n" +
                    "7) Requeue Bus \n" +
                    "8) Transfer Person \n" +
                    "9) Dispatch Next Bus \n" +
                    "10) Quit");
            int menuOption = in.nextInt();
            in.nextLine();

            switch (menuOption) {
                case 1:
                    Bus bus = new Bus();
                    dispatch.addBus(bus);
                    System.out.printf("%d added to position %d", bus.getBusID(), dispatch.getSize());
                    break;
                case 2:
                    System.out.println("Provide Bus ID");
                    int busID = in.nextInt();
                    in.nextLine();

                    boolean added = false;
                    for(Bus caseTwoBus: dispatch.busQueue) {
                        if(caseTwoBus.getBusID() == busID) {
                            System.out.println("Provide the person's name.");
                            String caseTwoPersonName = in.nextLine();
                            caseTwoBus.addPerson(new Person(caseTwoPersonName));
                            System.out.printf("%s has been added to bus %d", caseTwoPersonName, busID);
                            added = true;
                            break;
                        }
                    }

                    if(!added) {
                        System.out.println("No bus with ID " + busID);
                    }
                    break;
                case 3:
                    System.out.println("Provide Bus ID");
                    int caseThreeBusID = in.nextInt();
                    in.nextLine();

                    if(dispatch.findBus(caseThreeBusID) != null) {
                        dispatch.removeBus(caseThreeBusID);
                        System.out.printf("Bus %d removed.", caseThreeBusID);
                    } else {
                        System.out.println("No bus with id " + caseThreeBusID);
                    }
                    break;
                case 4:
                    System.out.println("Provide Bus ID");
                    int caseFourBusID = in.nextInt();
                    in.nextLine();

                    if(dispatch.findBus(caseFourBusID) != null) {
                        System.out.println("Provide the person's name.");
                        String caseFourPersonName = in.nextLine();
                        Person caseFourPerson = new Person(caseFourPersonName);

                        if(dispatch.findBus(caseFourBusID).findPerson(caseFourPerson).getName().equals(caseFourPersonName)) {
                            dispatch.findBus(caseFourBusID).removePerson(caseFourPerson);
                            System.out.printf("%s has been removed from bus %d", caseFourPersonName, caseFourBusID);
                        } else {
                            System.out.printf("No such person found in bus %d", caseFourBusID);
                        }
                    } else {
                        System.out.println("No bus with id " + caseFourBusID);
                    }
                    break;
                case 5:
                    System.out.println("Provide bus ID");
                    int caseFiveBusID = in.nextInt();
                    in.nextLine();

                    if(dispatch.findBus(caseFiveBusID) != null) {
                        System.out.printf("Bus %d%n%s", caseFiveBusID, dispatch.findBus(caseFiveBusID).getPassengers());
                    } else {
                        System.out.printf("No buses with id %d.", caseFiveBusID);
                    }
                    break;
                case 6:
                    System.out.printf("Bus Queue%n%s", dispatch);
                    break;
                case 10:
                    System.out.println("Thank you for using the Dispatch program.");
                    quit = true;

            }

        }
    }
}
