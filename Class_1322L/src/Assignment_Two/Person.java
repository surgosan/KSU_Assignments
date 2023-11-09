package Assignment_Two;

public class Person {
    private String name;
    private int ticketNumber;
    private static int nextTicketNumber;

    public Person() {
        this.name = "";
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public Person(String name) {
        this.name = name;
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public String getName() {
        return name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String toString() {
        return String.format("%d \t %s", ticketNumber, name);
    }
}
