package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.entity.VideoType;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    public User queryByAccountAndPassword(String account, String password) {
        String sql=" select id,nick_name nickName,account,password "+
                " from t_user " +
                " where account=? and password=? ";
        Object[] paramObject = new Object[]{account, password};
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),paramObject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void add(User user){
        String sql ="insert into t_user(nick_name,account,password) values (?,?,?)";
        Object[] paramArray = new Object[]{
            user.getNickname(),user.getAccount(),user.getPassword()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User queryById(int id) {
        String sql=" select id,nick_name nickName,account,password "+
                " from t_user " +
                " where id=? ";
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}