package edu.hhu.liweijia.front;

import edu.hhu.liweijia.dao.HistoryDao;
import edu.hhu.liweijia.dao.UserDao;
import edu.hhu.liweijia.dao.VideoDao;
import edu.hhu.liweijia.dao.VideoTypeDao;
import edu.hhu.liweijia.entity.History;
import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.entity.VideoType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/front/history")
public class HistoryController extends HttpServlet{

    private VideoTypeDao videoTypeDao = new VideoTypeDao();
    private VideoDao videoDao = new VideoDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private UserDao userDao = new UserDao();
    private HistoryDao historyDao = new HistoryDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");


        if(method.equals("historyList")){
            historyList(request,response);
        }
        if(method.equals("remove")){
            remove(request,response);
        }
    }

    protected void historyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        int id = user.getId();
        List<History> historyList = historyDao.list(id);

        request.setAttribute("historyList",historyList);
        request.getRequestDispatcher("/front/video_history_list.jsp").forward(request,response);
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        historyDao.remove(id);
        response.sendRedirect("/front/history?method=historyList");
    }

}