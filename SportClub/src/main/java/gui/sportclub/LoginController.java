package gui.sportclub;

import Models.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void signIn(ActionEvent event) {
        String email = emailField.getText();
        String pwd = passwordField.getText();
        if (Person.login(email, pwd)) {
            FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApp.class.getResource("Calendar.fxml"));
            try {
                root = fxmlLoader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("SportClub");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
