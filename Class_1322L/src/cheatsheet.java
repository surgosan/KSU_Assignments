import java.util.ArrayList;
import java.util.Random;

public class cheatsheet {
    public static void main(String[] args) {
        Random ran = new Random();
        System.out.println(ran.nextInt(10));

        ArrayList<Integer> queue = new ArrayList<>();

    }

    public static ArrayList<Integer> add(ArrayList<Integer> list, int num) {
        list.add(num);
        return list;
    }

    public static ArrayList<Integer> remove(ArrayList<Integer> list) {
        list.remove(0);
        return list;
    }
}
