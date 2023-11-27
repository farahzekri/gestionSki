package tn.esprit.gestionski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class GestionSkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionSkiApplication.class, args);
    }

}
