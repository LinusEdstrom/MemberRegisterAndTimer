package com.Edstrom;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(" MemberRegister");

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
    button.setStyle("-fx-background-radius: 100%;");
    button.setPrefSize(100, 80);        //Overrides Stylesheet, styles.css
    button.setStyle("-fx-font-size: 12px;" + "-fx-background-color: lightgray;");
    GridPane.setConstraints(button, 0, 21);
    button.setOnAction(saveMember -> {
                newMember.setText("New member saved: " + firstNameInput.getText() + " ," +
                        lastNameInput.getText() + " ," + phoneNumberInput.getText() +
                        " ," + addressInput.getText());
    });

    Label timerLabel = new Label("Timer");
    GridPane.setConstraints(timerLabel, 12, 0);

    Button start = new Button("START");
    start.setStyle("-fx-background-color: green;");
    GridPane.setConstraints(start, 12, 1);

    Button stop = new Button("STOP");
    stop.setStyle("-fx-background-color: red;");
    GridPane.setConstraints(stop, 12, 5);

    Label time = new Label(formatHMS(totalSeconds));



    grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput,
            phoneNumber, phoneNumberInput, address, addressInput, newMember, button, timerLabel, start, stop);

    //Testar lägga in ett styles.css, ett CSS stylesheet


    Scene scene = new Scene(grid, 600, 1000);
    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    // getClass().getResource returnerar en URL. /styles är för att man letar styles från root katalogen scr/main/resources där den brukar ligga
    // getResource("/styles.css").toExternalForm());

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


