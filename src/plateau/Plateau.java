package plateau;

import java.util.HashMap;

public class Plateau {

    private final int TAILLE = 13;
    private final int TAILLECASE = 3;

    private String[][] plateau;
    private Piece pieceRouge;
    private Piece pieceBlanc;
    private Piece pieceBleu;
    private HashMap<Integer, int[] > positionPosible;

    public Plateau() {
        this.plateau = new String[TAILLE][TAILLE];
        initialiserPlateau();
        initPiece();
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

    public void initPiece() {
        pieceRouge = new Piece(2, 6, 2, 10, "R");
        pieceBlanc = new Piece(6, 6, 6, 10, "W");
        pieceBleu = new Piece(10, 6, 10, 10, "B");
        placerPiece(pieceRouge);
        placerPiece(pieceBlanc);
        placerPiece(pieceBleu);
    }

    public void placerPiece(Piece piece) {
        if (piece != null) {
            int[] pos1 = piece.getPosition1();
            int[] pos2 = piece.getPosition2();
            plateau[pos1[0]][pos1[1]] = piece.getPiece()[0] + " ";
            plateau[pos2[0]][pos2[1]] = piece.getPiece()[1] + " ";
        }
    }

    public void chercherPositionLibre(){
        int compteur =  1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int centreX = i * 4 + 2;
                int centreY = j * 4 + 2;
                if (plateau[centreX][centreY].equals("  ")){
                    plateau[centreX][centreY] = String.valueOf(compteur++);
                    positionPosible.putIfAbsent(compteur, new int[]{centreX, centreY});
                }
            }
        }
    }


    public void deplacerPiece(int i ,Piece piece) {

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
