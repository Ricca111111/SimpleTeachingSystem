package com.hrk.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
@Component
public class LoginInterceptor implements HandlerInterceptor {
static final List<String> EXCLUDE_PATHS = Arrays.asList(
        "/5.22作业/register.html",
        "/5.22作业/login.html",
        "/stud/update",
        "/stud/add",
        "/stud/delete",
        "/stud/search",
        "/stud/get",
        "/user/register" // 注意这里应该是"/user/register"而不是"/user/regist"
);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        // 检查是否在排除列表中
        if (EXCLUDE_PATHS.stream().anyMatch(path -> requestURI.endsWith(path))) {
            return true; // 如果是排除的路径，则不拦截
        }
        // 检查用户是否已登录
        Object user = request.getSession().getAttribute("login_user");
        if (user == null) {
            // 如果用户未登录且不是登录或注册页面，则重定向到登录页面
            response.sendRedirect("/0522stu/login.html");
            return false; // 停止处理，因为已经重定向到登录页面
        }
        // 用户已登录，继续处理请求
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        //执行controller之后调用此方法，
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        //本次请求完全结束后调用此方法
    }
}

