package exceptions_;

public class NegativeValueException extends Exception{

    public NegativeValueException(){

    }

    public NegativeValueException(String msg){
        super(msg);
    }
}
