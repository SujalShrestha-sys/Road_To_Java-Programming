package dao.interfaces;

import Model.Topic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TopicInterface {
    ArrayList<Topic> viewTopics() throws SQLException, ClassNotFoundException;
    boolean addTopic(Topic topic) throws SQLException, ClassNotFoundException;

}
