package teamwork.com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
    // 数据库驱动名和数据库URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db-flower?serverTimezone=Asia/Shanghai";

    // 数据库用户名和密码
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // 使用 ThreadLocal 来维护数据库连接的线程隔离
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
//        踩坑一，正常来说8.0已经不需要手动加载驱动了，但是如果不加载驱动，会报错。
//        No suitable driver found for jdbc:mysql://localhost:3306/ 问题解决
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 先从 ThreadLocal 中获取连接
        Connection connection = connectionHolder.get();
        // 如果没有连接，则创建一个新连接，并将其保存到 ThreadLocal 中
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connectionHolder.set(connection);
        }
        return connection;
    }

    // 释放数据库连接
    public static void releaseConnection() {
        Connection connection = connectionHolder.get();
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 清空 ThreadLocal 中的连接
            connectionHolder.remove();
        }
    }

    // 执行 SQL 查询语句
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        System.out.println("执行的SQL语句为：\n" + ps.toString());
        return ps.executeQuery();
    }

    // 执行 SQL 更新语句
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        System.out.println("执行的SQL语句为：\n" + ps.toString());
        return ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
        System.out.println(getConnection() == getConnection());
    }

}
