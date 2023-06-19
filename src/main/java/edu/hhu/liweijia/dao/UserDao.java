package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.User;
import edu.hhu.liweijia.entity.Video;
import edu.hhu.liweijia.entity.VideoType;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public User queryByNameOrAccount(String name, String account) {
        String sql=" select id,nick_name nickName,account,password "+
                " from t_user " +
                " where nick_name=? or account=? ";
        Object[] paramObject = new Object[]{name, account};
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),paramObject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User queryById(int id) {
        String sql=" select id,nick_name nickName,account,password "+
                " from t_user " +
                " where id=?";
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void add(User user){
        String sql ="insert into t_user(nick_name,account,password) values (?,?,?)";
        Object[] paramArray = new Object[]{
            user.getNickName(),user.getAccount(),user.getPassword()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> list(){
        String sql = " select id,nick_name nickName,account,password from t_user";
        List<User> user = null;
        try {
            user = queryRunner.query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void remove(int id){
        String sql = " delete from t_user where id=? ";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user){
        String sql = " update t_user set nick_name=?,account=?,password=? where id=? ";
        Object[] paramArray = new Object[]{
                user.getNickName(),user.getAccount(),user.getPassword(),user.getId()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}