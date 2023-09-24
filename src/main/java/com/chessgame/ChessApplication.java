package com.chessgame;

import com.chessgame.ui.Chessboard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import com.chessgame.ui.Input;

import java.io.IOException;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //pawns
        Chessboard chessboard = new Chessboard(50.5);
        StackPane gamePane = new StackPane(chessboard);

        // Create an Input instance and pass the game pane to it
        Input inputHandler = new Input(chessboard);
        Scene scene = new Scene(gamePane);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}