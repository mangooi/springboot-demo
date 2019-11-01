package club.mangooi.springboot.demo.response;

import club.mangooi.springboot.demo.exception.BusinessException;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ExceptionResponse {
    private String code;
    private String message;
    private Object data;
    private Throwable cause;

    public ExceptionResponse(@NotNull BusinessException e){
        this.code = e.getCode();
        this.message = e.getMessage();
        this.data = e.getData();
        this.cause = e.getCause();
    }
}
