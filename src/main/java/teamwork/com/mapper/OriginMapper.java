package teamwork.com.mapper;

import teamwork.com.pojo.Origin;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OriginMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertOne(Origin origin) throws SQLException {
        String sql = "insert into tb_origin (origin_name) values (?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, origin.getOriginName());
        return ps.execute() ? 1 : 0;
    }

    public static int deleteOneById(int id) throws SQLException {
        String sql = "delete from tb_origin where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 1 : 0;
    }

    public static int updateByOne(Origin origin) throws SQLException {
        String sql = "update tb_origin set origin_name = ? where id = ?";
        return JdbcUtils.executeUpdate(sql, origin.getOriginName(), origin.getId());
    }

    //    id查询
    public static Origin selectOneById(int id) throws SQLException {
        String sql = "select * from tb_origin where id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new Origin(rs.getInt("id"), rs.getString("origin_name"));
        }
        return null;
    }

    //   分页查询
    public static ArrayList<Origin> selectByPage(Integer pageNum, Integer pageSize, String param) {
        int currentPage = pageNum; // 当前页码
        int offset = (currentPage - 1) * pageSize; // 查询结果的偏移量
        param = "%" + param + "%";
        String sql = "select * from tb_origin where origin_name like ? limit ?,?";
        ArrayList<Origin> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, param, offset, pageSize);
            while (rs.next()) {
                list.add(new Origin(rs.getInt("id"), rs.getString("origin_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_origin where origin_name like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

}
