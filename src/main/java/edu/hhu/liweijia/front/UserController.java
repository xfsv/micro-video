package edu.hhu.liweijia.front;


import edu.hhu.liweijia.dao.UserDao;
import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.VideoType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/front/user")
public class UserController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("login")){
            login(request, response);
        }

        if(method.equals("logout")){
            logout(request, response);
        }

        if(method.equals("toSignIn")){
            toSignIn(request,response);
        }

        if(method.equals("signIn")){
            signIn(request,response);
        }

    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User user = userDao.queryByAccountAndPassword(account, password);
        //账号是admin，密码是123456
        if(user != null){
            //将当前登录成功的用户放置在会话中以便使用
            request.getSession().setAttribute("user",user);
            //发送视频列表请求
            response.sendRedirect("/front/video?method=list");
        }
        else{
            //将页面跳转到登录失败页面
            response.sendRedirect("/front/login_fail.jsp");
        }
    }
    //登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/front/login.jsp");
    }
    //注销

    protected void toSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/front/user_signIn.jsp");
    }
    //注册

    protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User user = new User();
        user.setNickname(name);
        user.setAccount(account);
        user.setPassword(password);
        userDao.add(user);
        //重新将页面跳转到视频类型列表页面
        response.sendRedirect("/front/login.jsp");
    }
}
