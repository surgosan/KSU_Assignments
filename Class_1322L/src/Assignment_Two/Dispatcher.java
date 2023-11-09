package Assignment_Two;

import java.util.ArrayList;

public class Dispatcher {
    ArrayList<Bus> busQueue = new ArrayList<>();

    public int addBus(Bus bus) {
        busQueue.add(bus);
        return busQueue.size();
    }

    public int addBus(Bus bus, int index) {
        int addedAt;
        try {
            busQueue.add(index, bus);
            addedAt = index;
        } catch (IndexOutOfBoundsException e) {
            busQueue.add(bus);
            addedAt = busQueue.size();
        }
        return addedAt;
    }

    public Bus findBus(int id) {
        for(int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i).getBusID() == id) {
                return busQueue.get(i);
            }
        }
        return null;
    }

    public Bus removeBus(int id) {
        Bus returned;
        for(int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i).getBusID() == id) {
                returned = busQueue.get(i);
                busQueue.remove(i);
                return returned;
            }
        }
        return null;
    }

    public int getSize() {
        return busQueue.size();
    }

    public Bus dispatchBus() {
        if(busQueue.size() == 0) {
            return null;
        }
        return busQueue.remove(0);
    }

    public String toString() {
        String output = "";
        for(Bus bus: busQueue) {
            output += String.format("%s%n", bus.toString());
        }
        return output;
    }
}
