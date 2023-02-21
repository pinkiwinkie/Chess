package model;

import com.diogonunes.jcolor.Attribute;
import java.util.Set;
import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    protected Set<Coordinate> coordinates;
    private Type type;
    protected Cell cell;
    public Piece(Type type, Cell cell){
        this.cell = cell;
        this.type = type;
    }

    public Color getColor() {
        return type.color;
    }

    public Type getType() {
        return type;
    }

    public Cell getCell() {
        return cell;
    }

    public void putInYourPlace(){
        cell.setPiece(this);
    }

    public abstract Set<Coordinate> getNextMovements();

    protected void check(Coordinate coordinate, Set<Coordinate> coordinates){
        Board board = getCell().getBoard();

        if (board.getCell(coordinate) != null)
            if (board.getCell(coordinate).isEmpty() ||
                    board.getCell(coordinate).getPiece().getColor() != getColor())
                coordinates.add(coordinate);
    }
    public void moveTo(Coordinate c){
        Board board = getCell().getBoard();
        //Check whether cell exists
        if(board.getCell(c) != null) {
            getCell().setPiece(null);
            Cell cell = board.getCell(c);
            cell.setPiece(this);
            this.cell = cell;
        }
    }
    @Override
    public String toString(){
        return colorize(type.toString(),type.color.getPieceColor(),cell.getColor().getAttribute());
    }
    public enum Color {
        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));

        private final Attribute pieceColor;

        Color(Attribute color) {
            this.pieceColor = color;
        }

        public Attribute getPieceColor() {
            return pieceColor;
        }

        public Color nextColor(){
            if (this.equals(BLACK))
                return WHITE;
            else
                return BLACK;
        }
    }

    public enum Type {
        WHITE_KING("♚", Color.WHITE),
        WHITE_QUEEN("♛", Color.WHITE),
        WHITE_ROOK("♜", Color.WHITE),
        WHITE_BISHOP("♝", Color.WHITE),
        WHITE_KNIGHT("♞", Color.WHITE),
        WHITE_PAWN("♟", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK);

        private String shape;
        private Color color;

        Type(String shape, Color color){
            this.shape = shape;
            this.color = color;
        }

        public String getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return String.valueOf(shape);
        }
    }
}
