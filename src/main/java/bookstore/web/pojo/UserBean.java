package bookstore.web.pojo;

import org.springframework.stereotype.Component;

/**
 * @ Package: bookstore.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 17:35 2018/11/27
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class UserBean {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String cellphone;
    private String email;
    private String address;

    public UserBean() {
    }

    public UserBean(String id, String username, String password, String phone, String cellphone, String email, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
