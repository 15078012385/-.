package teamwork.com.service;

import teamwork.com.pojo.Origin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OriginService {
    int insertOne(Origin Origin) throws SQLException;

    int deleteById(int id) throws SQLException;

    int updateById(Origin Origin) throws SQLException;

    Origin selectById(int id) throws SQLException;

    ArrayList<Origin> selectByPage(Integer pageNum, Integer pageSize, String param);

}
