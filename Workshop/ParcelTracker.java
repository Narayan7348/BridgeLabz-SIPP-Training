class ParcelStage {
    String status;
    ParcelStage next;

    ParcelStage(String status) {
        this.status = status;
        this.next = null;
    }
}

public class ParcelTracker {
    private ParcelStage head;

    // Add initial stage (if head is null)
    public void addInitialStage(String status) {
        if (head == null) {
            head = new ParcelStage(status);
        } else {
            System.out.println("Initial stage already added.");
        }
    }

    // Add stage at the end
    public void addStage(String status) {
        ParcelStage newStage = new ParcelStage(status);
        if (head == null) {
            head = newStage;
            return;
        }

        ParcelStage current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newStage;
    }

    // Insert checkpoint after a specific stage
    public void addCheckpointAfter(String afterStatus, String newStatus) {
        ParcelStage current = head;

        while (current != null && !current.status.equals(afterStatus)) {
            current = current.next;
        }

        if (current != null) {
            ParcelStage checkpoint = new ParcelStage(newStatus);
            checkpoint.next = current.next;
            current.next = checkpoint;
        } else {
            System.out.println("Stage '" + afterStatus + "' not found.");
        }
    }

    // Simulate parcel lost at a certain stage
    public void loseParcelAfter(String status) {
        ParcelStage current = head;
        while (current != null && !current.status.equals(status)) {
            current = current.next;
        }

        if (current != null) {
            current.next = null; // Break the link - parcel is "lost"
            System.out.println("Parcel lost after stage: " + status);
        } else {
            System.out.println("Stage '" + status + "' not found.");
        }
    }

    // Print all stages (tracking)
    public void printTrackingPath() {
        ParcelStage current = head;
        while (current != null) {
            System.out.print(current.status);
            current = current.next;
            if (current != null) System.out.print(" -> ");
        }

        if (head == null) {
            System.out.println("No tracking information.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        // Setup initial stages
        tracker.addInitialStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        System.out.println("Original Tracking Path:");
        tracker.printTrackingPath();

        // Add a custom checkpoint
        tracker.addCheckpointAfter("Shipped", "At Local Hub");
        System.out.println("After Adding Checkpoint:");
        tracker.printTrackingPath();

        // Simulate parcel loss
        tracker.loseParcelAfter("At Local Hub");
        System.out.println("After Parcel Lost:");
        tracker.printTrackingPath();
    }
}
