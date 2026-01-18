// ToDoList.java
import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<String> todos = new ArrayList<>();

    public boolean add(String task) {
        if (task == null) return false;
        task = task.trim();
        if (task.isEmpty()) return false;
        todos.add(task);
        return true;
    }

    public boolean isEmpty() {
        return todos.isEmpty();
    }

    public void print() {
        if (todos.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("\nTasks:");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ") " + todos.get(i));
        }
    }

    public boolean remove(int oneBasedIndex) {
        int idx = oneBasedIndex - 1;
        if (idx < 0 || idx >= todos.size()) return false;
        todos.remove(idx);
        return true;
    }

    public boolean markDone(int oneBasedIndex) {
        int idx = oneBasedIndex - 1;
        if (idx < 0 || idx >= todos.size()) return false;

        String t = todos.get(idx);
        if (t.startsWith("[x] ")) return true;

        if (t.startsWith("[ ] ")) {
            todos.set(idx, "[x] " + t.substring(4));
        } else {
            todos.set(idx, "[x] " + t);
        }
        return true;
    }

    public void clear() {
        todos.clear();
    }
}