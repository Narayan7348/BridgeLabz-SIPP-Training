import java.util.*;

public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartPoint(PetrolPump[] pumps) {
        int start = 0;
        int deficit = 0;
        int balance = 0;
        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        if (balance + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of petrol pumps:");
        int n = sc.nextInt();
        PetrolPump[] pumps = new PetrolPump[n];
        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }
        int startPoint = findStartPoint(pumps);
        System.out.println("Starting point index: " + startPoint);
    }
}
