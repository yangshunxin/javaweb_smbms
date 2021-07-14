package org.sample.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sample.pojo.User;
import org.sample.service.user.UserServiceImpl;
import org.sample.util.Constants;

import java.io.IOException;

/**
 * @author yangshunxin
 * @create 2021-07-07-15:54
 */
public class LoginServlet extends HttpServlet {

    // servlet: 控制层调用 业务层代码


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet start------");

        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 和数据库中的 密码进行对比， 调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if (user!=null){// 查有此人
            // 将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);

            // 登陆成功 跳到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else { //查无此人
            // 转发回登陆页面，并提示无此人或密码错误
            req.setAttribute("error", "用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
