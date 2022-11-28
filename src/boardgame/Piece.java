package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        //this.position = null; Por padrão isso já está acontecendo
    }

    protected Board getBoard() {
        return board;
    }
    //SEM O SET, JÁ QUE O TABULEIRO É USO INTERNO
    //POR ISO 'BOARD' É PROTECTED
}
