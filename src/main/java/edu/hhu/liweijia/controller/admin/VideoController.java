package edu.hhu.liweijia.controller.admin;

import edu.hhu.liweijia.dao.VideoDao;
import edu.hhu.liweijia.dao.VideoTypeDao;
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

@WebServlet("/admin/video")
public class VideoController extends HttpServlet{

    private VideoTypeDao videoTypeDao = new VideoTypeDao();
    private VideoDao videoDao = new VideoDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if(method.equals("toAdd")){
            toAdd(request,response);
        }

        if(method.equals("remove")){
            remove(request,response);
        }

        if(method.equals("toDetail")){
            toDetail(request,response);
        }

        if(method.equals("list")){
            list(request,response);
        }

        if(method.equals("toModify")){
            toModify(request,response);
        }

        if(method.equals("modify")){
            modify(request,response);
        }

    }

    //去添加视频
    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<VideoType> videoTypeList = videoTypeDao.list();
        request.setAttribute("videoTypeList",videoTypeList);
        request.getRequestDispatcher("/admin/video_add.jsp").forward(request,response);
    }

    //视频列表
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> videoList = videoDao.list();
        request.setAttribute("videoList",videoList);
        request.getRequestDispatcher("/admin/video_list.jsp").forward(request,response);
    }

    //视频明细
    protected void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoDao.queryById(id);
        request.setAttribute("video",video);
        VideoType videoType = videoTypeDao.queryById(video.getTypeId());
        request.setAttribute("videoType",videoType);
        request.getRequestDispatcher("/admin/video_detail.jsp").forward(request,response);
    }

    //去修改视频信息
    protected void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoDao.queryById(id);
        request.setAttribute("video",video);
        VideoType videoType = videoTypeDao.queryById(video.getTypeId());
        request.setAttribute("videoType",videoType);
        List<VideoType> videoTypeList = videoTypeDao.list();
        request.setAttribute("videoTypeList",videoTypeList);
        request.getRequestDispatcher("/admin/video_modify.jsp").forward(request,response);
    }
    //修改视频
    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String typeId = request.getParameter("typeId");
        String productDate = request.getParameter("productDate");
        String description = request.getParameter("description");
        Video video = new Video();
        video.setId(id);
        video.setName(name);
        video.setTypeId(Integer.parseInt(typeId));
        Date date = null;
        try {
            date = sdf.parse(productDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        video.setProductDate(date);
        video.setDescription(description);
        videoDao.update(video);
        response.sendRedirect("/admin/video?method=list");
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Video video = videoDao.queryById(id);
        String appPath = request.getServletContext().getRealPath("/");
        // 图片的上传目录
        File imageUploadDir = new File(appPath+"/images");
        File imageFile = new File(imageUploadDir,video.getImagePath());
        imageFile.delete();
        // 视频的上传目录
        File videoUploadDir = new File(appPath+"/videos");
        File videoFile = new File(videoUploadDir,video.getVideoPath());
        videoFile.delete();
        videoDao.remove(id);
        request.getRequestDispatcher("/admin/video?method=list").forward(request,response);
    }


}
