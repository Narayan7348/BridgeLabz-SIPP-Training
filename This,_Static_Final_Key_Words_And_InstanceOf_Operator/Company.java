package oops_day_03_package;

public class Company {
	
	   // Static variable 
	   private static String companyName;
	   private static int totalEmployees = 0;
	   
	   // Instance variable
	   private String name;
	   
	   // Final variable
	   private final int id; 
	   private String designation;
	   
	   // Constructor
	   public Company(String name, int id, String designation) {
	       this.name = name;
	       this.id = id;
	       this.designation = designation;
	       totalEmployees++;
	   }
	   
	   // Static method to set the company name
	   public static void setCompanyName(String name) {
	       companyName = name;
	   }
	   
	   // Static method to display the total number of employees
	   public static void displayTotalEmployees() {
	       System.out.println("Total Employees: " + totalEmployees);
	   }
	   
	   // Method to display employee details
	   public void displayEmployeeDetails() {
	       if (this instanceof Company) {
	           System.out.println("Company Name: " + companyName);
	           System.out.println("Employee ID: " + id);
	           System.out.println("Name: " + name);
	           System.out.println("Designation: " + designation);
	       } else {
	           System.out.println("The object is not an instance of the Employee class");
	       }
	   }
	   
	   // Getters for instance variable
	   public String getName() {
	       return name;
	   }
	   public int getId() {
	       return id;
	   }
	   public String getDesignation() {
	       return designation;
	   }
	   
	   //Main Method
	   public static void main(String[] args) {
	       Company.setCompanyName("BridgeLabz");
	       
	       Company emp1 = new Company("Rohit Sharma", 1, "Manager");
	       Company emp2 = new Company("Ravi Singh", 2, "Software Developer");
	       
	       Company.displayTotalEmployees();
	      
	       emp1.displayEmployeeDetails();
	       emp2.displayEmployeeDetails();
	   }
	}
