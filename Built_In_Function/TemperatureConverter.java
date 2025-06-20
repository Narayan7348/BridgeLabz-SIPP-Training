import java.util.Scanner;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return Math.round(((fahrenheit - 32) * 5.0 / 9.0) * 100.0) / 100.0; // Rounded to 2 decimals
    }

    public static double celsiusToFahrenheit(double celsius) {
        return Math.round(((celsius * 9.0 / 5.0) + 32) * 100.0) / 100.0; // Rounded to 2 decimals
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.print("Enter temperature value: ");
        double temperature = input.nextDouble();

        System.out.print("Convert to (C/F): ");
        String unit = input.next().toUpperCase();

        switch (unit) {
            case "C":
                System.out.println("Converted: " + fahrenheitToCelsius(temperature) + " °C");
                break;
            case "F":
                System.out.println("Converted: " + celsiusToFahrenheit(temperature) + " °F");
                break;
            default:
                System.out.println("Invalid option. Please enter C or F.");
        }

        input.close();
    }
}

