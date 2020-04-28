package exceptions_;

public class NewArithmeticException extends ArithmeticException {
    public NewArithmeticException(){

    }

    public NewArithmeticException(String msg){
        super(msg);
    }
}
