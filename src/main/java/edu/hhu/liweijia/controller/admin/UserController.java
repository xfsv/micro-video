package edu.hhu.liweijia.controller.admin;


import edu.hhu.liweijia.dao.HistoryDao;
import edu.hhu.liweijia.dao.UserDao;
import edu.hhu.liweijia.entity.History;
import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.entity.VideoType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/user")
public class UserController extends HttpServlet {

    private UserDao userDao = new UserDao();
    private HistoryDao historyDao = new HistoryDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if(method.equals("list")){
            list(request,response);
        }

        if(method.equals("remove")){
            remove(request,response);
        }

        if(method.equals("toModify")){
            toModify(request, response);
        }

        if(method.equals("modify")){
            modify(request, response);
        }

        if(method.equals("toDetail")){
            toDetail(request,response);
        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userDao.list();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/admin/user_list.jsp").forward(request,response);
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        History history = historyDao.queryByUserId(id);
        if(history != null)
            historyDao.remove(history.getId());
        userDao.remove(id);
        response.sendRedirect("/admin/user?method=list");
    }

    protected void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.queryById(id);
        request.setAttribute("user",user);
        List<User> userList = userDao.list();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/admin/user_modify.jsp").forward(request,response);
    }

    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String nickName = request.getParameter("name");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setNickName(nickName);
        user.setAccount(account);
        user.setPassword(password);
        userDao.update(user);
        response.sendRedirect("/admin/user?method=list");
    }

    protected void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.queryById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/admin/user_detail.jsp").forward(request,response);
    }
}
