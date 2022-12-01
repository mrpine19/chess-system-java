package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: é necessário que haja, pelo menos, 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    //SOBRE OS GET'S E SET'S: NÃO FAZ SENTIDO TER OS SET'S DA LINHA E COLUNA POIS NÃO É NECESSÁRIO MUDAR O TAMANHO DO TABULEIRO
    public int getRow() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //ACESSA UMA PEÇA EM UMA DETERMINADA POSIÇÃO
    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("A posição não está no tabuleiro");
        }
        return pieces[row][column];
    }

    //ACESSA UMA PEÇA EM UMA DETERMINADA POSIÇÃO
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("A posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    //MUDA A POSIÇÃO DE UMA PEÇA
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça na posição "+position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //MÉTODO QUE VERIFICA SE UMA POSIÇÃO EXISTE OU NÃO
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    //MÉTODO QUE VERIFICA SE EXISTE UMA PEÇA NA POSIÇÃO INDICADA
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("A posição não está no tabuleiro");
        }
        return piece(position) != null;
    }

}
