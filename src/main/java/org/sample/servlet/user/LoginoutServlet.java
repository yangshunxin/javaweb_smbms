package org.sample.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sample.util.Constants;

import java.io.IOException;

/**
 * @author yangshunxin
 * @create 2021-07-07-16:32
 */
public class LoginoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 移除用户的session
        req.getSession().removeAttribute(Constants.USER_SESSION);
//        resp.sendRedirect("/login.jsp"); // 返回登陆页面
//        resp.sendRedirect(req.getContextPath()+"/login.jsp"); // 返回登陆页面
        resp.sendRedirect("/login.jsp"); // 返回登陆页面

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
