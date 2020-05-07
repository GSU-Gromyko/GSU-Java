package exceptions_;

public class MyArithmeticException extends ArithmeticException {
    public MyArithmeticException(){

    }

    public MyArithmeticException(String msg){
        super(msg);
    }
}
