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
        Chessboard chessboard = new Chessboard(50.5);
        // StackPane : lays out its children in a back-to-front stack
        StackPane gamePane = new StackPane(chessboard);

        Input inputHandler = new Input(chessboard);
        Scene scene = new Scene(gamePane);
        stage.setTitle("Chess Game");
        //STAGE : the top level JavaFX container
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}