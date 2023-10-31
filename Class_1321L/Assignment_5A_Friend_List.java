package Class_1321L;
import java.util.Scanner;
public class Assignment_5A_Friend_List {
    public static void main(String[] args) {
        String[] friends_list = new String[10];
        boolean quit = false;

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your top 10 friends list!");

        while(!quit) {
            System.out.println("What would you like to do? \n" +
                    "1) Add a Friend \n" +
                    "2) Replace a Friend \n" +
                    "3) Display Friend List \n" +
                    "4) Quit");

            int response = in.nextInt();
            in.nextLine();
            switch (response) {
                case 1:
                    int empty_index = 0;
                    boolean full = true;
                    for(int i = 0; i < friends_list.length; i++) {
                        if (friends_list[i] == null) {
                            full = false;
                            empty_index = i;
                            break;
                        }
                    }

                    if(full) {
                        System.out.println("Your friend list is full. \n\n\n");
                        break;
                    }

                    System.out.println("Enter your friend's name");
                    String name = in.nextLine();

                    boolean found = find_friend(friends_list, name);
                    if (found) {
                        System.out.println(name + "already exists in the friend list. \n\n\n");
                    } else {
                        friends_list[empty_index] = name;
                        System.out.println(name + "has been added to the friend list! \n\n\n");
                    }
                    break;
                case 2:
                    System.out.println("Enter your friend's name.");
                    name = in.nextLine();
                    found = find_friend(friends_list, name);
                    if(found) {
                        System.out.printf("%s already exists in the friend list. \n\n\n", name);
                        break;
                    } else {
                        boolean end = false;
                        while(!end) {
                            System.out.println("Enter the index where you would like to insert your friend. (1-10)");
                            int index = in.nextInt();

                            if(friends_list[index - 1] == null) {
                                friends_list[index - 1] = name;
                                System.out.printf("Index %d was empty, so %s was added to the list.", index, name);
                                end = true;
                            } else {
                                System.out.printf("%s is located at index %d. Do you want to replace them? True (T) | False (F).\n", friends_list[index-1], index);
                                String replaceString = in.next();
                                boolean replace;

                                if(replaceString.equalsIgnoreCase("T")) {
                                    replace = true;
                                } else {
                                    replace = false;
                                }

                                in.nextLine();

                                if(replace) {
                                    friends_list[index-1] = name;
                                    end = true;
                                    System.out.printf("%s has been added to the list. \n\n\n", name);
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Here is your friend list.");
                    for(int i = 0; i < friends_list.length; i++) {
                        if(friends_list[i] != null) {
                            System.out.printf("%d) %s\n", i+1, friends_list[i]);
                        }
                    }
                    System.out.println("\n\n\n");
                    break;
                case 4:
                    System.out.println("Thank your for using the Friend List program.");
                    quit = true;
                    break;
            }
        }
    }

    public static boolean find_friend(String[] friendlist, String name) {
        boolean found = false;
        for(int i = 0; i < friendlist.length; i++) {
            if(friendlist[i] == null) {
                continue;
            } else if (friendlist[i].equals(name)) {
                found = true;
                break;
            }
        }
        return found;
    }
}