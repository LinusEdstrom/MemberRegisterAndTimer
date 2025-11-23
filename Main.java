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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;

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
    public void start(Stage stage) throws Exception {
        stage.setTitle(" MemberRegister and Timer");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(40, 30, 40, 30));
    grid.setHgap(14);
    grid.setVgap(10);

    // First name
    Label firstName = new Label("Enter first name");
    GridPane.setConstraints(firstName, 0, 0);

    TextField firstNameInput = new TextField();
    GridPane.setConstraints(firstNameInput, 0, 1);

    // Last name
    Label lastName = new Label(" Enter last name");
    GridPane.setConstraints(lastName, 0, 5);

    TextField lastNameInput = new TextField();
    GridPane.setConstraints(lastNameInput, 0, 6);

    //Phone number
    Label phoneNumber = new Label("Enter phone number");
    GridPane.setConstraints(phoneNumber, 0, 10);

    TextField phoneNumberInput = new TextField();
    GridPane.setConstraints(phoneNumberInput, 0, 11);

    //Adress
    Label address = new Label("Enter address");
    GridPane.setConstraints(address, 0,15);

    TextField addressInput = new TextField();
    GridPane.setConstraints(addressInput, 0, 16);

    Label newMember = new Label();
    newMember.setStyle("-fx-font-size: 15;");
    GridPane.setConstraints(newMember, 0, 23);

    Button button = new Button(" Save member");


    GridPane.setConstraints(button, 0, 21);
    button.setOnAction(saveMember -> {
                newMember.setText("New member saved: " + firstNameInput.getText() + " ," +
                        lastNameInput.getText() + " ," + phoneNumberInput.getText() +
                        " ," + addressInput.getText());
    });

    Button start = new Button("START");
    start.setStyle("-fx-background-color: green;");
    GridPane.setConstraints(start, 12, 1);
    start.setOnAction(time -> timerTime.play());

    Button stop = new Button("STOP");
    stop.setStyle("-fx-background-color: red;");
    GridPane.setConstraints(stop, 12, 5);
    stop.setOnAction(time -> timerTime.stop());

    Label timerLabel = new Label("00:00:00");
    GridPane.setConstraints(timerLabel, 12, 9);

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







        grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput,
                phoneNumber, phoneNumberInput, address, addressInput, newMember, button, timerLabel, start, stop);

        //Testar lägga in ett styles.css, ett CSS stylesheet


        Scene scene = new Scene(grid, 600, 1000);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        // getClass().getResource returnerar en URL. /styles är för att man letar styles från root katalogen scr/main/resources där den brukar ligga
        // getResource("/styles.css").toExternalForm());
        Platform.runLater(()-> { button.setStyle("-fx-background-radius: 0;" + // Gör en Platform.runLater(() för att
                // det ska garantera att den här knappens button.setStyle inte blir överkörd av den i styles.css
                "-fx-background-color: lightgray;" +
                "-fx-font-size: 12px;" +
                "-fx-pref-width: 100px;" +
                "-fx-pre-heigth: 60px;"
        );
        });


        stage.setScene(scene);
        stage.show();





    }


}




/*
    private void stoptCounting(){
    if(worker != null && worker.isAlive()){
        worker.interrupt();
    }

 */


