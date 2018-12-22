package bookstore.web.dao;

import bookstore.web.pojo.OrdersBean;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @ Package: bookstore.web.dao
 * @ Author     ：linsola
 * @ Date       ：Created in 15:29 2018/12/2
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {
    private Dbutil dbutil;

    public OrdersDaoImpl() {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<OrdersBean> queryAllOrders() {
        try{
            String sql = " select * from orders ";
            ResultSet rs = dbutil.executeQuery(sql);
            return bianLiRs(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<OrdersBean> queryOriginalOrders() {
        String sql = "select * from orders where state=?";
        try{
            ResultSet rs = dbutil.executeQuery(sql,"未完成");
            return bianLiRs(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<OrdersBean> queryCompleteOrders() {
        String sql = "select * from orders where state=?";
        try{
            ResultSet rs = dbutil.executeQuery(sql,"完成");
            return bianLiRs(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<OrdersBean> updateOrdersState(String id) {
        try {
            String b = dbutil.queryOrder(id);
            if(b!=null){
                if(b.equals("完成")){
                    b = "未完成";
                }else {
                    b = "完成";
                }
                try {
                    String sql = "update orders set state=? where id=?";
                    int r = dbutil.executeUpdate(sql,b,id);
                    if(r>0){
                        ArrayList<OrdersBean> list = queryAllOrders();
                        return list;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  ArrayList<OrdersBean> bianLiRs(ResultSet rs) {
        ArrayList<OrdersBean> list = new ArrayList<>();
        try{
            while (rs.next()){
                OrdersBean order = new OrdersBean();
                order.setId(rs.getString("id"));
                order.setOrdertime(rs.getDate("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getString("state"));
                order.setUser_id(rs.getString("user_id"));
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
