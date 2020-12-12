package cn.chen.teachingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TeachingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachingSystemApplication.class, args);
    }

}
