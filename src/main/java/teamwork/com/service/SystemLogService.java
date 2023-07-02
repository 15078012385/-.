package teamwork.com.service;

import teamwork.com.pojo.SystemLog;

import java.util.ArrayList;

public interface SystemLogService {
    int insertOne(SystemLog SystemLog);

    int deleteById(int id);

    int updateById(SystemLog SystemLog);

    SystemLog selectById(int id);

    ArrayList<SystemLog> selectByPage();

}
