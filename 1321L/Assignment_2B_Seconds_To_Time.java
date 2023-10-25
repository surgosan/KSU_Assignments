import java.util.Scanner;


//a) Ask the user to enter a number (in seconds)
//b) Read that value in
//c) Use the Modulo Operator to find how many hours, minutes, and seconds that
//represents
//d) Display the results in hours, minutes, and seconds
public class Seconds_To_Time {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an amount of seconds less than 10k. No Decimals");
        int seconds = in.nextInt();

        int secs = seconds % 60;
        System.out.println("Seconds: " + secs);
        int temp1 = seconds - secs;

        int minutes = (temp1 / 60) % 60;
        System.out.println("Minutes: " + minutes);

        int temp2 = (seconds - secs - (minutes * 60)) / 3600;
        System.out.println("Hours: " + temp2);
    }
}
