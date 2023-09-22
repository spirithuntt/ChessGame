package com.chessgame.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;

public class Chessboard extends GridPane {
    private double squareSize;
    public Chessboard(double squareSize) {
        this.squareSize = squareSize;
        drawBoard();
    }

    public void drawBoard(){
        int size = 8;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Rectangle r = new Rectangle();
                r.setWidth(squareSize);
                r.setHeight(squareSize);
                if ((row + column) % 2 == 0) {
                    r.setFill(Color.WHITE);
                } else {
                    r.setFill(Color.BLACK);
                }
                add(r, column, row);
            }
        }
    }

    public void addPiece(int row,int col, String piece, boolean isWhite){

        String color = isWhite ? "white" : "black";

        String pieceName = color + "-" + piece + ".png";

        Image pieceIcon = null;
        try {

            URL url = ClassLoader.getSystemClassLoader().getResource(pieceName);
             pieceIcon = new Image(url.openStream());

        } catch (Exception e) {
            System.out.println("Error loading piece icon " + e.getMessage());
        }


        ImageView pieceView = new ImageView(pieceIcon);

        pieceView.setFitWidth(squareSize);
        pieceView.setFitHeight(squareSize);

        add(pieceView, col, row);
    }
}