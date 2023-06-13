package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServerApplication01 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication01.class,args);

    }
}
