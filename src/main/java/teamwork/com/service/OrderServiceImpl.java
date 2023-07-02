package teamwork.com.service;

import teamwork.com.pojo.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderServiceImpl implements OrderService {
    @Override
    public int insertOne(Order Order) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        return 0;
    }

    @Override
    public int updateById(Order Order) throws SQLException {
        return 0;
    }

    @Override
    public Order selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Order> selectByPage(String productId, int pageNum, int pageSize) {
        return null;
    }
}
