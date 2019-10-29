package club.mangooi.springboot.demo.exception;

public class DataConflictException extends BusinessException{
    public DataConflictException(String message) {
        super(message);
    }
}
