package com.bjpowernode.crm.web.filter;

import com.bjpowernode.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        System.out.println("进入到有没有验证过的登陆器");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = request.getServletPath();
        System.out.println(path);
        //不应该拦截的资源自动放行
        if ("/login.do".equals(path)||"/settings/user/login.do".equals(path)||"/login.jsp".equals(path)){

            chain.doFilter(req,res);
         //其他资源必须验证有没有登录过
        }else{
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");

            //如果user不为空，说明登陆过
            if (user != null){
                chain.doFilter(req,res);
            }else{
                //重定向登录页面
                /*
                 *   重定向的路径怎么写？
                 *   在实际项目开发中，对于路径的使用，不论操作的是前端还是后端，应该一律使用绝对路径
                 *   关于转发和重定向的路径写法如下：
                 *       转发：
                 *           使用的是特殊的绝对路径的方式，这种绝对路径前面不加/项目名，这种路径也称之为内部路径
                 *           /login.jsp
                 *       重定向：
                 *           使用的是传统的写法，前面必须以/项目名开头，后面跟具体的资源路径
                 *           /crm/login.jsp
                 *
                 *   为什么使用重定向，使用转发不行吗?
                 *       转发之后路径会停留在老路径上，而不是跳转之后最新资源路径
                 *       我们应该在为用户跳转到登录页的同时，将浏览器的地址栏应该自动设置为当前的登录页的路径
                 *
                 *   $(pageContext.request.contextPath)/项目名
                 * */
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }
}
