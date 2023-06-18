package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class VideoDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    public List<Video> list(){
        String sql =" select id,name,director,roles,minute_length minuteLength,product_date productDate,area," +
                    "description,type_id typeId,image_path imagePath,video_path videoPath" +
                    " from t_video ";
        List<Video> videoList = null;
        try {
            videoList = queryRunner.query(sql,new BeanListHandler<>(Video.class));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return videoList;
    }

    public void add(Video video){
        String sql =" insert into t_video(name,director,roles,minute_length,product_date,area,description,type_id,image_path,video_path)"+
                    "values (?,?,?,?,?,?,?,?,?,?) ";
        Object[] paramArray = new Object[]{
                video.getName(),video.getDirector(),video.getRoles(),video.getMinuteLength(),video.getProductDate(),
                video.getArea(),video.getDescription(),video.getTypeId(),video.getImagePath(),video.getVideoPath()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Video queryById(int id){
        String sql = " select id,name,director,roles,minute_length minuteLength,product_date productDate,area," +
                "description,type_id typeId,image_path imagePath,video_path videoPath" +
                " from t_video "+
                "where id=? ";
        Video video = null;
        try {
            video = queryRunner.query(sql,new BeanHandler<>(Video.class),id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return video;
    }

    public void update(Video video){
        String sql = " update t_video set name=?,type_id=?,product_date=?,description=? where id=? ";
        Object[] paramArray = new Object[]{
                video.getName(),video.getTypeId(),video.getProductDate(),video.getDescription(),video.getId()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id){
        String sql = " delete from t_video where id=?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
