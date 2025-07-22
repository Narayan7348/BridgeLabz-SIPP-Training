import java.util.*;

abstract class JobRole {
    String candidateName;
    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }
    public String toString() {
        return candidateName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
}

class DataScientist extends JobRole {
    DataScientist(String candidateName) {
        super(candidateName);
    }
}

class ProductManager extends JobRole {
    ProductManager(String candidateName) {
        super(candidateName);
    }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();
    public void addResume(T resume) {
        resumes.add(resume);
    }
    public List<T> getResumes() {
        return resumes;
    }
}

public class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println(resume);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        Resume<DataScientist> dsResumes = new Resume<>();
        Resume<ProductManager> pmResumes = new Resume<>();

        System.out.print("Enter number of Software Engineer resumes: ");
        int seCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < seCount; i++) {
            System.out.print("Enter candidate name: ");
            seResumes.addResume(new SoftwareEngineer(scanner.nextLine()));
        }

        System.out.print("Enter number of Data Scientist resumes: ");
        int dsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < dsCount; i++) {
            System.out.print("Enter candidate name: ");
            dsResumes.addResume(new DataScientist(scanner.nextLine()));
        }

        System.out.print("Enter number of Product Manager resumes: ");
        int pmCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < pmCount; i++) {
            System.out.print("Enter candidate name: ");
            pmResumes.addResume(new ProductManager(scanner.nextLine()));
        }

        System.out.println("Software Engineer Resumes:");
        processResumes(seResumes.getResumes());

        System.out.println("Data Scientist Resumes:");
        processResumes(dsResumes.getResumes());

        System.out.println("Product Manager Resumes:");
        processResumes(pmResumes.getResumes());
    }
}
