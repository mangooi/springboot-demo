package club.mangooi.springboot.demo.config;

import club.mangooi.springboot.demo.exception.BusinessException;
import club.mangooi.springboot.demo.response.ExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BusinessExceptionHandle {
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ExceptionResponse handle(BusinessException e){
            return new ExceptionResponse(e);
    }
}
