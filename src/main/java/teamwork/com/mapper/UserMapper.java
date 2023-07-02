package teamwork.com.mapper;

import teamwork.com.pojo.User;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加
    public static int insertOne(User user) throws SQLException {
        String sql = "INSERT INTO tb_user (username, password, nickname, phone, identity) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, user.getUsername());
        ps.setObject(2, user.getPassword());
        ps.setObject(3, user.getNickname());
        ps.setObject(4, user.getPhone());
        ps.setObject(5, user.getIdentity());
        return ps.execute() ? 0 : 1;
    }

    // 删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "DELETE FROM tb_user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    // 更新
    public static int updateByOne(User user) throws SQLException {
        String sql = "UPDATE tb_user SET username = ?, password = ?, nickname = ?, phone = ?, identity = ? WHERE id = ?";
        return JdbcUtils.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getPhone(), user.getIdentity(), user.getId());
    }

    // id查询
    public static User selectOneById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_user WHERE id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nickname"), rs.getString("phone"), rs.getString("identity"));
        }
        return null;
    }

    // 分页模糊查询
    public static ArrayList<User> selectByNickname(String nickname, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_user WHERE nickname LIKE ? LIMIT ?, ?";
        ArrayList<User> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + nickname + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nickname"), rs.getString("phone"), rs.getString("identity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //    统计记录数
    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_user where nickname like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static int login(String username, String password) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_user WHERE username = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, username);
        ps.setObject(2, password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getRecords("T"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
