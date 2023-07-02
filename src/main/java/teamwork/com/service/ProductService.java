package teamwork.com.service;

import teamwork.com.pojo.Product;

import java.util.ArrayList;

public interface ProductService {
    int insertOne(Product Product);

    int deleteById(int id);

    int updateById(Product Product);

    Product selectById(int id);

    ArrayList<Product> selectByPage();

}
