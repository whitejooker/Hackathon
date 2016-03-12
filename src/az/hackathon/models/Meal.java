package az.hackathon.models;

import java.util.Date;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Meal {
    private int id;
    private int state;
    private String description;
    private String name;
    private int amount;
    private Date date;
    private String pictureExtension;
    private boolean isActive;
    private Type type;

    public Meal() {
    }

    public Meal(int id, int state, String description, String name, int amount, Date date, String pictureExtension, boolean isActive, Type type) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.pictureExtension = pictureExtension;
        this.isActive = isActive;
        this.type = type;
    }
}
