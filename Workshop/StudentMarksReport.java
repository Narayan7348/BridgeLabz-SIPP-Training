import java.util.*;

public class StudentMarksReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Integer>> studentMarks = new HashMap<>();

        while (true) {
            System.out.println("1. Add Marks");
            System.out.println("2. Calculate Average");
            System.out.println("3. Top Performer");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.print("Enter mark: ");
                int mark = sc.nextInt();
                sc.nextLine();
                studentMarks.putIfAbsent(name, new ArrayList<>());
                studentMarks.get(name).add(mark);
            } else if (choice == 2) {
                for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
                    List<Integer> marks = entry.getValue();
                    double avg = 0;
                    if (!marks.isEmpty()) {
                        int sum = 0;
                        for (int mark : marks) {
                            sum += mark;
                        }
                        avg = (double) sum / marks.size();
                    }
                    System.out.println(entry.getKey() + " Average: " + avg);
                }
            } else if (choice == 3) {
                String topStudent = null;
                double topAvg = -1;
                for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
                    List<Integer> marks = entry.getValue();
                    if (!marks.isEmpty()) {
                        int sum = 0;
                        for (int mark : marks) {
                            sum += mark;
                        }
                        double avg = (double) sum / marks.size();
                        if (avg > topAvg) {
                            topAvg = avg;
                            topStudent = entry.getKey();
                        }
                    }
                }
                if (topStudent != null) {
                    System.out.println("Top Performer: " + topStudent + " Average: " + topAvg);
                } else {
                    System.out.println("No data available");
                }
            } else if (choice == 4) {
                break;
            }
        }
    }
}

