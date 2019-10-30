package club.mangooi.springboot.demo.response;

import club.mangooi.springboot.demo.exception.BusinessException;
import lombok.Data;

@Data
public class ExceptionResponse {

    private Throwable cause;
    private String code;
    private String message;
    private Object data;

    public ExceptionResponse(BusinessException e){
        this.cause = e.getCause();
        this.code = e.getCode();
        this.message = e.getMessage();
        this.data = e.getData();
    }
}
