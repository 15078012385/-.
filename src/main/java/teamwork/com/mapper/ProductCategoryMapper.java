package teamwork.com.mapper;

import teamwork.com.pojo.ProductCategory;
import teamwork.com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductCategoryMapper {
    private static Connection connection = null;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加
    public static int insertOne(ProductCategory productCategory) throws SQLException {
        String sql = "INSERT INTO tb_product_category (category_name) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, productCategory.getCategoryName());
        return ps.execute() ? 0 : 1;
    }

    // 删除
    public static int deleteOneById(int id) throws SQLException {
        String sql = "DELETE FROM tb_product_category WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        return ps.execute() ? 0 : 1;
    }

    // 更新
    public static int updateByOne(ProductCategory productCategory) throws SQLException {
        String sql = "UPDATE tb_product_category SET category_name = ? WHERE id = ?";
        return JdbcUtils.executeUpdate(sql, productCategory.getCategoryName(), productCategory.getId());
    }

    // id查询
    public static ProductCategory selectOneById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_product_category WHERE id = ?";
        ResultSet rs = JdbcUtils.executeQuery(sql, id);
        if (rs.next()) {
            return new ProductCategory(rs.getInt("id"), rs.getString("category_name"));
        }
        return null;
    }

    // 分页模糊查询
    public static ArrayList<ProductCategory> selectByCategoryName(String categoryName, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 查询结果的偏移量
        String sql = "SELECT * FROM tb_product_category WHERE category_name LIKE ? LIMIT ?, ?";
        ArrayList<ProductCategory> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtils.executeQuery(sql, "%" + categoryName + "%", offset, pageSize);
            while (rs.next()) {
                list.add(new ProductCategory(rs.getInt("id"), rs.getString("category_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getRecords(String param) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tb_product_category where category_name like '%" + param + "%'";
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
    }
}
