package plateau;

import java.util.HashMap;
import java.util.SplittableRandom;

public class Plateau {

    private final int TAILLE = 13;
    private final int TAILLECASE = 3;

    private String[][] plateau;
    private static HashMap<Integer, int[] > positionPosible;

    public Plateau() {
        this.plateau = new String[TAILLE][TAILLE];
        positionPosible = new HashMap<>();
        initialiserPlateau();
    }

    public void initialiserPlateau() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE ; j++) {
                if (i % ( TAILLECASE + 1) == 0 || j % ( TAILLECASE + 1) == 0) {
                    plateau[i][j] = "* ";
                } else {
                    plateau[i][j] = "  ";
                }
            }
        }
    }


    public void placerPiece(Piece piece) {
        if (piece != null) {
            int[] pos1 = piece.getPosition1();
            int[] pos2 = piece.getPosition2();
            plateau[pos1[0]][pos1[1]] = piece.getPiece()[0] + " ";
            plateau[pos2[0]][pos2[1]] = piece.getPiece()[1] + " ";
        }
    }

    public void chercherPositionLibre() {
        int compteur = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int centreX = i * 4 + 2;
                int centreY = j * 4 + 2;
                if (plateau[centreX][centreY].equals("  ")) {
                    positionPosible.put(compteur, new int[]{centreX, centreY});
                    plateau[centreX][centreY] = compteur + " ";
                    compteur++;
                }
            }
        }
    }



    public void mettrePoints(){
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 3; j++) {
                int centreX = i * 4 + 2;
                int centreY = j * 4 + 2;
                if (plateau[centreX][centreY].equals("  ")){
                    plateau[centreX][centreY] = "O ";
                }
            }
        }
    }

    private void effacerDernierPosition(Piece piece){
        if (piece != null) {
            int[] anciennePos1  = piece.getPosition1();
            int[] anciennePos2  = piece.getPosition2();
            plateau[anciennePos1[0]][anciennePos1[1]] = "  ";
            plateau[anciennePos2[0]][anciennePos2[1]] = "  ";
        }
    }


//    public void deplacerPiece(int i, Piece piece) {
//        int[] nouvellePosition = positionPosible.get(i);
//        int centreX = nouvellePosition[0];
//        int centreY = nouvellePosition[1];
//
//        if (centreY + 4 < TAILLE && plateau[centreX][centreY + 4].equals("  ")) {
//            deplacerPieceH(i, piece);
//        }
//        if (centreX + 4 < TAILLE && plateau[centreX + 4][centreY].equals("  ")) {
//            deplacerPieceV(i, piece);
//        }
//    }


    public void deplacerPieceH(int i, Piece piece) {
        effacerDernierPosition(piece);
        int[] nouvellePosition = positionPosible.get(i);
        int centreX = nouvellePosition[0];
        int centreY = nouvellePosition[1];

        if (centreY + 4 < TAILLE) {
            piece.setPosition1(centreX, centreY);
            piece.setPosition2(centreX, centreY + 4);
            placerPiece(piece);
        } else if (centreY - 4 >= 0) {
            piece.setPosition1(centreX, centreY);
            piece.setPosition2(centreX, centreY - 4);
            placerPiece(piece);
        }
        positionPosible.clear();
    }

    public void deplacerPieceV(int i, Piece piece) {
        effacerDernierPosition(piece);
        int[] nouvellePosition = positionPosible.get(i);
        int centreX = nouvellePosition[0];
        int centreY = nouvellePosition[1];

        if (centreX + 4 < TAILLE) {
            piece.setPosition1(centreX, centreY);
            piece.setPosition2(centreX + 4, centreY);
            placerPiece(piece);
        } else if (centreX - 4 >= 0) {
            piece.setPosition1(centreX, centreY);
            piece.setPosition2(centreX - 4, centreY);
            placerPiece(piece);
        }
        positionPosible.clear();
    }

    public void effacerChiffre() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int centreX = i * 4 + 2;
                int centreY = j * 4 + 2;
                if (plateau[centreX][centreY].trim().matches("\\d+")) {
                    plateau[centreX][centreY] = "  ";
                }
            }
        }
    }

    public void pieceSelectionner(Piece piece) {
            effacerDernierPosition(piece);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE ; j++) {
                sb.append(plateau[i][j] + "");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
