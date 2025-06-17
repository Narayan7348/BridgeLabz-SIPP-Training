import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        int[] physics = new int[students];
        int[] chemistry = new int[students];
        int[] maths = new int[students];
        double[] percentage = new double[students];
        String[] grades = new String[students];

        for (int i = 0; i < students; i++) {
            int p, c, m;

            while (true) {
                p = sc.nextInt();
                if (p >= 0) break;
                System.out.println("Enter a positive value for Physics marks.");
            }

            while (true) {
                c = sc.nextInt();
                if (c >= 0) break;
                System.out.println("Enter a positive value for Chemistry marks.");
            }

            while (true) {
                m = sc.nextInt();
                if (m >= 0) break;
                System.out.println("Enter a positive value for Maths marks.");
            }

            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;

            percentage[i] = (p + c + m) / 3.0;

            if (percentage[i] >= 90) {
                grades[i] = "A+";
            } else if (percentage[i] >= 80) {
                grades[i] = "A";
            } else if (percentage[i] >= 70) {
                grades[i] = "B";
            } else if (percentage[i] >= 60) {
                grades[i] = "C";
            } else if (percentage[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < students; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%s\n",
                    physics[i], chemistry[i], maths[i], percentage[i], grades[i]);
        }

        sc.close();
    }
}
