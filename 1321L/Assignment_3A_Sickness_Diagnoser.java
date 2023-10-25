import java.util.Scanner;

public class Assignment_3A_Sickness_Diagnoser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("What is your suspected ilness? \n 1=HGPS     2=Lupus    3=Bokter Syndrome");
        int illness = in.nextInt();

        boolean YorN;
        switch (illness) {
            case 1:
                System.out.println("Do you have brittle bones? True or False");
                YorN = in.nextBoolean();
                if(YorN) {
                    System.out.println("It is likely HGPS");
                } else {
                    System.out.println("It is not likely HGPS");
                }
                break;
            case 2:
                System.out.println("It is not likey Lupus");
                break;
            case 3:
                System.out.println("Do you have a Vitamin C deficiency? True or False");
                YorN = in.nextBoolean();
                if(YorN) {
                    System.out.println("Are you a sailor? True or False");
                    YorN = in.nextBoolean();
                    if(YorN) {
                        System.out.println("It is likely Bokter Synrome");
                    } else {
                        System.out.println("It is likely not Bokter Synrome");
                    }
                } else {
                    System.out.println("It is not likely Bokter Synrome");
                }
                break;
        }
    }
}