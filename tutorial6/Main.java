package tutorial6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Part 1: Get 3 tasks from the user
        System.out.println("===== ADD TASKS =====");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter Task " + i + ": ");
            String task = scanner.nextLine();
            tasks.add(task);
        }

        // Part 2 (2.1): Save all tasks into task.txt
        try {
            FileWriter writer = new FileWriter("task.txt");
            for (String task : tasks) {
                writer.write(task + "\n");
            }
            writer.close();
            System.out.println("\nTasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
            e.printStackTrace();
        }

        // Part 3 (2.2 & 2.3): Read task.txt and display loaded tasks
        System.out.println("\n===== TASKS LOADED FROM FILE =====");
        try {
            File file = new File("task.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        scanner.close();
    }
}