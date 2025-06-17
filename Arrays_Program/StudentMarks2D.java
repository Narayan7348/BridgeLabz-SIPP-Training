import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();
        int[][] marks = new int[students][3]; // [students][physics, chemistry, maths]
        double[] percentages = new double[students];
        String[] grades = new String[students];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                int input;
                while (true) {
                    input = sc.nextInt();
                    if (input >= 0) break;
                    System.out.println("Enter a positive mark:");
                }
                marks[i][j] = input;
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;

            if (percentages[i] >= 90) {
                grades[i] = "A+";
            } else if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < students; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        sc.close();
    }
}
