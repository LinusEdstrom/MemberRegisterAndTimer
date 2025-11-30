package com.Edstrom;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;


public class Main extends Application {

    //attribut for timer
    Timeline timerTime;
    private int hours =0;
    private int minutes = 0;
    private int seconds = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle(" MemberRegister and Timer");

    GridPane grid = new GridPane();
    //grid.setGridLinesVisible(true);
    grid.setPadding(new Insets(15, 10, 15, 10));
    grid.setHgap(10);
    grid.setVgap(10);

    // First name
    Label firstName = new Label("Enter first name");
    firstName.setPrefWidth(450);
    GridPane.setConstraints(firstName, 0, 0);

    TextField firstNameInput = new TextField();
    GridPane.setConstraints(firstNameInput, 0, 1);

    // Last name
    Label lastName = new Label(" Enter last name");
    GridPane.setConstraints(lastName, 0, 2);

    TextField lastNameInput = new TextField();
    GridPane.setConstraints(lastNameInput, 0, 3);

    //Phone number
    Label phoneNumber = new Label("Enter phone number");
    GridPane.setConstraints(phoneNumber, 0, 4);

    TextField phoneNumberInput = new TextField();
    GridPane.setConstraints(phoneNumberInput, 0, 5);

    //Adress
    Label address = new Label("Enter address");
    GridPane.setConstraints(address, 0,6);

    TextField addressInput = new TextField();
    GridPane.setConstraints(addressInput, 0, 7);

    Label newMember = new Label();
    newMember.setStyle("-fx-font-size: 12;");
    GridPane.setConstraints(newMember, 0, 9);

    Button button = new Button(" Save member");
         button.setStyle("-fx-background-radius: 0;" +
                "-fx-background-color: lightgray;" +
                "-fx-font-size: 12px;" +
                "-fx-pref-width: 120px;" +
                "-fx-max-heigth: 30px;"

        );

    GridPane.setConstraints(button, 0, 8);
    button.setOnAction(saveMember -> {
                newMember.setText("New member saved: " + firstNameInput.getText() + " ," +
                        lastNameInput.getText() + " ," + phoneNumberInput.getText() +
                        " ," + addressInput.getText());
    });

    Button start = new Button("START");
    start.setStyle("-fx-background-color: green;");
    start.setOnAction(time -> timerTime.play());

    Button stop = new Button("STOP");
    stop.setStyle("-fx-background-color: red;");
    stop.setOnAction(time -> timerTime.stop());

    Label timerLabel = new Label("00:00:00");

    timerTime = new Timeline (new KeyFrame(Duration.seconds(1), timer -> {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        //%02d means % formats a value, 0 pads with 0 if number to short, 2 is maximum charaters, d means decimal integer
        // that gets formated into String.format.
        timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }));
        timerTime.setCycleCount(Timeline.INDEFINITE); //OCKSÅ EN FETING KONSTANT HÄMTAD FRÅN NÅN GOLISTA

        VBox timerArea = new VBox();
        timerArea.setSpacing(10);
        GridPane.setConstraints(timerArea, 16, 8);
        timerArea.getChildren().addAll(start, stop, timerLabel);


        grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput,
                phoneNumber, phoneNumberInput, address, addressInput, newMember, button, timerArea);

        //Testar lägga in ett styles.css, ett CSS stylesheet

        Scene scene = new Scene(grid, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        // getClass().getResource returnerar en URL. /styles är för att man letar styles från root katalogen scr/main/resources där den brukar ligga
        // getResource("/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();





    }


}







