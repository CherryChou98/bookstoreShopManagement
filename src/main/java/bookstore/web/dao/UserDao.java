package bookstore.web.dao;

import bookstore.web.pojo.UserBean;

import java.util.ArrayList;

public interface UserDao {
    /**登录*/
    public boolean login(String username,String password);
    /**按用户名查询*/
    public UserBean queryByUsername(String username);
    /**查询全部用户*/
    public ArrayList<UserBean> queryAll();
}
