package bookstore.web.dao;

import bookstore.web.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Package: bookstore.web.dao
 * @ Author     ：linsola
 * @ Date       ：Created in 17:59 2018/11/27
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class UserDaoImpl implements UserDao{
    private Dbutil dbutil;

    public UserDaoImpl() {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String username, String password) {
        boolean flag = false;
        try {
            flag = dbutil.queryLogin(username,password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public UserBean queryByUsername(String username) {
        String sql = "select * from user where username=?";
        UserBean user = new UserBean();
        try {
            ResultSet rs = dbutil.executeQuery(sql,username);
            while (rs.next()){
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setCellphone(rs.getString("cellphone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserBean> queryAll() {
        ArrayList<UserBean> list = new ArrayList<>();
        try{
            String sql = " select * from user ";
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                UserBean user = new UserBean();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setCellphone(rs.getString("cellphone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
