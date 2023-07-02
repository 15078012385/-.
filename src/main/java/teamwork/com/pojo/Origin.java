package teamwork.com.pojo;

import java.io.Serializable;

/**
 * @description origin
 * @author teamwork
 * @date 2023-06-30
 */
public class Origin implements Serializable {
    @Override
    public String toString() {
        return "Origin{" +
                "id=" + id +
                ", originName='" + originName + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    /**
    * origin_name
    */
    private String originName;


    public Origin() {
    }

    public Origin(String originName) {
        this.originName = originName;
    }

    public Origin(Integer id, String originName) {
        this.id = id;
        this.originName = originName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

}