package edu.hhu.liweijia.controller.admin;

import edu.hhu.liweijia.dao.VideoTypeDao;
import edu.hhu.liweijia.entity.VideoType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/videoType")
public class VideoTypeController extends HttpServlet {

    private VideoTypeDao videoTypeDao = new VideoTypeDao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改请求参数字符集编码
        request.setCharacterEncoding("UTF-8");

        String method = request.getParameter("method");
        //去添加视频类型页面
        if(method.equals("toAdd")){
            toAdd(request,response);
        }
        //添加视频类型业务
        if(method.equals("add")){
            add(request,response);
        }

        //删除视频类型业务
        if(method.equals("remove")){
            remove(request,response);
        }

        //修改视频类型业务
        if(method.equals("modify")){
            modify(request,response);
        }

        //查询所有视频类型
        if(method.equals("list")){
            list(request,response);
        }

        //去视频类型明细页面
        if(method.equals("toDetail")){
            toDetail(request,response);
        }
        //去视频类型修改页面
        if(method.equals("toModify")){
            toModify(request,response);
        }
    }

    //视频类型列表
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<VideoType> videoTypeList = videoTypeDao.list();
        request.setAttribute("videoTypeList",videoTypeList);
        request.getRequestDispatcher("/admin/video_type_list.jsp").forward(request,response);

    }

    //去添加视频页面
    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("/admin/video_type_add.jsp");
    }

    //添加视频类型业务
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        VideoType videoType = new VideoType();
        videoType.setName(name);
        videoType.setDescription(description);
        videoTypeDao.add(videoType);
        //重新将页面跳转到视频类型列表页面
        response.sendRedirect("/admin/videoType?method=list");
    }

    //去视频明细页面
    protected void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VideoType videoType = videoTypeDao.queryById(id);
        request.setAttribute("videoType",videoType);
        request.getRequestDispatcher("/admin/video_type_detail.jsp").forward(request,response);
    }

    //去视频类型修改页面
    protected void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VideoType videoType = videoTypeDao.queryById(id);
        request.setAttribute("videoType",videoType);
        request.getRequestDispatcher("/admin/video_type_modify.jsp").forward(request,response);
    }

    //视频类型修改业务
    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        VideoType videoType = new VideoType();
        videoType.setName(name);
        videoType.setId(id);
        videoType.setDescription(description);
        videoTypeDao.update(videoType);
        //重新将页面跳转到视频类型列表页面
        response.sendRedirect("/admin/videoType?method=list");
    }

    //删除视频类型业务
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        videoTypeDao.remove(id);
        response.sendRedirect("/admin/videoType?method=list");
    }
}
