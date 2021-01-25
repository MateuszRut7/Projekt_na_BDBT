package bdbt.jednostka_akademicka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class JednostkaAkademickaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JednostkaAkademickaApplication.class, args);
    }

    @Bean
    Validator validator() {

        return new LocalValidatorFactoryBean();
    }
}

