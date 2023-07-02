package teamwork.com.service;

import teamwork.com.pojo.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderService {
    int insertOne(Order Order) throws SQLException;

    int deleteById(int id) throws SQLException;

    int updateById(Order Order) throws SQLException;

    Order selectById(int id) throws SQLException;

    ArrayList<Order> selectByPage(String productId, int pageNum, int pageSize);

}
