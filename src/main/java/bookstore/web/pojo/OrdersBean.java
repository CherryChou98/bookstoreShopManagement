package bookstore.web.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ Package: bookstore.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 15:20 2018/12/2
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class OrdersBean {
    private String id;
    private Date ordertime;
    private Double price;
    private String state;
    private String user_id;

    public OrdersBean() {
    }

    public OrdersBean(String id, Date ordertime, Double price, String state, String user_id) {
        this.id = id;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
