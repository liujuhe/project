package com.bjpowernode.crm.web.filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入到过滤字符编码的过滤器");

        //过滤post请求中文参数乱码
        request.setCharacterEncoding("utf-8");

        //过滤相应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //将请求放行
        chain.doFilter(request,response);
    }
}
