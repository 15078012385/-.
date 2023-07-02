package teamwork.com.service;

import teamwork.com.pojo.User;

import java.util.ArrayList;

public interface UserService {
    int insertOne(User User);

    int deleteById(int id);

    int updateById(User User);

    User selectById(int id);

    ArrayList<User> selectByPage();

}
