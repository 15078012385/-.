package teamwork.com.mapper;

import teamwork.com.pojo.SystemLog;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class SystemLogMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加
    public static int insertOne(SystemLog systemLog) throws SQLException {
        String sql = "INSERT INTO tb_system_log ( access_url) VALUES ( ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, systemLog.getAccessUrl());
        return ps.execute() ? 0 : 1;
    }

    // 删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "DELETE FROM tb_system_log WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    // 更新
    public static int updateByOne(SystemLog systemLog) throws SQLException {
        String sql = "UPDATE tb_system_log SET access_time = ?, access_url = ?, created_at = ? WHERE id = ?";
        return JdbcUtils.executeUpdate(sql, systemLog.getAccessTime(), systemLog.getAccessUrl(), systemLog.getCreatedAt(), systemLog.getId());
    }

    // id查询
    public static SystemLog selectOneById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_system_log WHERE id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new SystemLog(rs.getInt("id"), rs.getTimestamp("access_time"), rs.getString("access_url"), rs.getTimestamp("created_at"));
        }
        return null;
    }

    // 分页模糊查询
    public static ArrayList<SystemLog> selectByAccessUrl(String accessUrl, int pageNum, int pageSize) throws SQLException {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_system_log WHERE access_url LIKE ?   LIMIT ?, ? ";
        ArrayList<SystemLog> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + accessUrl + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new SystemLog(rs.getInt("id"), rs.getTimestamp("access_time"), rs.getString("access_url"), rs.getTimestamp("created_at")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_system_log where access_url like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(selectOneById(3104));
    }

}
