package program.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import program.Main;
import program.models.Person;
import program.utils.DateUtil;
import program.utils.RestAPI;

import java.time.LocalDate;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label birthdayLabel;

    private Main main;
    private RestAPI restApi;

    public PersonOverviewController(){}

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

        showPersonOverviewDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, olValue, newValue) -> showPersonOverviewDetails(newValue)
        );
    }

    @FXML
    private void handleDeletePerson(){
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Person currentPerson = personTable.getItems().get(selectedIndex);
            if (restApi.deletePerson(currentPerson)){
                personTable.getItems().remove(selectedIndex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table");

            alert.showAndWait();
        }
    }

    @FXML
    private void editPerson() {
        Person selectedItem = personTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            boolean okIsClicked = main.showPersonDialogue(selectedItem);
            if (okIsClicked) {
                restApi.putPerson(selectedItem);
                main.UpdateTable();
                showPersonOverviewDetails(selectedItem);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void addNewPerson() {
         //тут нам не важно, выбрана какая-то запись или нет: новый person есть новый person
        Person newPerson = new Person();
        boolean okIsClicked = main.showPersonDialogue(newPerson);  //там я прописала в контроллере, что если пользователь пустой, то поля пустые
        if (okIsClicked) {
            //значит, все данные о personе заполнены корректно, и можно добавлять его к остальным
            restApi.postPerson(newPerson);
            main.UpdateTable();
        }
    }

    private void showPersonOverviewDetails(Person person){
        if (person != null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthDay()));
        }
        else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    public void setMain(Main main) {
        this.main = main;
        this.restApi = main.getRestAPI();

        personTable.setItems(main.getPersonData());
    }


}
