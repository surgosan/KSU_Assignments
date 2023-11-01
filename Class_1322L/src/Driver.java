import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Dispatcher dispatch = new Dispatcher();
        Scanner in = new Scanner(System.in);

        boolean quit = false;
        while(!quit) {
            System.out.println("""
                    Menu:
                      Enter the number of the option you want.\s
                    1) Add Bus\s
                    2) Add Person to Bus\s
                    3) Remove Bus\s
                    4) Remove Person\s
                    5) List Passengers\s
                    6) List Buses\s
                    7) Requeue Bus\s
                    8) Transfer Person\s
                    9) Dispatch Next Bus\s
                    10) Quit""");
            int menuOption = in.nextInt();
            in.nextLine();

            switch (menuOption) {
                case 1:
                    Bus bus = new Bus();
                    dispatch.addBus(bus);
                    System.out.printf("%d added to position %d.%n", bus.getBusID(), dispatch.getSize());
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
                            System.out.printf("%s has been added to bus %d.%n", caseTwoPersonName, busID);
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
                        System.out.printf("Bus %d removed.%n", caseThreeBusID);
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
                            System.out.printf("%s has been removed from bus %d.%n", caseFourPersonName, caseFourBusID);
                        } else {
                            System.out.printf("No such person found in bus %d.%n", caseFourBusID);
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
                        System.out.printf("Bus %d%n%s%n", caseFiveBusID, dispatch.findBus(caseFiveBusID).getPassengers());
                    } else {
                        System.out.printf("No buses with id %d.%n", caseFiveBusID);
                    }
                    break;
                case 6:
                    System.out.printf("Bus Queue%n%s%n", dispatch);
                    break;
                case 7:
                    System.out.println("Provide Bus ID.");
                    int caseSevenBusID = in.nextInt();
                    in.nextLine();

                    if(dispatch.findBus(caseSevenBusID) != null) {
                        System.out.println("Provide the buses new position. You may insert between 0 and " + (dispatch.getSize()-1) + ".");
                        int caseSevenBusPosition = in.nextInt();
                        in.nextLine();

                        dispatch.addBus(dispatch.removeBus(caseSevenBusID), caseSevenBusPosition);
                        System.out.printf("Bus %d added to position %d.%n", caseSevenBusID, caseSevenBusPosition);
                    } else {
                        System.out.println("No such bus found.");
                    }
                    break;
                case 8:
                    System.out.println("Provide person's name.");
                    String caseEightPersonName = in.nextLine();
                    Person caseEightPerson = new Person(caseEightPersonName);
                    System.out.println("Provide person's current bus.");
                    int caseEightBusOne = in.nextInt();
                    in.nextLine();
                    System.out.println("Provide person's new bus");
                    int caseEightBusTwo = in.nextInt();
                    in.nextLine();

                    if(dispatch.findBus(caseEightBusOne) == null) {
                        System.out.println("Current bus was not found.");
                    } else if(dispatch.findBus(caseEightBusTwo) == null) {
                        System.out.println("Destination bus not found.");
                    } else if(dispatch.findBus(caseEightBusOne).findPerson(caseEightPerson) == null) {
                        System.out.println("Person was not found withing current bus.");
                    } else {
                        try {
                            dispatch.findBus(caseEightBusOne).transferPerson(dispatch.findBus(caseEightBusOne), dispatch.findBus(caseEightBusTwo), caseEightPerson);
                            System.out.println("Successfully transferred person.");
                        } catch (Exception e) {
                            System.out.println("Failed to transfer person.");
                        }
                    }
                    break;
                case 9:
                    if(dispatch.dispatchBus() == null) {
                        System.out.println("Bus queue is empty.");
                    } else {
                        System.out.printf("Bus %d has been dispatched.%n", dispatch.dispatchBus().getBusID());
                    }
                    break;
                case 10:
                    System.out.println("Thank you for using the Dispatch program.");
                    quit = true;
            }

        }
    }
}
