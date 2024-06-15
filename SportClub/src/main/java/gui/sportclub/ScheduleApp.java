package gui.sportclub;

import Models.Person;
import Services.Serializator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScheduleApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Serializator.readData();
        Person.showUsers();
        FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApp.class.getResource("WelcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
