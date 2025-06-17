import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] employeeData = new double[10][2];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1) + ":");
            double salary = sc.nextDouble();
            double years = sc.nextDouble();

            if (salary < 0 || years < 0) {
                System.out.println("Invalid input. Please enter positive numbers.");
                i--;
                continue;
            }

            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }

        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusAmount;

            if (years > 5) {
                bonusAmount = salary * 0.05;
            } else {
                bonusAmount = salary * 0.02;
            }

            double updatedSalary = salary + bonusAmount;

            bonus[i] = bonusAmount;
            newSalary[i] = updatedSalary;

            totalBonus += bonusAmount;
            totalOldSalary += salary;
            totalNewSalary += updatedSalary;
        }

        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        sc.close();
    }
}
