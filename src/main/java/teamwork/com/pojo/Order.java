package teamwork.com.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * @author teamwork
 * @description order
 * @date 2023-06-30
 */
public class Order implements Serializable {
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

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
     * product_id
     */
    private Integer productId;

    /**
     * quantity
     */
    private Integer quantity;

    /**
     * total_price
     */
    private Integer totalPrice;

    /**
     * order_date
     */
    private Timestamp orderDate;

    private String nickname;
    private String productName;
    private String address;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order(Integer id, Integer userId, Integer productId, Integer quantity, Integer totalPrice, Timestamp orderDate, String nickname, String productName, String address) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.nickname = nickname;
        this.productName = productName;
        this.address = address;
    }

    public Order() {
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                ", nickname='" + nickname + '\'' +
                ", productName='" + productName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Order(Integer id, Integer userId, Integer productId, Integer quantity, Integer totalPrice, Timestamp orderDate) {

        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
}