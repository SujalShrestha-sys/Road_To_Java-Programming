package dao.implementation;

import Model.Topic;
import dao.interfaces.TopicInterface;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class TopicImpl implements TopicInterface {

    @Override
    public ArrayList<Topic> viewTopics() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM topics";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        ArrayList<Topic> topics = new ArrayList<>();

        while (resultSet.next()) {

            Topic topic = new Topic(); // create new object each loop

            topic.setId(resultSet.getInt("id"));
            topic.setName(resultSet.getString("name"));
            topic.setCreatedAt(resultSet.getTimestamp("created_at"));
            topic.setUpdatedAt(resultSet.getTimestamp("updated_at"));

            topics.add(topic); // add inside loop
        }

        return topics;
    }

    @Override
    public boolean addTopic(Topic topic) throws SQLException, ClassNotFoundException {
        //Parameterized Query
        String sql = "INSERT INTO topics (name, created_at, updated_at) VALUES (?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, topic.getName());
        ps.setTimestamp(2, topic.getCreatedAt());
        ps.setTimestamp(3, topic.getUpdatedAt());
        int rowsAffected = ps.executeUpdate();

        return rowsAffected>0;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TopicImpl topicImpl = new TopicImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Topic topic = new Topic("Topic", timestamp, timestamp);
        boolean success = topicImpl.addTopic(topic);

        if (success) {
            System.out.println("Added Successfully!");
        }else{
            System.out.println("Not Added");
        }
    }

}