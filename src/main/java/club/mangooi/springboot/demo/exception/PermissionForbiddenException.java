package club.mangooi.springboot.demo.exception;

public class PermissionForbiddenException extends BusinessException{
    public PermissionForbiddenException(String message) {
        super(message);
    }
}
