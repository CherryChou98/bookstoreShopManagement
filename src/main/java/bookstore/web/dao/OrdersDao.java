package bookstore.web.dao;

import bookstore.web.pojo.OrdersBean;

import java.util.ArrayList;

public interface OrdersDao {
    /**查看所有订单*/
    public ArrayList<OrdersBean> queryAllOrders();
    /**查看初始订单*/
    public ArrayList<OrdersBean> queryOriginalOrders();
    /**查看已完成订单*/
    public ArrayList<OrdersBean> queryCompleteOrders();
    /**修改订单状态*/
    public ArrayList<OrdersBean> updateOrdersState(String id);
}
