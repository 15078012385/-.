package teamwork.com.mapper;

import teamwork.com.pojo.Address;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressMapper {
//    private static Connection connection = null;
//
//    static {
//        try {
//            connection = JdbcUtils.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //  添加
    public static int insertOne(Address address) throws SQLException {
        String sql = "insert into tb_address (user_id, recipient_name, address, phone) values (?, ?, ?, ?)";
        PreparedStatement ps = JdbcUtils.getConnection().prepareStatement(sql);
        ps.setObject(1, address.getUserId());
        ps.setObject(2, address.getRecipientName());
        ps.setObject(3, address.getAddress());
        ps.setObject(4, address.getPhone());
        return ps.execute() ? 0 : 1;
    }

    //    删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "delete from tb_address where id = ?";
        PreparedStatement ps = JdbcUtils.getConnection().prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    //  更新
    public static int updateByOne(Address address) throws SQLException {
        String sql = "update tb_address set user_id = ?, recipient_name = ?, address = ?, phone = ? where id = ?";
        return JdbcUtils.executeUpdate(sql, address.getUserId(), address.getRecipientName(), address.getAddress(), address.getPhone(), address.getId());
    }

    //    id查询
    public static Address selectOneById(int id) throws SQLException {
        String sql = "select * from tb_address where id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new Address(rs.getInt("id"), rs.getInt("user_id"), rs.getString("recipient_name"), rs.getString("address"), rs.getString("phone"));
        }
        return null;
    }

    //    这里需要指定查询参数
    public static ArrayList<Address> selectByAddress(String address, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_address WHERE address LIKE ? LIMIT ?, ?";
        ArrayList<Address> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + address + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new Address(rs.getInt("id"), rs.getInt("user_id"), rs.getString("recipient_name"), rs.getString("address"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_address where address like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = JdbcUtils.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getRecords(""));
    }
}
