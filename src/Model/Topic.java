package Model;

import java.sql.Timestamp;

public class Topic {

    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default constructor
    public Topic(){}

    // Parameterized constructor
    public Topic(int id, String name, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Topic(String name, Timestamp createdAt, Timestamp updatedAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt){
        this.updatedAt = updatedAt;
    }
}