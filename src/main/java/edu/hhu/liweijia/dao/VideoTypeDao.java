package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.VideoType;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class VideoTypeDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    public void update(VideoType videoType){
        String sql = " update t_video_type set name=?,description=? where id=? ";
        Object[] paramArray = new Object[]{
                videoType.getName(),videoType.getDescription(),videoType.getId()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(VideoType videoType){
        String sql = " insert into t_video_type(name,description) values (?,?) ";
        Object[] paramArray = new Object[]{
                videoType.getName(),videoType.getDescription()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id){
        String sql = " delete from t_video_type where id=? ";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public VideoType queryById(int id){
        String sql = " select id,name,description from t_video_type where id=? ";
        VideoType videoType = null;
        try {
            videoType = queryRunner.query(sql, new BeanHandler<>(VideoType.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videoType;
    }

    public List<VideoType> list(){
        String sql = " select id,name,description from t_video_type ";
        List<VideoType> videoTypeList = null;
        try {
            videoTypeList = queryRunner.query(sql, new BeanListHandler<>(VideoType.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videoTypeList;
    }


}
