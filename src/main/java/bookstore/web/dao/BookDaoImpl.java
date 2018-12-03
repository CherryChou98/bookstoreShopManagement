package bookstore.web.dao;

import bookstore.web.pojo.BookBean;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Package: bookstore.web.dao
 * @ Author     ：linsola
 * @ Date       ：Created in 16:49 2018/11/30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class BookDaoImpl implements BookDao {
    private Dbutil dbutil;

    public BookDaoImpl() {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<BookBean> queryAllBook(){
        ArrayList<BookBean> list = new ArrayList<>();
        try {
            String sql = " select * from book ";
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                BookBean book = new BookBean();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setImage(rs.getString("image"));
                book.setDescription(rs.getString("description"));
                book.setCategory(rs.getString("category"));
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertBook(BookBean bookBean) {
        String id = bookBean.getId();
        String name = bookBean.getName();
        String author = bookBean.getAuthor();
        Double price = bookBean.getPrice();
        String image = bookBean.getImage();
        String description = bookBean.getDescription();
        String category = bookBean.getCategory();
        boolean flag = false;
        String sql = "insert into book(id,name,author,price,image,description,category) values (?,?,?,?,?,?,?)";
        try {
            dbutil.executeUpdate(sql,id,name,author,price,image,description,category);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
