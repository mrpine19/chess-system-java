package boardgame;

public class BoardException extends RuntimeException { //Sendo RuntimeException, a exceção vira opcional de ser tratada
    private static final long serialVersionUID = 1L;

    public BoardException(String msg){
        super(msg); //Manda a mensagem de erro para o construtor da super classe, a RuntimeException
    }
}
