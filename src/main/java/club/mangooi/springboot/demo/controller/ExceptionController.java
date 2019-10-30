package club.mangooi.springboot.demo.controller;

import club.mangooi.springboot.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/exception")
public class ExceptionController {
    @RequestMapping()
    public String index(){
        throw new BusinessException();
    }
}
