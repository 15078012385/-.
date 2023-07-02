package teamwork.com.service;

import teamwork.com.pojo.Origin;

import java.sql.SQLException;
import java.util.ArrayList;

public class OriginServiceImpl implements OriginService {
    @Override
    public int insertOne(Origin Origin) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        return 0;
    }

    @Override
    public int updateById(Origin Origin) throws SQLException {
        return 0;
    }

    @Override
    public Origin selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Origin> selectByPage(Integer pageNum, Integer pageSize, String param) {
        return null;
    }
}
