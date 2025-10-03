/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_game.Utilities;

import chess_game.Boards.Tile;
import chess_game.Pieces.*;
import chess_game.Resources.BOARD_Configurations;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BoardUtilities {

    public static boolean isValidCoordinate(Coordinate coord) {
        return (coord.getX() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getX() <= BOARD_Configurations.BOARD_UPPER_BOUND && coord.getY() >= BOARD_Configurations.BOARD_LOWER_BOUND && coord.getY() <= BOARD_Configurations.BOARD_UPPER_BOUND);
    }

    public static ImageIcon getImageOfTeamPiece(Team team, PieceTypes pieceType) {
        // Base path to the images directory
        String imagePath = "/Users/abirhossain/Downloads/Chess-main/ChessProject/src/main/java/chess_game/Img/";

        if (team == null || pieceType == null) {
            imagePath += "transparent.png"; // Default image for missing pieces
        } else {
            // Determine the file name based on team and piece type
            if (team == Team.BLACK) {
                imagePath += "black";
            } else {
                imagePath += "white";
            }

            if (pieceType == PieceTypes.BISHOP) {
                imagePath += "_bishop.png";
            } else if (pieceType == PieceTypes.KING) {
                imagePath += "_king.png";
            } else if (pieceType == PieceTypes.QUEEN) {
                imagePath += "_queen.png";
            } else if (pieceType == PieceTypes.KNIGHT) {
                imagePath += "_knight.png";
            } else if (pieceType == PieceTypes.PAWN) {
                imagePath += "_pawn.png";
            } else if (pieceType == PieceTypes.ROOK) {
                imagePath += "_rook.png";
            }
        }

        try {
            File img = new File(imagePath); // Create a file object for the image path
            if (!img.exists()) { // Check if the file exists
                throw new IOException("File not found: " + imagePath);
            }
            BufferedImage bufferedImage = ImageIO.read(img); // Read the image
            return new ImageIcon(bufferedImage); // Return the ImageIcon
        } catch (IOException ex) {
            Logger.getLogger(BoardUtilities.class.getName()).log(Level.SEVERE, "Error loading image: " + imagePath, ex);
        }
        return null; // Return null if an error occurs
    }


    public static Tile[][] createStandartBoardTiles() {
        Tile[][] tiles = new Tile[BOARD_Configurations.ROW_COUNT][BOARD_Configurations.ROW_TILE_COUNT];
        tiles[0][0] = new Tile(new Coordinate(0, 0), new Rook(Team.BLACK));
        tiles[1][0] = new Tile(new Coordinate(1, 0), new Knight(Team.BLACK));
        tiles[2][0] = new Tile(new Coordinate(2, 0), new Bishop(Team.BLACK));
        tiles[3][0] = new Tile(new Coordinate(3, 0), new Queen(Team.BLACK));
        tiles[4][0] = new Tile(new Coordinate(4, 0), new King(Team.BLACK));
        tiles[5][0] = new Tile(new Coordinate(5, 0), new Bishop(Team.BLACK));
        tiles[6][0] = new Tile(new Coordinate(6, 0), new Knight(Team.BLACK));
        tiles[7][0] = new Tile(new Coordinate(7, 0), new Rook(Team.BLACK));

        for (int i = 0; i < 8; i++) {
            tiles[i][1] = new Tile(new Coordinate(i, 1), new Pawn(Team.BLACK));
            tiles[i][6] = new Tile(new Coordinate(i, 6), new Pawn(Team.WHITE));
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[j][i] = new Tile(new Coordinate(j, i), null);
            }
        }
        //white
        tiles[0][7] = new Tile(new Coordinate(0, 7), new Rook(Team.WHITE));
        tiles[1][7] = new Tile(new Coordinate(1, 7), new Knight(Team.WHITE));
        tiles[2][7] = new Tile(new Coordinate(2, 7), new Bishop(Team.WHITE));
        tiles[3][7] = new Tile(new Coordinate(4, 7), new Queen(Team.WHITE));
        tiles[4][7] = new Tile(new Coordinate(3, 7), new King(Team.WHITE));
        tiles[5][7] = new Tile(new Coordinate(5, 7), new Bishop(Team.WHITE));
        tiles[6][7] = new Tile(new Coordinate(6, 7), new Knight(Team.WHITE));
        tiles[7][7] = new Tile(new Coordinate(7, 7), new Rook(Team.WHITE));
        return tiles;
    }
}
