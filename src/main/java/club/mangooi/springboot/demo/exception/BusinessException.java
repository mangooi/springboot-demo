package club.mangooi.springboot.demo.exception;

import club.mangooi.springboot.demo.enums.ExceptionEnum;
import club.mangooi.springboot.demo.enums.ResultCode;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class BusinessException extends RuntimeException{
    protected String code;
    protected String message;
    protected ResultCode resultCode;
    protected Object data;

    public BusinessException(){
        ExceptionEnum exceptionEnum = ExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum !=null){
            resultCode = exceptionEnum.getResultCode();
            code = String.valueOf(exceptionEnum.getResultCode().getCode());
            message = exceptionEnum.getResultCode().getMessage();
        }
    }

    public BusinessException(String message){
        this();
        this.message = message;
    }

    public BusinessException(ResultCode resultCode){
        this.resultCode = resultCode;
        this.code = String.valueOf(resultCode.getCode());
        this.message = resultCode.getMessage();
    }

    public BusinessException(ResultCode resultCode,Object object){
        this(resultCode);
        this.data = object;
    }

    public BusinessException(String format, Object... objects) {
        this();
        format = StringUtils.replace(format, "{}", "%s");
        this.message = String.format(format, objects);
    }
}
