package program.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.models.Person;
import program.utils.DateUtil;

public class PersonEditingController {

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField streetText;

    @FXML
    private TextField postalCodeText;

    @FXML
    private TextField cityText;

    @FXML
    private TextField birthdayText;

    private Stage dialogueStage;
    private Person person;
    private boolean okIsClicked = false;

    @FXML private void initialize() {}

    public void setDialogueStage(Stage dialogStage) {
        this.dialogueStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;
        if (person.getFirstName() != null && person.getLastName() != null){
            firstNameText.setText(person.getFirstName());
            lastNameText.setText(person.getLastName());
            streetText.setText(person.getStreet());
            cityText.setText(person.getCity());
            postalCodeText.setText(Integer.toString(person.getPostalCode()));
            birthdayText.setText(DateUtil.format(person.getBirthDay()));
        }
        else{
            firstNameText.setText("");
            lastNameText.setText("");
            streetText.setText("");
            cityText.setText("");
            postalCodeText.setText("");
            birthdayText.setPromptText("dd.MM.yyyy");
        }
    }

    public boolean isOkClicked() {
        return okIsClicked;
    }

    @FXML private void clickedOK() {
        if (InputCheck()) {
            person.setFirstname(firstNameText.getText());
            person.setLastName(lastNameText.getText());
            person.setStreet(streetText.getText());
            person.setPostalCode(Integer.parseInt(postalCodeText.getText()));
            person.setCity(cityText.getText());
            person.setBirthDay(DateUtil.parse(birthdayText.getText()));

            okIsClicked = true;
            dialogueStage.close();
        }
    }

    @FXML private void isCancelClicked() {
        dialogueStage.close();
    }

    public static boolean isDouble(String str) {
        //Проверка на не целое число (а нам вообще нельзя, чтобы какое-либо поле было нецелым числом)
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        //Проверка на целое число (нам нужно, чтобы postalCode был именно цулым числом)
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String errorMessage(){
        if (firstNameText.getText() == null || isDouble(firstNameText.getText()) == true
                || isInteger(firstNameText.getText()) == true || firstNameText.getText().length() == 0){
            return "Invalid First Name!";
        }
        if (lastNameText.getText() == null || isDouble(lastNameText.getText()) == true
                || isInteger(lastNameText.getText()) == true || lastNameText.getText().length() == 0){
            return "Invalid Last Name!";
        }
        if (streetText.getText() == null || isDouble(streetText.getText()) == true
                || isInteger(streetText.getText()) == true || streetText.getText().length() == 0){
            return "Invalid Street!";
        }
        if (cityText.getText() == null || isDouble(cityText.getText()) == true
                || isInteger(cityText.getText()) == true || cityText.getText().length() == 0){
            return "Invalid First Name!";
        }
        if (postalCodeText.getText() == null
                || isInteger(postalCodeText.getText()) == false || postalCodeText.getText().length() == 0){
            return "Invalid Postal Code!";
        }
        if (birthdayText.getText() == null || isDouble(birthdayText.getText()) == true
                || isInteger(birthdayText.getText()) == true || birthdayText.getText().length() == 0
                || DateUtil.validDate(birthdayText.getText()) == false){
            return "Invalid Birthday!";
        }
        return "";
    }

    private boolean InputCheck() {
        String message = errorMessage();
        if (message.length() == 0) return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogueStage);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please correct your input");
            alert.setContentText(message);
            alert.showAndWait();
            return false;
        }
    }
}
