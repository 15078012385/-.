package teamwork.com.service;

import teamwork.com.pojo.ProductCategory;

import java.util.ArrayList;

public interface ProductCategoryService {
    int insertOne(ProductCategory ProductCategory);

    int deleteById(int id);

    int updateById(ProductCategory ProductCategory);

    ProductCategory selectById(int id);

    ArrayList<ProductCategory> selectByPage();

}
