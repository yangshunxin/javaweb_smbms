package org.sample.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sample.pojo.User;
import org.sample.util.Constants;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;

/**
 * @author yangshunxin
 * @create 2021-07-07-16:41
 */
public class SysFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("SysFilter doFilter()===========");
        HttpServletRequest rq = (HttpServletRequest)request;
        HttpServletResponse rp = (HttpServletResponse)response;
        User userSession = (User)rq.getSession().getAttribute("userSession");
        if(null == userSession){
            rp.sendRedirect(rq.getContextPath()+"/error.jsp");
        }else{
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    public void destroy() {
//        Filter.super.destroy();
    }
}
