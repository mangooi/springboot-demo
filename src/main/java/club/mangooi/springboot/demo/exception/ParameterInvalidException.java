package club.mangooi.springboot.demo.exception;

public class ParameterInvalidException extends BusinessException{
    public ParameterInvalidException(String message) {
        super(message);
    }
}
