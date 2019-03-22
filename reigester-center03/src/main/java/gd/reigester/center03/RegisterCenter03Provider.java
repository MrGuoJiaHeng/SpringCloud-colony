package gd.reigester.center03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenter03Provider {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenter03Provider.class,args);
    }
}

