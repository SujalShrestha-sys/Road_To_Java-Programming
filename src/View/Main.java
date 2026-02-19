package View;

import Controller.TopicController;
import Model.TopicStore;

public class Main {
    public static void main(String[] args) {
        // Wire the MVC components and start the console UI.
        TopicStore store = new TopicStore();
        TopicController controller = new TopicController(store);
        ConsoleView view = new ConsoleView(controller);
        view.run();
    }
}
