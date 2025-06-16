import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

      
        System.out.print("Enter marks in Physics: ");
        int physics = input.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chemistry = input.nextInt();
        System.out.print("Enter marks in Maths: ");
        int maths = input.nextInt();

       
        int total = physics + chemistry + maths;
        double average = total / 3.0;

        String grade = "";
        String remark = "";

      
        if (average >= 80) {
            grade = "A";
            remark = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remark = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remark = "Level 2, below, but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = "D";
            remark = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = "E";
            remark = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remark = "Remedial standards";
        }

       
        System.out.printf("Average Marks: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remark);

        input.close();
    }
}
