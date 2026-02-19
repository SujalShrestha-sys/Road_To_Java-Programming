package View;

import Controller.TopicController;
import Model.Topic;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final TopicController controller;

    public ConsoleView(TopicController controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Learning Logs");

        boolean running = true;

        while (running) {
            // Main menu loop for terminal interaction.
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> handleAddTopic(scanner);
                case "2" -> handleViewTopics();
                case "3" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1) Add topic");
        System.out.println("2) View topics");
        System.out.println("3) Exit");
        System.out.print("Choose an option: ");
    }

    private void handleAddTopic(Scanner scanner) {
        System.out.print("Enter topic name: ");
        String name = scanner.nextLine();
        // Delegate validation/creation to the controller.
        boolean added = controller.addTopic(name);
        if (added) {
            System.out.println("Topic is added successfully.");
        } else {
            System.out.println("Topic is not added.");
        }
    }

    private void handleViewTopics() {
        List<Topic> topics = controller.getTopics();
        if (topics.isEmpty()) {
            System.out.println("No topics available.");
            return;
        }
        // Present the current in-memory topics.
        System.out.println("Topics:");
        for (Topic topic : topics) {
            System.out.println(formatTopic(topic));
        }
    }

    private String formatTopic(Topic topic) {
        return String.format("%d) %s (created: %s, updated: %s)",
                topic.getId(),
                topic.getName(),
                topic.getCreatedAt(),
                topic.getUpdatedAt());
    }
}
