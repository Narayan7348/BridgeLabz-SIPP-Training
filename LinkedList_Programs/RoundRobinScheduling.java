package linked_list_package;

//Node class
class Process {
 int pid, burstTime, priority;
 Process next;

 //Constructor
 Process(int pid, int burstTime, int priority) {
     this.pid = pid;
     this.burstTime = burstTime;
     this.priority = priority;
 }
}

//Circular Linked List
class Scheduler {
 Process head = null;

 // Add process at end
 public void addProcess(int pid, int burst, int priority) {
     Process newProcess = new Process(pid, burst, priority);
     if (head == null) {
         head = newProcess;
         head.next = head;
     } else {
         Process temp = head;
         while (temp.next != head)
             temp = temp.next;
         temp.next = newProcess;
         newProcess.next = head;
     }
 }

 // Remove process by ID
 public void removeById(int pid) {
     if (head == null) return;

     if (head.pid == pid && head.next == head) {
         head = null;
         return;
     }

     Process temp = head, prev = null;
     do {
         if (temp.pid == pid) {
             if (temp == head) {
                 Process last = head;
                 while (last.next != head)
                     last = last.next;
                 head = head.next;
                 last.next = head;
             } else {
                 prev.next = temp.next;
             }
             return;
         }
         prev = temp;
         temp = temp.next;
     } while (temp != head);
 }

 // Method
 public void simulate(int timeQuantum) {
     if (head == null) {
         System.out.println("No processes to schedule");
         return;
     }
     Process temp = head;
     while (head != null) {
         System.out.println("\nProcesses in Queue:");
         display();

         int runTime = Math.min(temp.burstTime, timeQuantum);
         System.out.println("Process " + temp.pid + " runs for " + runTime + " units.");
         temp.burstTime -= runTime;

         if (temp.burstTime <= 0) {
             System.out.println("Process " + temp.pid + " completed.");
             int removeId = temp.pid;
             temp = temp.next;
             removeById(removeId);
             if (temp == null) break;
         } else {
             temp = temp.next;
         }
     }
 }

 // Method Display
 public void display() {
     if (head == null) {
         System.out.println("Queue is empty");
         return;
     }

     Process temp = head;
     do {
         System.out.println("PID: " + temp.pid + " Burst: " + temp.burstTime + " Priority: " + temp.priority);
         temp = temp.next;
     } while (temp != head);
 }
}

//Main Method
public class RoundRobinScheduling {
 public static void main(String[] args) {
     Scheduler scheduler = new Scheduler();

     scheduler.addProcess(1, 5, 1);
     scheduler.addProcess(2, 8, 2);
     scheduler.addProcess(3, 6, 1);

     scheduler.simulate(3); 
 }
}
