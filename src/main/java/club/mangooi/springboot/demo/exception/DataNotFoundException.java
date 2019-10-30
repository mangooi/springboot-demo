package club.mangooi.springboot.demo.exception;

public class DataNotFoundException extends BusinessException{
    public DataNotFoundException(Object data){
        super(data);
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
