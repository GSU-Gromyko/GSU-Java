package exceptions_;

public class EmptyArrayException extends Exception {
    public EmptyArrayException(){

    }

    public EmptyArrayException(String msg){
        super(msg);
    }
}
