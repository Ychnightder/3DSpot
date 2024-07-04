package plateau;

import java.util.ArrayList;
import java.util.List;

public class plateau {

    private final int TAILLE = 13;
    private final int TAILLECASE = 5;

    private static String[][] plateau;
    private List<Piece> listPiece;

    private static Piece pieceRouge;
    private static Piece pieceBlanc;
    private static Piece pieceBleu;



    public plateau() {
        this.plateau = new String[TAILLE][TAILLE];
    }

    public void  initPiece(){
        listPiece.add(new  Piece(5 , 4 ,"R"));
    }
    public void initPlateau(){

    }





}
