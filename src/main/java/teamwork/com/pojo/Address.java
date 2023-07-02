package teamwork.com.pojo;

import java.io.Serializable;

/**
 * @description address
 * @author teamwork
 * @date 2023-06-30
 */
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    /**
    * user_id
    */
    private Integer userId;

    /**
    * recipient_name
    */
    private String recipientName;

    /**
    * address
    */
    private String address;

    /**
    * phone
    */
    private String phone;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", recipientName='" + recipientName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Address(Integer id, Integer userId, String recipientName, String address, String phone) {
        this.id = id;
        this.userId = userId;
        this.recipientName = recipientName;
        this.address = address;
        this.phone = phone;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}