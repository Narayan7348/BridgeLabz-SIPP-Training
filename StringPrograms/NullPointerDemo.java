public class NullPointerDemo {
    
    
    public static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length());
    }
    
    
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Attempting to generate exception...");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Exception in generate method: " + e.getMessage());
        }
        
        System.out.println("\nDemonstrating exception handling...");
        handleException();
    }
}