package com.example.piggame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    Scene scene;
    Group root = new Group();
    HBox players = new HBox();
    VBox player1 = new VBox();
    VBox player2 = new VBox();

    Text playerOne = new Text("Player 1");
    Text scoreOne = new Text("score");
    VBox currentOne = new VBox();
    Text currentScoreTitle = new Text("Current");
    Text getCurrentScoreOne = new Text("0");
    Button newGame = new Button("New Game");
    Button rollDice = new Button("Roll Dice");
    Button hold = new Button("Hold");
    Text rolledDice = new Text("0");


    @Override
    public void start(Stage stage) throws IOException {


       window = stage;
       window.show();
        addCHildrens();
        ui();

        rollDice.setOnAction(e->{
            rolling();
        });

    }

    private void rolling() {
        int num =(int) (Math.floor((Math.random() * 6) + 1));
        rolledDice.setText(String.valueOf(num));
        System.out.println(num);
    }

    private void ui() {

        player1.setStyle(" -fx-background-color:linear-gradient(to top left, #789682 0%, #bf2e34 100%)");
        player1.setAlignment(Pos.TOP_CENTER);
        player1.setPrefWidth(450);

        playerOne.setLayoutY(20);
        playerOne.setLineSpacing(200);

        player2.setPrefWidth(450);

        players.setPrefWidth(900);
        players.setPrefHeight(600);

        players.setStyle(" -fx-background-color:linear-gradient(to top left, #753682 0%, #bf2e34 100%)");

        newGame.setLayoutY(30);
        newGame.setLayoutX(400);
        newGame.setPadding(new Insets(10));
        newGame.setStyle("-fx-border: none;");
        rollDice.setLayoutY(400);
        rollDice.setLayoutX(400);
        rollDice.setPadding(new Insets(10));
        rollDice.setStyle("-fx-border: none;");
        rollDice.setPrefWidth(100);

        rolledDice.setLayoutY(400);
        rolledDice.setLayoutX(400);
        rolledDice.setStyle("-fx-border: none;");


        hold.setLayoutY(460);
        hold.setLayoutX(400);
        hold.setPrefWidth(100);
        hold.setPadding(new Insets(10));
        hold.setStyle("-fx-border: none;");

        window.setMaxWidth(900);
        window.setMaxHeight(600);
        window.setMinHeight(600);

        window.setMinWidth(900);
//        window.setResizable(false);

    }
    private void addCHildrens() {

        currentOne.getChildren().addAll(currentScoreTitle,getCurrentScoreOne);
        player1.getChildren().addAll(playerOne, scoreOne,currentOne);

        players.getChildren().addAll(player1, player2);

        root.getChildren().addAll(players,newGame,rollDice,hold, rolledDice);
        scene = new Scene(root, 600,900);
        window.setScene(scene);
    }


    public static void main(String[] args) {
        launch();
    }
}