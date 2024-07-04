package plateau;

public class Piece {

    public String[] getPiece() {
        return piece;
    }

    private String value;
    private String[] piece;

    private int x1 ,y1,x2,y2;

    public Piece(int x1, int y1,  int x2, int y2, String value) throws  IllegalArgumentException {
        if (!isValidPosition(x1, y1) || !isValidPosition(x2, y2)) {
            this.piece = null;
            throw new IllegalArgumentException("Error: x or y is invalid");
        }
        else {
            this.piece = new String[2];
            this.piece[0] = value;
            this.piece[1] = value;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.value = value;
        }
    }

    public String toString() {
        return piece[0] + " " + piece[1] + " ";
    }


    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < 9 && y < 9;
    }
}
