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
            String sql = " select book.id, book.name, author, price, image, book.description, category.name as name1 from book, category where book.category_id=category.id ";
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                BookBean book = new BookBean();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setImage(rs.getString("image"));
                book.setDescription(rs.getString("description"));
                book.setCategory_id(rs.getString("name1"));
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
        String category_id = bookBean.getCategory_id();
        boolean flag = false;
        String sql = "insert into book(id,name,author,price,image,description,category_id) values (?,?,?,?,?,?,?)";
        try {
            dbutil.executeUpdate(sql,id,name,author,price,image,description,category_id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insertLabelPath(String id,String labelPath) {
        boolean flag = false;
        String sql = "update book set image=? where id=? ";
        try {
            int r = dbutil.executeUpdate(sql,labelPath,id);
            if(r!=0){
                flag = true;
            }else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
