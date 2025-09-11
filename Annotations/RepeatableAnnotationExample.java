import java.lang.annotation.*;
import java.lang.reflect.*;

// Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "Performance issue on large data")
    public void process() {
        System.out.println("Processing software...");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }

        new Software().process();
    }
}
