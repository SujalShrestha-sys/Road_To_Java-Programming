package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicStore {
    // In-memory storage only; no files or database.
    private final ArrayList<Topic> topics = new ArrayList<>();
    private int nextId = 1;

    public void addTopic(String name) {
        // Assign ID and timestamps at creation time.
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Topic topic = new Topic(nextId++, name, now, now);
        topics.add(topic);
    }

    public List<Topic> getTopics() {
        // Prevent external mutation of the list.
        return Collections.unmodifiableList(topics);
    }
}
