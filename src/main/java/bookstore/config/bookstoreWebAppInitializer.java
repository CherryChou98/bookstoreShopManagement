package bookstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @ Package: bookstore.config
 * @ Author     ：linsola
 * @ Date       ：Created in 18:02 2018/11/25
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class bookstoreWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**配置文件上传*/
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String location = "F:/Java Practice/javaWeb/javaWebExp/Exp6/src/main/webapp/static/image";
        long maxFileSize = 50*1024*1024;
        long maxRequestSize = 100*1024*1024;
        int fileSizeThreshold = 0;
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(location,maxFileSize,maxRequestSize,fileSizeThreshold);
        registration.setMultipartConfig(multipartConfigElement);
    }
}
