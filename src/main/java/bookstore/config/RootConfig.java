package bookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ Package: bookstore.config
 * @ Author     ：linsola
 * @ Date       ：Created in 18:10 2018/11/25
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Configuration
@ComponentScan(basePackages={"bookstore"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
}
