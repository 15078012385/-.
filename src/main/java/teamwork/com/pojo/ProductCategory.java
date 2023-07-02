package teamwork.com.pojo;

import java.io.Serializable;

/**
 * @description product_category
 * @author teamwork
 * @date 2023-06-30
 */

public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * category_name
    */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public ProductCategory() {}

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public ProductCategory(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}