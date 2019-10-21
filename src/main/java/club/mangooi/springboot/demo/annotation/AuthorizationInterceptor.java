package club.mangooi.springboot.demo.annotation;

import club.mangooi.springboot.demo.utils.Constants;
import club.mangooi.springboot.demo.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("AuthorizationInterceptor.preHandle(...)");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(Authorization.class) == null) {
            String currentUser = request.getParameter(Constants.CURRENT_USER);
            String tokenValue = request.getParameter(Constants.TOKEN_VALUE);
            if (currentUser == null || tokenValue == null) {
                System.out.println("Null Error");
                return false;
            }
            if (!TokenUtil.check(currentUser, tokenValue)) {
                System.out.println("Check Error");
                return false;
            }
        }
        return true;
    }


}
