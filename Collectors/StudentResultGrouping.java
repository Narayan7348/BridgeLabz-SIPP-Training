import java.util.*;
import java.util.stream.*;

public class StudentResultGrouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for(int i=0;i<n;i++){
            String name = sc.next();
            String grade = sc.next();
            students.add(new Student(name, grade));
        }
        Map<String, List<String>> result = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(result);
    }
}

class Student {
    private String name;
    private String grade;
    public Student(String name, String grade){this.name=name;this.grade=grade;}
    public String getName(){return name;}
    public String getGrade(){return grade;}
}
