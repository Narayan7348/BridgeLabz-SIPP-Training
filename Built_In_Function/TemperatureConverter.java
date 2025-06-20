import java.util.*;

public class TemperatureConverter {

    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

   
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();

        System.out.print("Convert to (C for Celsius, F for Fahrenheit): ");
        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'C') {
            System.out.println("Result: " + fahrenheitToCelsius(temp) + " °C");
        } else if (choice == 'F') {
            System.out.println("Result: " + celsiusToFahrenheit(temp) + " °F");
        } else {
            System.out.println("Invalid choice.");
        }

       
    }
}
