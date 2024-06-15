package gui.sportclub;

import Models.ClassSession;
import Models.Schedule;
import Services.LoginSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class CalendarController {


    @FXML
    private Text year;
    @FXML
    private DatePicker datePicker;
    @FXML
    private FlowPane calendar;
    @FXML
    public Button todayButton;

    @FXML
    private Label userName;
    private boolean isDatePicked=false;
    LocalDate dateFocus;
    LocalDate today;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        dateFocus = LocalDate.now();
        today = LocalDate.now();
        userName.setText(LoginSingleton.getCurrentUser().firstName+" "+LoginSingleton.getCurrentUser().lastName);
        drawCalendar();
    }
    @FXML
    public void signOut(ActionEvent event){
        LoginSingleton.signOut();
        FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApp.class.getResource("WelcomePage.fxml"));
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
    @FXML
    public void getDate(){
        dateFocus=datePicker.getValue();
        calendar.getChildren().clear();
        isDatePicked=true;
        drawCalendar();
    }
    @FXML
    public void setTodayDate(){
        dateFocus=today;
        isDatePicked=false;
        calendar.getChildren().clear();
        drawCalendar();
    }
    @FXML
    public void setDayScheduleScene(ArrayList<ClassSession> sessions,LocalDate date, MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApp.class.getResource("daySchedule.fxml"));
        root=fxmlLoader.load();

        DaySchController schController=fxmlLoader.getController();
        schController.setSessions(sessions);
        schController.setDate(date);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("SportClub");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    private void drawCalendar(){
        year.setText(String.valueOf((dateFocus.getMonth().getValue()<10?("0"+dateFocus.getMonth().getValue()):dateFocus.getMonth().getValue())+"."+dateFocus.getYear()));
        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        //List of activities for a given month
        Map<Integer, ArrayList<ClassSession>> calendarActivityMap = Schedule.getInstances().get(0).weekSchedule; //getCalendarActivitiesMonth(dateFocus);

        int monthMaxDate = dateFocus.getMonth().maxLength();
        //Check for leap year
        if(dateFocus.getYear() % 4 != 0 && monthMaxDate == 29){
            monthMaxDate = 28;
        }
        int dateOffset = LocalDate.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1).getDayOfWeek().getValue();
        System.out.println(dateOffset);
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= 7; j++) {
                StackPane stackPane = new StackPane();
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth =(calendarWidth/7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight/6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j+1)+(7*i);
                if(calculatedDate > dateOffset){
                    int currentDate = calculatedDate - dateOffset;
                    if(currentDate <= monthMaxDate){
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = - (rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        ArrayList<ClassSession> calendarSessions = calendarActivityMap.get(j);
                        if(calendarSessions != null){
                            rectangle.setFill(Color.LIGHTGREY);
                            String groupsNames="";
                            for (int k = 0; k < calendarSessions.size(); k++) {
                                if (k >= 2) {
                                    groupsNames+="...";
                                    break;
                                }
                                groupsNames+= calendarSessions.get(k).getGroupClass().name+"\n";
                            }
                            Text TextBox = new Text(groupsNames);
                            stackPane.getChildren().add(TextBox);
                            stackPane.setOnMouseClicked(mouseEvent -> {
                                try {
                                    System.out.println(LocalDate.of(dateFocus.getYear(),dateFocus.getMonth(),currentDate));
                                    setDayScheduleScene(calendarSessions,LocalDate.of(dateFocus.getYear(),dateFocus.getMonth(),currentDate),mouseEvent);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        }
                    }

                    if (isDatePicked && datePicker.getValue().getYear() == dateFocus.getYear() && datePicker.getValue().getMonth() == dateFocus.getMonth() && datePicker.getValue().getDayOfMonth() == currentDate)
                            rectangle.setFill(Color.LIGHTGREEN);
                    if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate)
                        rectangle.setFill(Color.LIGHTBLUE);
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }



}