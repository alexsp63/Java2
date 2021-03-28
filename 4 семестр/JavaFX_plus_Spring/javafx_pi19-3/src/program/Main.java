package program;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import program.controllers.PersonEditingController;
import program.controllers.PersonOverviewController;
import program.models.Person;
import program.utils.RestAPI;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private RestAPI restAPI;

    public void UpdateTable(){
        personData.clear();
        personData.addAll(restAPI.getPerson());
    }

    public Main(){
        restAPI = new RestAPI();
        this.UpdateTable();
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Address Application");

        initRootLayout(); //сначала показываем root

        showPersonOverview(); //потом main
    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/root.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showPersonOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/main.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMain(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public boolean showPersonDialogue(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/personEditDialogue.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogueStage = new Stage();
            dialogueStage.setTitle("EDIT");
            dialogueStage.initModality(Modality.WINDOW_MODAL);
            dialogueStage.initOwner(primaryStage);

            Scene scene = new Scene(page);
            dialogueStage.setScene(scene);
            PersonEditingController controller = loader.getController();

            controller.setDialogueStage(dialogueStage, this, restAPI);
            controller.setPerson(person);

            dialogueStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public RestAPI getRestAPI() {
        return restAPI;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
