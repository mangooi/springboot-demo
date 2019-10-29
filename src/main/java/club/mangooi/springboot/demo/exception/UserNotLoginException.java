package club.mangooi.springboot.demo.exception;

public class UserNotLoginException extends BusinessException{
    public UserNotLoginException(String message) {
        super(message);
    }
}
