package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.History;
import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.entity.VideoType;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class HistoryDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    public List<History> list(int id){

        String sql =" select id,video_id videoId,video_name videoName,watch_date watchTime,image_path imagePath,video_path videoPath" +
                " from t_history "+
                "where user_id=?";
        List<History> videoList = null;
        try {
            videoList = queryRunner.query(sql,new BeanListHandler<>(History.class), id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return videoList;
    }

    public void update(User user, Video video, Date date){
        String sql = " insert into  t_history(video_name,video_id,user_name,user_id,watch_date,image_path,video_path)" +
                "values(?,?,?,?,?,?,?) ";
        Object[] paramArray = new Object[]{
                video.getName(),video.getId(),user.getNickName(),user.getId(),date,video.getImagePath(),
                video.getVideoPath()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id){
        String sql = " delete from t_history where id=?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public History queryByUserId(int id){
        String sql = " select id" +
                " from t_history where user_id=? ";
        History history = null;
        try {
            history = queryRunner.query(sql,new BeanHandler<>(History.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return history;
    }

}