package teamwork.com.service;

import teamwork.com.pojo.UserCategory;

import java.util.ArrayList;

public interface UserCategoryService {
    int insertOne(UserCategory UserCategory);

    int deleteById(int id);

    int updateById(UserCategory UserCategory);

    UserCategory selectById(int id);

    ArrayList<UserCategory> selectByPage();

}
