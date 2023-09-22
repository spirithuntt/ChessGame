package com.chessgame;

import com.chessgame.ui.Chessboard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Chessboard chessboard = new Chessboard(50.5);
        chessboard.addPiece(0, 0, "bishop", true);
        chessboard.addPiece(0, 1, "knight", true);
        chessboard.addPiece(0, 0, "bishop", false);
        chessboard.addPiece(7, 1, "knight", false);
        Scene scene = new Scene(chessboard);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}