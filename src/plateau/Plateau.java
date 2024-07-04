package plateau;

public class Plateau {

    private final int TAILLE = 13;
    private final int TAILLECASE = 5;

    private String[][] plateau;
    private Piece pieceRouge;
    private Piece pieceBlanc;
    private Piece pieceBleu;

    public Plateau() {
        this.plateau = new String[TAILLE][TAILLE];
        initialiserPlateau();
//        initPiece();
    }

    public void initPiece() {
        pieceRouge = new Piece(2, 2, 2, 3, "R");
        pieceBlanc = new Piece(6, 2, 6, 3, "W");
        pieceBleu = new Piece(5, 2, 5, 3, "B");

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                int centreX = i * 4 + 2;
                int centreY = j * 4 + 2;
                if (i == 0 && j == 1) {
                    plateau[centreX][centreY] = pieceRouge.getValue();
                } else if (i == 1 && j == 1) {
                    plateau[centreX][centreY] = pieceBlanc.getValue();
                } else if (i == 2 && j == 1) {
                    plateau[centreX][centreY] = pieceBleu.getValue();
                }
            }
        }
    }

    public void initialiserPlateau() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (i % TAILLECASE == 0 || j % TAILLECASE == 0) {
                    plateau[i][j] = "*";
                } else {
                    plateau[i][j] = " ";
                }
            }
        }
    }


}
