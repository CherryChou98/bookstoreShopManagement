package bookstore.web.controller;

import bookstore.web.dao.BookDaoImpl;
import bookstore.web.pojo.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ Package: bookstore.web.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 17:06 2018/11/30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@RequestMapping("/book")
@ResponseBody
public class BookController {
    private BookDaoImpl bookDaoImpl;

    @Autowired
    public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
        this.bookDaoImpl = bookDaoImpl;
    }

    @RequestMapping(value = "/viewAllBook", method = GET)
    public List<BookBean> viewAllBook(){
        ArrayList<BookBean> list = bookDaoImpl.queryAllBook();
        return list;
    }

    @RequestMapping(value = "/insertBook", method = POST)
    public boolean insertBook(@ModelAttribute BookBean bookBean){
        boolean flag = false;
        flag = bookDaoImpl.insertBook(bookBean);
        if(flag){
            return flag;
        }
        return flag;
    }
}
