import java.util.*;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    public void display() {
        System.out.println("ID: " + taskId + ", Name: " + taskName +
                           ", Priority: " + priority + ", Due Date: " + dueDate);
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add task at the end
    public void addTaskAtEnd(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add task at the beginning
    public void addTaskAtBeginning(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add task at a specific position
    public void addTaskAtPosition(Task newTask, int position) {
        if (position <= 1 || head == null) {
            addTaskAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by Task ID
    public void removeTaskById(int id) {
        if (head == null) return;

        Task temp = head, prev = null;

        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + id + " not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task:");
            current.display();
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        } else {
            current = head;
        }
        viewCurrentTask();
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        do {
            temp.display();
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                temp.display();
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with priority " + priority + " found.");
        }
    }
}

// Main class to test the Task Scheduler
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int id, priority, position;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addTaskAtBeginning(new Task(id, name, priority, dueDate));
                    break;

                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addTaskAtEnd(new Task(id, name, priority, dueDate));
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addTaskAtPosition(new Task(id, name, priority, dueDate), position);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    scheduler.removeTaskById(id);
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.moveToNextTask();
                    break;

                case 7:
                    scheduler.displayAllTasks();
                    break;

                case 8:
                    System.out.print("Enter priority to search: ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

    }
}

