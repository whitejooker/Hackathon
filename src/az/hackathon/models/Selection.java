package az.hackathon.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Qalib on 3/12/2016.
 */
public class Selection {
    private City city;
    private Type type;
    private Double price;
    private int amount;
    private int state;
    private int currentPage;

    public Selection() {
    }

    public Selection(City city, Type type, Double price, int amount, int state, int currentPage) {
        this.city = city;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.state = state;
        this.currentPage = currentPage;
    }


    public String getSQL(){
        return "select * from meal m join user u on u.id=m.user_id join city c on c.id=u.city_id WHERE type_id=? and price<=? and m.amount >= ? and m.state <=? and c.city_id=?";
    }

    public void setValuesToStatement(PreparedStatement statement) throws SQLException{

        statement.setInt(1, type.getId());
        statement.setDouble(2, price);
        statement.setInt(3, amount);
        statement.setInt(4, state);
        statement.setInt(5, city.getId());
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "Selection{" +
                "city=" + city +
                ", type=" + type +
                ", price=" + price +
                ", amount=" + amount +
                ", state=" + state +
                ", currentPage=" + currentPage +
                '}';
    }
}
