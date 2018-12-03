package bookstore.web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @ Package: bookstore.web.dao
 * @ Author     ：linsola
 * @ Date       ：Created in 14:54 2018/11/28
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class Dbutil {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:F:/Java Practice/javaWeb/javaWebExp/Git/database/bookstore.db";
    private static Connection conn = null;

    private static Dbutil ourInstance = new Dbutil();

    public static Dbutil getInstance() {
        return ourInstance;
    }

    private Dbutil() {
    }

    public void getConnection() throws Exception{
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL);
    }

    public void closeConnection() throws Exception{
        if(conn!=null&&conn.isClosed()){
            conn.close();
            conn = null;
        }
    }

    public int executeUpdate(String sql) throws Exception{
        Statement st = conn.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }

    public int executeUpdate(String sql, Object...obj) throws Exception{
        PreparedStatement pst = conn.prepareStatement(sql);
        //给sql语句的占位符赋值
        if(obj!=null&&obj.length>0){
            for(int i=0;i<obj.length;i++){
                pst.setObject(i+1,obj[i]);
            }
        }
        int r = pst.executeUpdate();
        return r;
    }

    public ResultSet executeQuery(String sql) throws Exception{
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public ResultSet executeQuery(String sql,Object...obj) throws Exception{
        PreparedStatement pst = conn.prepareStatement(sql);
        if(obj!=null&&obj.length>0){
            for(int i=0;i<obj.length;i++){
                pst.setObject(i+1,obj[i]);
            }
        }
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public boolean queryLogin(String username,String password) throws Exception{
        String sql = "select * from user where username=? and password=?";
        ResultSet rs = executeQuery(sql,username,password);
        if(rs.next()){
            if("1".equals(rs.getString("id"))){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    public String queryOrder(String id) throws Exception{
        String sql = "select * from orders where id=?";
        ResultSet rs = executeQuery(sql,id);
        if(rs.next()){
            return rs.getString("state");
        }else{
            return null;
        }
    }
}
