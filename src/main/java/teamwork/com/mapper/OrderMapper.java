package teamwork.com.mapper;

import teamwork.com.pojo.Order;
import teamwork.com.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class OrderMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加
    public static int insertOne(Order order) throws SQLException {
        String sql = "INSERT INTO tb_order (user_id, product_id, quantity, total_price,product_name,nickname,address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, order.getUserId());
        ps.setObject(2, order.getProductId());
        ps.setObject(3, order.getQuantity());
        ps.setObject(4, order.getTotalPrice());
        ps.setObject(5, order.getProductName());
        ps.setObject(6, order.getNickname());
        ps.setObject(7, order.getAddress());
        return ps.execute() ? 0 : 1;
    }

    // 删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "DELETE FROM tb_order WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    // 更新
    public static int updateByOne(Order order) throws SQLException {
        String sql = "UPDATE tb_order SET user_id = ?, product_id = ?, quantity = ?, total_price = ?, order_date = ? ### , product_name = ?, nickname = ?, address = ? WHERE id = ?";
        return JdbcUtils.executeUpdate(sql, order.getUserId(), order.getProductId(), order.getQuantity(), order.getTotalPrice(), order.getOrderDate(),order.getProductName(),order.getNickname(),order.getAddress(), order.getId());
    }

    // id查询
    public static Order selectOneById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_order WHERE id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getInt("total_price"), rs.getTimestamp("order_date"),rs.getString("nickname"),rs.getString("product_name"),rs.getString("address"));
        }
        return null;
    }

    // 分页模糊查询
    public static ArrayList<Order> selectByNickname(String productId, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_order WHERE nickname LIKE ? LIMIT ?, ?";
        ArrayList<Order> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + productId + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getInt("total_price"), rs.getTimestamp("order_date"),rs.getString("nickname"),rs.getString("product_name"),rs.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_order where product_id like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(selectOneById(19));
    }


}
