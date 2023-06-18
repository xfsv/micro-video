package edu.hhu.liweijia.controller.admin;

import edu.hhu.liweijia.dao.AdminDao;
import edu.hhu.liweijia.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/admin")

public class AdminController extends HttpServlet {

    private AdminDao adminDao = new AdminDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("login")){
            login(request, response);
        }
        if(method.equals("logout")){
            logout(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Admin admin = adminDao.queryByAccountAndPassword(account, password);
        //账号是admin，密码是123456
        if(admin != null){
            //将当前登录成功的管理员放置在会话中以便使用
            request.getSession().setAttribute("admin",admin);
            //发送视频列表请求
            response.sendRedirect("/admin/videoType?method=list");
        }
        else{
            //将页面跳转到登录失败页面
            response.sendRedirect("/admin/login_fail.jsp");
        }
    }
    //登录

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/admin/login.jsp");
    }
    //注销
}