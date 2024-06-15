package gui.sportclub;

import Models.ClassSession;
import Services.LoginSingleton;
import Services.Serializator;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DaySchController {
    private ArrayList<ClassSession> sessions;

    @FXML
    private Label classesDate;

    @FXML
    private TableView<ClassSession> groupClassesTable;

    @FXML
    private TableColumn<ClassSession, String> classesColumn;

    @FXML
    private TableColumn<ClassSession, String> membersColumn;
    @FXML
    private TableColumn<ClassSession, String> timeColumn;
    @FXML
    private Label groupClassNameLabel;

    @FXML
    private Label membersLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label coachLabel;
    @FXML
    private Label alarmLabel;
    @FXML
    private Button joinButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ClassSession selectedSession;
    @FXML
    public void goBack(MouseEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApp.class.getResource("Calendar.fxml"));
        try {
            root=fxmlLoader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("SportClub");
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
    public void joinClass(){
        try{
            boolean result=selectedSession.addClientQualif(LoginSingleton.getCurrentUser().getClientLink());
            if(result) {
                System.out.println("Selected session: " + selectedSession.getName());
                joinButton.setText("Leave class");
                joinButton.setOnAction(MouseEvent -> {
                    leaveClass();
                });
                Serializator.save();
                alarmLabel.setTextFill(Color.LIGHTGREEN);
                alarmLabel.setText("You successfully joined the class");
            }
            else {
                alarmLabel.setTextFill(Color.RED);
                alarmLabel.setText("This class is full");
            }
        }
        catch (NullPointerException e){
            alarmLabel.setText("SELECT CLASS");
            e.printStackTrace();
        }
    }
    public void leaveClass(){
        try{

            selectedSession.removeClient(LoginSingleton.getCurrentUser().getClientLink());
            joinButton.setText("Join class");
            joinButton.setOnAction(MouseEvent->{
                joinClass();
            });
            Serializator.save();
            alarmLabel.setTextFill(Color.RED);
            alarmLabel.setTextFill(Color.LIGHTGREEN);
            alarmLabel.setText("You successfully left the class");
        }
        catch (NullPointerException e){
            alarmLabel.setText("SELECT CLASS");
        }
    }

    public void setSessions(ArrayList<ClassSession> sessions) {
        this.sessions = sessions;
        groupClassesTable.getItems().setAll(sessions); // Заполнить таблицу сессиями
    }

    public void setDate(LocalDate date) {
        classesDate.setText(date.toString());
    }

    public void initialize() {
        // Настройка колонок таблицы
        classesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        membersColumn.setCellValueFactory(cellData -> {
            ClassSession session = cellData.getValue();
            String membersInfo = session.totalMembers + "/" + session.getMaxMembers();
            return new ReadOnlyStringWrapper(membersInfo);
        });
        timeColumn.setCellValueFactory(cellData->{
            ClassSession session = cellData.getValue();
            String timeInfo=session.getStartTime()+" - "+session.getEndTime();
            return new ReadOnlyStringWrapper(timeInfo);
        });

        // Если нужны текстовые поля для редактирования
        classesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        membersColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        groupClassesTable.setOnMouseClicked(this::handleTableClick);
    }
    private void handleTableClick(MouseEvent event) {
        if (event.getClickCount() == 1) { // проверяем, что клик был одинарным
            alarmLabel.setText("");
            this.selectedSession = groupClassesTable.getSelectionModel().getSelectedItem();
            if (selectedSession != null) {
                if (selectedSession.getMembers().containsKey(LoginSingleton.getCurrentUser().getId())){
                    joinButton.setText("Leave class");
                    joinButton.setOnAction(actionEvent->{
                        leaveClass();
                    });
                }
                else {
                    joinButton.setText("Join class");
                    joinButton.setOnAction(actionEvent->{
                        joinClass();
                    });
                }
                groupClassNameLabel.setText(selectedSession.getName());
                coachLabel.setText(selectedSession.getGroupClass().getCoach().getPersonLink().firstName);
                timeLabel.setText(selectedSession.getStartTime()+"   -   "+ selectedSession.getEndTime());
                membersLabel.setText(selectedSession.totalMembers + "/" + selectedSession.getMaxMembers());

                // Здесь можно выполнить действия по выбранной сессии
            }
        }
    }
}
