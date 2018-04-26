package tv.alphanetworks.exo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"tv.alphanetworks.exo"})
@EnableAutoConfiguration( exclude = HibernateJpaAutoConfiguration.class )
public class Application {

    public static void main( String[] args ) {

       SpringApplication.run( Application.class, args );

       System.out.print("Hello World\n");
    }

}
