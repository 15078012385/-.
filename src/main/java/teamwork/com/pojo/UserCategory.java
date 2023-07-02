package teamwork.com.pojo;

import java.io.Serializable;

/**
 * @description user_category
 * @author teamwork
 * @date 2023-06-30
 */
public class UserCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    /**
    * category_name
    */
    private String categoryName;


    public UserCategory() {
    }

    @Override
    public String toString() {
        return "UserCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public UserCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public UserCategory(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}