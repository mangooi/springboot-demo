package club.mangooi.springboot.demo.exception;

public class RemoteAccessException extends BusinessException{
    public RemoteAccessException(String message) {
        super(message);
    }
}
