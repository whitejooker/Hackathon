package az.hackathon.models;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Type {
    private int id;
    private String name;
    private int maxState;

    public Type() {
    }

    public Type(int id, String name, int maxState) {
        this.id = id;
        this.name = name;
        this.maxState = maxState;
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

    public int getMaxState() {
        return maxState;
    }

    public void setMaxState(int maxState) {
        this.maxState = maxState;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxState=" + maxState +
                '}';
    }

}
