package az.hackathon.models;

import java.util.Date;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Food {
    private int id;
    private int state;
    private String description;
    private String name;
    private double price;
    private int amount;
    private Date date;
    private String pictureExtension;
    private boolean isActive;
    private Type type;
    private User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food() {
    }

    public Food(int id, int state, String description, String name, double price, int amount, Date date, String pictureExtension, boolean isActive, Type type, User user) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.date = date;
        this.pictureExtension = pictureExtension;
        this.isActive = isActive;
        this.type = type;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPictureExtension() {
        return pictureExtension;
    }

    public void setPictureExtension(String pictureExtension) {
        this.pictureExtension = pictureExtension;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", date=" + date +
                ", pictureExtension='" + pictureExtension + '\'' +
                ", isActive=" + isActive +
                ", type=" + type +
                ", user=" + user +
                '}';
    }
}
