package plateau;
import org.junit.Test;

import java.util.Scanner;


public class testCarre {
    @Test
    public void testCarre() {
        Plateau plateau = new Plateau();
        Piece pieceRouge;
        Piece pieceBlanc;
        Piece pieceBleu;

        pieceRouge = new Piece(2, 6, 2, 10, "R");
        pieceBlanc = new Piece(6, 6, 6, 10, "W");
        pieceBleu = new Piece(10, 6, 10, 10, "B");

        plateau.placerPiece(pieceRouge);
        plateau.placerPiece(pieceBlanc);
        plateau.placerPiece(pieceBleu);
        plateau.chercherPositionLibre();
        plateau.pieceSelectionner(pieceRouge);
        plateau.mettrePoints();
        plateau.deplacerPieceH(1, pieceRouge);
//        plateau.mettrePoints();
        plateau.effacerChiffre();
        plateau.chercherPositionLibre();
        plateau.deplacerPieceV(3, pieceBlanc);
        plateau.effacerChiffre();
        plateau.mettrePoints();
        System.out.println(plateau);


//        int taille = 13;
//        int[][] tableau = new int[taille][taille];
//
//        // Initialisation du tableau pour démonstration
//        int valeur = 1;
//        for (int i = 0; i < taille; i++) {
//            for (int j = 0; j < taille; j++) {
//                tableau[i][j] = valeur++;
//            }
//        }
//
//
//        System.out.println("Centres des grandes cases:");
//        // Parcourir et afficher les centres des grandes cases
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                int centreX = i * 4 + 2;
//                int centreY = j * 4 + 2;
//                System.out.println("Centre de la grande case (" + i + ", " + j + "): " + " " +centreX+" " + centreY + " " +  tableau[centreX][centreY]);
//            }
//        }
    }
}




//        * * * * *
//        *       *
//        *       *
//        *       *
//        * * * * *
//
//        * * * * *
//        *       *
//        *       *
//        *       *
//        * * * * *


//        * * * * * * * * * * * * *
//        *       *       *       *
//        *   R   *   R   *       *
//        *       *       *       *
//        * * * * * * * * * * * * *
//        *       *       *       *
//        *   W   *       *       *
//        *       *       *       *
//        * * * * * * * * * * * * *
//        *       *       *       *
//        *   W   *   B   *   B   *
//        *       *       *       *
//        * * * * * * * * * * * * *