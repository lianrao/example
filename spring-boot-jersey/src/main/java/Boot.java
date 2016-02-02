import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by jay.rao on 2015/12/8.
 */
@SpringBootApplication(scanBasePackages = "com.rda.example.jwt")
public class Boot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Boot.class);
    }
    public static void main(String[] args) {
        new Boot().configure(new SpringApplicationBuilder(Boot.class))
                .run(args);
    }



}
