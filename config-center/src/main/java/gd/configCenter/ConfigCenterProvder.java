package gd.configCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterProvder {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterProvder.class, args);
    }
}
