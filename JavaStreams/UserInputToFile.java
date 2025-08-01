import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            FileWriter writer = new FileWriter("user_data.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.close();
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data.");
        }
    }
}
