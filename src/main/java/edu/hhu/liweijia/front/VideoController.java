package edu.hhu.liweijia.front;

import edu.hhu.liweijia.dao.UserDao;
import edu.hhu.liweijia.dao.VideoDao;
import edu.hhu.liweijia.dao.VideoTypeDao;
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

@WebServlet("/front/video")
public class VideoController extends HttpServlet{

    private VideoTypeDao videoTypeDao = new VideoTypeDao();
    private VideoDao videoDao = new VideoDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private UserDao userDao = new UserDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");


        if(method.equals("toDetail")){
            toDetail(request,response);
        }

        if(method.equals("toShow")){
            toShow(request,response);
        }

        if(method.equals("list")){
            list(request,response);
        }

    }

    //视频列表
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> videoList = videoDao.list();
        request.setAttribute("videoList",videoList);
        request.getRequestDispatcher("/front/video_list.jsp").forward(request,response);
    }

    //视频明细
    protected void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoDao.queryById(id);
        request.setAttribute("video",video);
        VideoType videoType = videoTypeDao.queryById(video.getTypeId());
        request.setAttribute("videoType",videoType);
        request.getRequestDispatcher("/front/video_detail.jsp").forward(request,response);
    }

    //视频明细
    protected void toShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoDao.queryById(id);
//        user = userDao.queryById();

        User user = (User)request.getSession().getAttribute("user");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
//        System.out.println((String) username);
        userDao.update(user,video,date);

        request.setAttribute("video",video);


        request.getRequestDispatcher("/front/video_show.jsp").forward(request,response);
    }

}