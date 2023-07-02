package teamwork.com.service;

import teamwork.com.pojo.Address;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddressService {
    int insertOne(Address address) throws SQLException;

    int deleteById(int id) throws SQLException;

    int updateById(Address address) throws SQLException;

    Address selectById(int id) throws SQLException;

    ArrayList<Address> selectByPage(Integer pageNum, Integer  pageSize, String address) throws SQLException;

}
