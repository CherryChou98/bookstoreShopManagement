package bookstore.web.pojo;

import org.springframework.stereotype.Component;

/**
 * @ Package: bookstore.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 16:09 2018/11/30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class BookBean {
    private String id;
    private String name;
    private String author;
    private Double price;
    private String image;
    private String description;
    private String category_id;

    public BookBean() {
    }

    public BookBean(String id, String name, String author, Double price, String image, String description, String category_id) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.image = image;
        this.description = description;
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
