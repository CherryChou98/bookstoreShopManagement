package bookstore.web.controller;

import bookstore.web.dao.OrdersDaoImpl;
import bookstore.web.pojo.OrdersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Package: bookstore.web.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 16:01 2018/12/2
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@RequestMapping("/orders")
@ResponseBody
public class OrdersController {
    private OrdersDaoImpl ordersDaoImpl;

    @Autowired
    public void setOrdersDaoImpl(OrdersDaoImpl ordersDaoImpl) {
        this.ordersDaoImpl = ordersDaoImpl;
    }

    @RequestMapping(value = "/viewAllOrders", method = RequestMethod.GET)
    public List<OrdersBean> viewAllOrders(){
        ArrayList<OrdersBean> list = ordersDaoImpl.queryAllOrders();
        return list;
    }

    @RequestMapping(value = "/viewOriginalOrders", method = RequestMethod.GET)
    public List<OrdersBean> viewOriginalOrders(){
        ArrayList<OrdersBean> list = ordersDaoImpl.queryOriginalOrders();
        return list;
    }

    @RequestMapping(value = "/viewCompleteOrders", method = RequestMethod.GET)
    public List<OrdersBean> viewCompleteOrders(){
        ArrayList<OrdersBean> list = ordersDaoImpl.queryCompleteOrders();
        return list;
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.GET)
    public ArrayList<OrdersBean> updateState(@RequestParam String id){
        ArrayList<OrdersBean> list = ordersDaoImpl.updateOrdersState(id);
        return list;
    }

}
