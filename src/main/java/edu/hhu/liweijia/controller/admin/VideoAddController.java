package edu.hhu.liweijia.controller.admin;

import edu.hhu.liweijia.dao.VideoDao;
import edu.hhu.liweijia.entity.Video;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

@WebServlet("/admin/videoAdd")
public class VideoAddController extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private VideoDao videoDao = new VideoDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Video video = new Video();
        // 获得应用的真实目录
        String appPath = request.getServletContext().getRealPath("/");
        // 图片的上传目录
        File imageUploadDir = new File(appPath+"/images");
        if(!imageUploadDir.exists()){
            imageUploadDir.mkdir();
        }
        // 视频的上传目录
        File videoUploadDir = new File(appPath+"/videos");
        if(!videoUploadDir.exists()){
            videoUploadDir.mkdir();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
            for(FileItem item:items){
                // 如果是普通文本域
                if(item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(fieldName + " = " + value);
                    if (fieldName.equals("name")) {
                        video.setName(value);
                    }
                    if (fieldName.equals("typeId")) {
                        video.setTypeId(Integer.parseInt(value));
                    }
                    if (fieldName.equals("director")) {
                        video.setDirector(value);
                    }
                    if (fieldName.equals("roles")) {
                        video.setRoles(value);
                    }
                    if (fieldName.equals("minuteLength")) {
                        video.setMinuteLength(Integer.parseInt(value));
                    }
                    if (fieldName.equals("productDate")) {
                        Date date = sdf.parse(value);
                        video.setProductDate(date);
                    }
                    if (fieldName.equals("area")) {
                        video.setArea(value);
                    }
                    if (fieldName.equals("description")) {
                        video.setDescription(value);
                    }
                }
                if(!item.isFormField()){
                    String fieldName = item.getFieldName();

                    if(fieldName.equals("uploadFile1")){
                        String fileName = item.getName();
                        System.out.println("fileName = "+fileName);
                        // 获得文件的后缀名
                        String suffix = fileName.substring(fileName.lastIndexOf("."));
                        System.out.println("suffix = "+suffix);
                        // 生成上传文件名称
                        String uuid = UUID.randomUUID().toString();
                        String uploadFileName = imageUploadDir.getAbsolutePath() + "\\"+ uuid+suffix;
                        video.setImagePath(uuid+suffix);
                        System.out.println(" uploadFileName = "+uploadFileName);
                        // 获得输入流
                        InputStream is = item.getInputStream();
                        // 创建上传的输出流
                        OutputStream os = new FileOutputStream(uploadFileName);
                        // 开始上传
                        byte[] bytes = new byte[1024*4];
                        int length = 0;
                        while ((length=is.read(bytes))!=-1){
                            os.write(bytes,0,length);
                        }
                        is.close();
                        os.close();
                    }

                    if(fieldName.equals("uploadFile2")){
                        String fileName = item.getName();
                        System.out.println("fileName = "+fileName);
                        // 获得文件的后缀名
                        String suffix = fileName.substring(fileName.lastIndexOf("."));
                        System.out.println("suffix = "+suffix);
                        // 生成上传文件名称
                        String uuid = UUID.randomUUID().toString();
                        String uploadFileName = videoUploadDir.getAbsolutePath() + "\\"+ uuid+suffix;
                        video.setVideoPath(uuid+suffix);
                        System.out.println(" uploadFileName = "+uploadFileName);
                        // 获得输入流
                        InputStream is = item.getInputStream();
                        // 创建上传的输出流
                        OutputStream os = new FileOutputStream(uploadFileName);
                        // 开始上传
                        byte[] bytes = new byte[1024*4];
                        int length = 0;
                        while ((length=is.read(bytes))!=-1){
                            os.write(bytes,0,length);
                        }
                        is.close();
                        os.close();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        videoDao.add(video);

        response.sendRedirect("/admin/video?method=list");
    }
}
