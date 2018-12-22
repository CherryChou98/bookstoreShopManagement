package bookstore.web.controller;

import bookstore.web.dao.BookDaoImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ Package: bookstore.web.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 9:55 2018/12/4
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
public class UploadController {
    private BookDaoImpl bookDaoImpl;

    @Autowired
    public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
        this.bookDaoImpl = bookDaoImpl;
    }

    @RequestMapping(value="/upload",method= RequestMethod.POST,produces="application/json;charset=utf-8")
    public boolean uploadFile(@RequestParam(value = "files", required = false) MultipartFile file,String id) {
        try {
            FileUtils.writeByteArrayToFile(new File("F:/Java Practice/javaWeb/javaWebExp/Exp6/src/main/webapp/static/image/" + file.getOriginalFilename()), file.getBytes());
            String path1 = file.getOriginalFilename();
            String labelPath = "<img src=\"../image/"+path1+"\">";
            if(bookDaoImpl.insertLabelPath(id,labelPath)){
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
