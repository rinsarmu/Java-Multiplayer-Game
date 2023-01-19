package com.example.piggame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    Stage window;
    Scene scene;
    Group root = new Group();
    HBox players = new HBox();
    VBox player1 = new VBox();

    Text playerOne = new Text("Player 1");
    Text scoreOne = new Text("score");
    VBox currentOne = new VBox();
    Text currentScoreTitleOne = new Text("Current");
    Text getCurrentScoreOne = new Text("0");

    VBox player2 = new VBox();
    Text playerTwoName = new Text("Player 1");
    Text scoreTwo = new Text("score");
    VBox currentTwo = new VBox();
    Text currentScoreTitleTwo = new Text("Current");
    Text getCurrentScoreTwo = new Text("0");
    Button newGame = new Button("New Game");
    Button rollDice = new Button("Roll Dice");
    Button hold = new Button("Hold");
    Text rolledDice = new Text("0");

    int [] score= {0,0};

    int currentscore = 0;
    int activePlayer = 0;


    InputStream stream1,stream2,stream3,stream4,stream5,stream6;
    Image image, image2;
    //Creating the image view
    ImageView imageView = new ImageView();
    //Setting image to the image view


    @Override
    public void start(Stage stage) throws IOException {

//        score=[2,2,3,4};
       window = stage;
       window.show();
        addCHildrens();
        ui();

        rollDice.setOnAction(e->{
            try {
                rolling();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        hold.setOnAction(e->{
            holdBtn();
        });
    }

    private void switchPlayer(){
        activePlayer = activePlayer == 0 ? 1 : 0;
        System.out.println("Active player : " + activePlayer);

    }

    private void holdBtn(){
        System.out.println("hold btn");
        score[activePlayer] +=currentscore;
        if(activePlayer==0){
            getCurrentScoreOne.setText("2");
//            getCurrentScoreOne.setText(String.valueOf(score[activePlayer]));
        } else {

        }
    }
    private void rolling() throws FileNotFoundException {
        int num =(int) (Math.floor((Math.random() * 6) + 1));

        if(num != 1) {

            rolledDice.setText(String.valueOf(num));
            System.out.println(num);

            stream2 = new FileInputStream("/home/kuusaa/Pictures/dice/0" + num + ".png");
            image2 = new Image(stream2);
            imageView.setImage(image2);
        }
        {
            switchPlayer();
        }
            window.show();


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

        imageView.setLayoutY(100);
        imageView.setLayoutX(330);
        imageView.setFitHeight(250);
        imageView.setPreserveRatio(true);

        window.setMaxWidth(900);
        window.setMaxHeight(600);
        window.setMinHeight(600);

        window.setMinWidth(900);
//        window.setResizable(false);

    }
    private void addCHildrens() throws FileNotFoundException {

        currentOne.getChildren().addAll(currentScoreTitleOne,getCurrentScoreOne);
        player1.getChildren().addAll(playerOne, scoreOne,currentOne);

        currentTwo.getChildren().addAll(currentScoreTitleTwo,getCurrentScoreTwo);
        player2.getChildren().addAll(playerTwoName,scoreTwo,currentTwo);

        players.getChildren().addAll(player1, player2);

        imageView.setImage(image);
       stream1 =  new FileInputStream("/home/kuusaa/Pictures/dice/01.png");
        image = new Image(stream1);
        imageView.setImage(image);
        root.getChildren().addAll(players,newGame,rollDice,hold, rolledDice,imageView);
        scene = new Scene(root, 600,900);
        window.setScene(scene);
    }


    public static void main(String[] args) {
        launch();
    }
}