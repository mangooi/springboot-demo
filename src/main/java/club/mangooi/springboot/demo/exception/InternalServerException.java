package club.mangooi.springboot.demo.exception;

public class InternalServerException extends BusinessException{
    public InternalServerException(String message) {
        super(message);
    }
}
