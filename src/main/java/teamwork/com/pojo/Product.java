package teamwork.com.pojo;

import java.io.Serializable;

/**
 * @description product
 * @author teamwork
 * @date 2023-06-30
 */

public class Product implements Serializable {

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
    * product_name
    */
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
    * price
    */
    private Integer price;
    private String productCategory;
    private String origin;


    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Product(Integer id, String productName, Integer price, String productCategory, String origin) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
        this.origin = origin;
    }

    public Product(Integer id, String productName, Integer price, String productCategory, String origin, Integer categoryId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
        this.origin = origin;
        this.categoryId = categoryId;
    }

    /**
    * category_id
    */
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                ", origin='" + origin + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public Product(Integer id, String productName, Integer price, Integer categoryId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }
}