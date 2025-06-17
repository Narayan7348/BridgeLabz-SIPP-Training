import java.util.Scanner;

public class BMIStatus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextDouble();
            while (weight[i] <= 0) {
                weight[i] = sc.nextDouble();
            }
            height[i] = sc.nextDouble();
            while (height[i] <= 0) {
                height[i] = sc.nextDouble();
            }
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(height[i] + " " + weight[i] + " " + String.format("%.2f", bmi[i]) + " " + status[i]);
        }
    }
}

