import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int T = input.nextInt();
        Rental[] rentals = new Rental[T];
        int[] unit = new int[T];
        for (int i = 0; i < T; i++) {
            String type = input.next();
            String id = input.next();
            int days = input.nextInt();
            int units = input.nextInt();
            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
                unit[i] = units;
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days);
                unit[i] = units;
            }
        }
        for (int i = 0; i < rentals.length; i++) {
            System.out.println(rentals[i].summary(unit[i]));
        }

        input.close();
    }
}
