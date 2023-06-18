package edu.hhu.liweijia.dao;

import edu.hhu.liweijia.entity.Admin;
import edu.hhu.liweijia.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    public Admin queryByAccountAndPassword(String account, String password) {
        String sql=" select id,nick_name nickName,account,password "+
                    " from t_admin " +
                    " where account=? and password=? ";
        Object[] paramObject = new Object[]{account, password};
        Admin admin = null;
        try {
            admin = queryRunner.query(sql,new BeanHandler<>(Admin.class),paramObject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }

}
