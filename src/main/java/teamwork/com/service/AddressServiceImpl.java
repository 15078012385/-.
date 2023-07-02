package teamwork.com.service;

import teamwork.com.pojo.Address;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddressServiceImpl implements AddressService {
    @Override
    public int insertOne(Address address) throws SQLException {
        return 0;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        return 0;
    }

    @Override
    public int updateById(Address address) throws SQLException {
        return 0;
    }

    @Override
    public Address selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Address> selectByPage(Integer pageNum, Integer pageSize, String address) throws SQLException {
        return null;
    }
}
