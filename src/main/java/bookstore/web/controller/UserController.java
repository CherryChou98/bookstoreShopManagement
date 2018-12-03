package bookstore.web.controller;

import bookstore.web.dao.UserDaoImpl;
import bookstore.web.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ Package: bookstore.web.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 18:19 2018/11/25
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    private UserDaoImpl userDaoImpl;

    @Autowired
    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @RequestMapping(value = "/login", method = POST)
    public boolean login(@RequestParam("username") String username,@RequestParam("password") String password){
        boolean flag = false;
        flag = userDaoImpl.login(username,password);
        if(flag){
            return flag;
        }
        return flag;
    }
    @RequestMapping(value="/viewUser", method= GET)
    public UserBean viewUser(@RequestParam("username") String username){
        try {
            UserBean u = userDaoImpl.queryByUsername(username);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/viewAllUser", method = GET)
    public List<UserBean> viewAllUser(){
        try {
            ArrayList<UserBean> list = userDaoImpl.queryAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
