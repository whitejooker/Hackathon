package az.hackathon.models;

import java.util.Date;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Complain {
    private int id;
    private String name;
    private String userId;
    private String description;
    private Date date;
    private boolean result;


    public Complain(int id, String name, String userId, String description, Date date, boolean result) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.description = description;
        this.date = date;
        this.result = result;
    }

    public Complain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", result=" + result +
                '}';
    }
}

