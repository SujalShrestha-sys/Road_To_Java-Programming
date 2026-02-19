package Controller;

import Model.Topic;
import Model.TopicStore;

import java.util.List;

public class TopicController {
    private final TopicStore store;

    public TopicController(TopicStore store) {
        this.store = store;
    }

    public boolean addTopic(String name) {
        // Reject blank input from the view.
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        store.addTopic(name.trim());
        return true;
    }

    public List<Topic> getTopics() {
        // Expose the current topic list to the view.
        return store.getTopics();
    }
}
