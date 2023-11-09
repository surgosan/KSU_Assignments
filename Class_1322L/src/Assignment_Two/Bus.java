package Assignment_Two;

import java.util.ArrayList;

public class Bus {
    ArrayList<Person> passengers;
    private static int nextId;
    private int busID;

    public Bus() {
        passengers = new ArrayList<>();
        busID = nextId;
        nextId++;
    }

    public int getBusID() {
        return busID;
    }

    public void addPerson(Person person) {
        passengers.add(person);
    }

    public boolean removePerson(Person person) {
        boolean removed = false;
        for(int i = 0; i < passengers.size(); i++) {
            if(person.getTicketNumber() == passengers.get(i).getTicketNumber()) {
                passengers.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    public Person findPerson(Person givenPerson) {
        Person returnPerson = null;
        for(Person person: passengers) {
            if(givenPerson.getName().equals(person.getName())) {
                returnPerson = person;
                break;
            }
        }
        return returnPerson;
    }

    public boolean transferPerson(Bus from, Bus to, Person person) {
        Person transferPerson = new Person();
        for(Person findPerson: passengers) {
            if(person.getName().equals(findPerson.getName())) {
                transferPerson = person;
                break;
            }
            return false;
        }
        to.addPerson(transferPerson);
        return true;
    }

    public String getPassengers() {
        String output = "";
        for(Person passenger: passengers) {
            output += String.format("%s%n", passenger.toString());
        }
        return output;
    }

    public String toString() {
        return String.valueOf(busID);
    }
}
