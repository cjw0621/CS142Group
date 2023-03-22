import java.util.Scanner;

public class CheckInOut {
    public static Scanner sc = new Scanner(System.in);
    private static String guestName;
    private static boolean hasPets = false;

    public static void guestCheckin() {
        System.out.println("Enter Guest Name:");
        System.out.print(">");
        guestName = sc.nextLine();

        System.out.println("Does Guests Have pets?");
        System.out.print(">");
        String haspet = sc.nextLine();
        if (haspet.equalsIgnoreCase("y")) {
            hasPets = true;
        }
    }

}
