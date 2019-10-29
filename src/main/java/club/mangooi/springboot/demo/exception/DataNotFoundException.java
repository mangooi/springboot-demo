package club.mangooi.springboot.demo.exception;

public class DataNotFoundException extends BusinessException{
    public DataNotFoundException(String message) {
        super(message);
    }
}
