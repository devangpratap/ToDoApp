// TodoApp.java
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList list = new ToDoList();

        label:
        while (true) {
            System.out.println("\n=== TODO APP ===");
            System.out.println("1) Add task");
            System.out.println("2) List tasks");
            System.out.println("3) Remove task");
            System.out.println("4) Mark done");
            System.out.println("5) Clear all");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    String task = sc.nextLine().trim();
                    if (!list.add(task)) System.out.println("Task cannot be empty.");
                    else System.out.println("Added.");

                    break;
                case "2":
                    list.print();

                    break;
                case "3": {
                    if (list.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        continue;
                    }
                    System.out.print("Enter task number to remove: ");
                    int idx = readInt(sc);
                    if (!list.remove(idx)) System.out.println("Invalid task number.");
                    else System.out.println("Removed.");

                    break;
                }
                case "4": {
                    if (list.isEmpty()) {
                        System.out.println("No tasks to mark done.");
                        continue;
                    }
                    System.out.print("Enter task number to mark done: ");
                    int idx = readInt(sc);
                    if (!list.markDone(idx)) System.out.println("Invalid task number.");
                    else System.out.println("Marked done.");

                    break;
                }
                case "5":
                    list.clear();
                    System.out.println("Cleared all tasks.");

                    break;
                case "0":
                    System.out.println("Bye.");
                    break label;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        sc.close();
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}