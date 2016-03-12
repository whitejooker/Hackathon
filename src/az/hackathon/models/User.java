package az.hackathon.models;

/**
 * Created by Qalib on 3/12/2016.
 */

public class User{
    private int id=-1;
    private String username;
    private String name;
    private String phone;
    private String email;
    private String password;
    private City city;
    private boolean isBlocked;
    private String address;
    private int numberOfComplains;


    public User(){

    }

    public User(int id, String username, String name, String phone, String email, String password, City city, boolean isBlocked, String address, int numberOfComplains) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.city = city;
        this.isBlocked = isBlocked;
        this.address = address;
        this.numberOfComplains = numberOfComplains;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfComplains() {
        return numberOfComplains;
    }

    public void setNumberOfComplains(int numberOfComplains) {
        this.numberOfComplains = numberOfComplains;
    }
}