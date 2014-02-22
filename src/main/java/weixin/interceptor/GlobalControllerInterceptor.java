package weixin.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangcaiyi on 14-2-19.
 */
public class GlobalControllerInterceptor extends HandlerInterceptorAdapter {

    @Override
    //调用controller某method前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println("________________________________");
        System.out.println(handlerMethod.getBeanType().getName());//得到controller类名
        System.out.println(handlerMethod.getMethod());//得到处理该请求的controller方法名

        System.out.println(handlerMethod.getBean());
        return true;
//      return super.preHandle(request, response, handler);
    }

    @Override
    //调用controller某method后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    //请求完成后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
