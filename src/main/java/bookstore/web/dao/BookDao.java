package bookstore.web.dao;

import bookstore.web.pojo.BookBean;

import java.util.ArrayList;

public interface BookDao {
    /**查询所有书籍*/
    public ArrayList<BookBean> queryAllBook() throws Exception;
    /**书籍信息录入*/
    public boolean insertBook(BookBean bookBean);
}
