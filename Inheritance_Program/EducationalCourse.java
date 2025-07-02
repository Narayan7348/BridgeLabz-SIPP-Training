package multilevel_inheritance_package;

//Course superclass
class Course {
 String courseName;  
 int duration;     

 // Constructor
 Course(String courseName, int duration) {
     this.courseName = courseName;
     this.duration = duration;
 }

 // Method to display course details
 public void displayCourse() {
     System.out.println("Course Name: " + courseName);
     System.out.println("Duration: " + duration + " weeks");
 }
}

//OnlineCourse subclass
class OnlineCourse extends Course {
 String platform;      
 boolean isRecorded;   
 
//Constructor
 OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
     super(courseName, duration);
     this.platform = platform;
     this.isRecorded = isRecorded;
 }

 // Method to display online course details
 public void displayOnlineCourse() {
     displayCourse();
     System.out.println("Platform: " + platform);
     System.out.println("Is Recorded: " + (isRecorded ? "Yes" : "No"));
 }
}

//PaidOnlineCourse subclass
class PaidOnlineCourse extends OnlineCourse {
 double fee;       
 double discount;  

 // Constructor
 PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
     super(courseName, duration, platform, isRecorded); 
     this.fee = fee;
     this.discount = discount;
 }

 // Method to display paid course details
 public void displayPaidCourse() {
     displayOnlineCourse(); 
     System.out.println("Course Fee: Rs" + fee);
     System.out.println("Discount: " + discount + "%");
 }
}

//Main Method
public class EducationalCourse {
 public static void main(String[] args) {
     PaidOnlineCourse poc = new PaidOnlineCourse("Java Programming", 6, "Coursera", true, 4999.0, 20.0);

     poc.displayPaidCourse();
 }
}
