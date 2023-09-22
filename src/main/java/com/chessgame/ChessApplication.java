package com.chessgame;

import com.chessgame.logic.Bishop;
import com.chessgame.logic.Pawn;
import com.chessgame.logic.Piece;
import com.chessgame.ui.Chessboard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //white pieces
        //pawns
        Chessboard chessboard = new Chessboard(50.5);
        Piece whitePawn1 = new Pawn(1, 0, true);
        chessboard.addPiece(whitePawn1.getRow(), whitePawn1.getCol(), "pawn", whitePawn1.isWhite());
        Piece whitePawn2 = new Pawn(1, 1, true);
        chessboard.addPiece(whitePawn2.getRow(), whitePawn2.getCol(), "pawn", whitePawn2.isWhite());
        Piece whitePawn3 = new Pawn(1, 2, true);
        chessboard.addPiece(whitePawn3.getRow(), whitePawn3.getCol(), "pawn", whitePawn3.isWhite());
        Piece whitePawn4 = new Pawn(1, 3, true);
        chessboard.addPiece(whitePawn4.getRow(), whitePawn4.getCol(), "pawn", whitePawn4.isWhite());
        Piece whitePawn5 = new Pawn(1, 4, true);
        chessboard.addPiece(whitePawn5.getRow(), whitePawn5.getCol(), "pawn", whitePawn5.isWhite());
        Piece whitePawn6 = new Pawn(1, 5, true);
        chessboard.addPiece(whitePawn6.getRow(), whitePawn6.getCol(), "pawn", whitePawn6.isWhite());
        Piece whitePawn7 = new Pawn(1, 6, true);
        chessboard.addPiece(whitePawn7.getRow(), whitePawn7.getCol(), "pawn", whitePawn7.isWhite());
        Piece whitePawn8 = new Pawn(1, 7, true);
        chessboard.addPiece(whitePawn8.getRow(), whitePawn8.getCol(), "pawn", whitePawn8.isWhite());

        //Bishops
        Piece whiteBishop1 = new Bishop(0, 2, true);
        chessboard.addPiece(whiteBishop1.getRow(), whiteBishop1.getCol(), "bishop", whiteBishop1.isWhite());
        Piece whiteBishop2 = new Bishop(0, 5, true);
        chessboard.addPiece(whiteBishop2.getRow(), whiteBishop2.getCol(), "bishop", whiteBishop2.isWhite());

        //king
        Piece whiteKing = new Bishop(0, 4, true);
        chessboard.addPiece(whiteKing.getRow(), whiteKing.getCol(), "king", whiteKing.isWhite());

        //knights
        Piece whiteKnight1 = new Bishop(0, 1, true);
        chessboard.addPiece(whiteKnight1.getRow(), whiteKnight1.getCol(), "knight", whiteKnight1.isWhite());
        Piece whiteKnight2 = new Bishop(0, 6, true);
        chessboard.addPiece(whiteKnight2.getRow(), whiteKnight2.getCol(), "knight", whiteKnight2.isWhite());

        //queen
        Piece whiteQueen = new Bishop(0, 3, true);
        chessboard.addPiece(whiteQueen.getRow(), whiteQueen.getCol(), "queen", whiteQueen.isWhite());

        //rooks
        Piece whiteRook1 = new Bishop(0, 0, true);
        chessboard.addPiece(whiteRook1.getRow(), whiteRook1.getCol(), "rook", whiteRook1.isWhite());
        Piece whiteRook2 = new Bishop(0, 7, true);
        chessboard.addPiece(whiteRook2.getRow(), whiteRook2.getCol(), "rook", whiteRook2.isWhite());


        //black pieces

        //pawns
        Piece blackPawn1 = new Pawn(6, 0, false);
        chessboard.addPiece(blackPawn1.getRow(), blackPawn1.getCol(), "pawn", blackPawn1.isWhite());
        Piece blackPawn2 = new Pawn(6, 1, false);
        chessboard.addPiece(blackPawn2.getRow(), blackPawn2.getCol(), "pawn", blackPawn2.isWhite());
        Piece blackPawn3 = new Pawn(6, 2, false);
        chessboard.addPiece(blackPawn3.getRow(), blackPawn3.getCol(), "pawn", blackPawn3.isWhite());
        Piece blackPawn4 = new Pawn(6, 3, false);
        chessboard.addPiece(blackPawn4.getRow(), blackPawn4.getCol(), "pawn", blackPawn4.isWhite());
        Piece blackPawn5 = new Pawn(6, 4, false);
        chessboard.addPiece(blackPawn5.getRow(), blackPawn5.getCol(), "pawn", blackPawn5.isWhite());
        Piece blackPawn6 = new Pawn(6, 5, false);
        chessboard.addPiece(blackPawn6.getRow(), blackPawn6.getCol(), "pawn", blackPawn6.isWhite());
        Piece blackPawn7 = new Pawn(6, 6, false);
        chessboard.addPiece(blackPawn7.getRow(), blackPawn7.getCol(), "pawn", blackPawn7.isWhite());
        Piece blackPawn8 = new Pawn(6, 7, false);
        chessboard.addPiece(blackPawn8.getRow(), blackPawn8.getCol(), "pawn", blackPawn8.isWhite());

        //Bishops
        Piece blackBishop1 = new Bishop(7, 2, false);
        chessboard.addPiece(blackBishop1.getRow(), blackBishop1.getCol(), "bishop", blackBishop1.isWhite());
        Piece blackBishop2 = new Bishop(7, 5, false);
        chessboard.addPiece(blackBishop2.getRow(), blackBishop2.getCol(), "bishop", blackBishop2.isWhite());

        //king
        Piece blackKing = new Bishop(7, 4, false);
        chessboard.addPiece(blackKing.getRow(), blackKing.getCol(), "king", blackKing.isWhite());

        //knights
        Piece blackKnight1 = new Bishop(7, 1, false);
        chessboard.addPiece(blackKnight1.getRow(), blackKnight1.getCol(), "knight", blackKnight1.isWhite());
        Piece blackKnight2 = new Bishop(7, 6, false);
        chessboard.addPiece(blackKnight2.getRow(), blackKnight2.getCol(), "knight", blackKnight2.isWhite());

        //queen
        Piece blackQueen = new Bishop(7, 3, false);
        chessboard.addPiece(blackQueen.getRow(), blackQueen.getCol(), "queen", blackQueen.isWhite());

        //rooks
        Piece blackRook1 = new Bishop(7, 0, false);
        chessboard.addPiece(blackRook1.getRow(), blackRook1.getCol(), "rook", blackRook1.isWhite());
        Piece blackRook2 = new Bishop(7, 7, false);
        chessboard.addPiece(blackRook2.getRow(), blackRook2.getCol(), "rook", blackRook2.isWhite());


        Scene scene = new Scene(chessboard);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}