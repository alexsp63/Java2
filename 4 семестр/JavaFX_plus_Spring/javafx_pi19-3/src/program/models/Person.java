package program.models;

import com.google.gson.Gson;
import javafx.beans.property.*;
import program.utils.DateUtil;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements JSONSerialize{
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty city;
    private SimpleObjectProperty<Integer> postalCode;
    private ObjectProperty<LocalDate> birthDay;

    private final IntegerProperty id;

    public Person(){
        this(null, null, null, null, null, null);
    }

    public Person(String firstName, String lastName, String street, String city, Integer postalCode, LocalDate birthday){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleObjectProperty<Integer>(postalCode);
        this.birthDay = new SimpleObjectProperty<LocalDate>(birthday);
        this.id = null;
    }

    public Person(String firstName, String lastName, String street, String city, Integer postalCode, LocalDate birthday, Integer id){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleObjectProperty<Integer>(postalCode);
        this.birthDay = new SimpleObjectProperty<LocalDate>(birthday);
        this.id = new SimpleIntegerProperty(id);
    }

    /*public Person(String firstName, String lastName, String street, String city, Integer postalCode, LocalDate birthDay){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        //уже реальные значения, вводимые пользователем
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleIntegerProperty(postalCode);
        this.birthDay = new SimpleObjectProperty<LocalDate>(birthDay);
    }*/

    public int getId() {
        return id.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay.set(birthDay);
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getStreet() {
        return street.get();
    }

    public String getCity() {
        return city.get();
    }

    public Integer getPostalCode() {
        return postalCode.get();
    }

    public LocalDate getBirthDay() {
        return birthDay.get();
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public StringProperty getStreetProperty() {
        return street;
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public ObjectProperty<LocalDate> getBirthDayProperty() {
        return birthDay;
    }

    public void setFirstname(String firstName) {
        this.firstName.set(firstName);
    }

    @Override
    public String toJson() {
        Map<String, String> map = new HashMap<>();
        map.put("firstName", firstName.getValue());
        map.put("lastName", lastName.getValue());
        map.put("city", city.getValue());
        map.put("street", street.getValue());
        map.put("postalCode", String.valueOf(postalCode.getValue()));
        map.put("birthDay", DateUtil.format(birthDay.getValue()));
        //System.out.println(DateUtil.format(birthDay.getValue()));
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
