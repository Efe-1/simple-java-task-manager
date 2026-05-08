import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;

    Task(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== TASK MANAGER ===");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Delete Task");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizle

            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                listTasks();
            } else if (choice == 3) {
                deleteTask();
            } else if (choice == 0) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Task name: ");
        String name = scanner.nextLine();

        tasks.add(new Task(name));
        System.out.println("Task added.");
    }

    static void listTasks() {
        System.out.println("\n--- TASK LIST ---");

        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " - " + tasks.get(i));
        }
    }

    static void deleteTask() {
        listTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt();

        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid index!");
            return;
        }

        tasks.remove(index - 1);
        System.out.println("Task deleted.");
    }
}