package edu.hhu.liweijia.controller.admin;


import edu.hhu.liweijia.dao.UserDao;
import edu.hhu.liweijia.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user")
public class UserController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User user = userDao.queryByAccountAndPassword(account, password);
        //账号是admin，密码是123456
        if(user != null){
            //将当前登录成功的管理员放置在会话中以便使用
            //request.getSession().setAttribute("admin",admin);
            //发送视频列表请求
            response.sendRedirect("/front/login_success.jsp");
        }
        else{
            //将页面跳转到登录失败页面
            response.sendRedirect("/front/login_fail.jsp");
        }
    }
    //登录

}
