package edu.hhu.liweijia.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    private static Properties druidProperties = new Properties();
    private static DataSource druidDataSource;

    static {
        try {
            druidProperties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            druidDataSource = DruidDataSourceFactory.createDataSource(druidProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Druid的数据源
     * @return Druid数据源对象
     */
    public static DataSource getDruidDataSource(){
        return druidDataSource;
    }

    /**
     * 释放资源
     * @param resultSet 结果集对象
     * @param statement 数据库操作对象
     * @param connection 数据库连接对象
     */
    public static void releaseResources(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
