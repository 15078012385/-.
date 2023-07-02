package teamwork.com.mapper;

import teamwork.com.pojo.Product;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加
    public static int insertOne(Product product) throws SQLException {
        String sql = "INSERT INTO tb_product (product_name, price, category_id,product_category,origin) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, product.getProductName());
        ps.setObject(2, product.getPrice());
        ps.setObject(3, product.getCategoryId());
        ps.setObject(4, product.getProductCategory());
        ps.setObject(5, product.getOrigin());
        return ps.execute() ? 0 : 1;
    }

    // 删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "DELETE FROM tb_product WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    // 更新
    public static int updateByOne(Product product) throws SQLException {
        String sql = "UPDATE tb_product SET product_name = ?, price = ?, category_id = ? , product_category = ? , origin = ? WHERE id = ?";
        return JdbcUtils.executeUpdate(sql, product.getProductName(), product.getPrice(), product.getCategoryId(), product.getProductName(), product.getOrigin(), product.getId());
    }

    // id查询
    public static Product selectOneById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_product WHERE id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new Product(rs.getInt("id"), rs.getString("product_name"), rs.getInt("price"), rs.getString("product_category"), rs.getString("origin"), rs.getInt("category_id"));
        }
        return null;
    }

    // 分页模糊查询
    public static ArrayList<Product> selectByProductName(String productName, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_product WHERE product_name LIKE ? LIMIT ?, ?";
        ArrayList<Product> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + productName + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("product_name"), rs.getInt("price"), rs.getString("product_category"), rs.getString("origin"), rs.getInt("category_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_product where product_name like '%" + param + "%'";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getRecords(""));
//        selectByProductName("", 1, 10).forEach(System.out::println);
        System.out.println(selectOneById(1));
        System.out.println(deleteOneById(10));
        insertOne(new Product(null,"test", 100, "test", "test", 1));
    }

}
