package cn.connie.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
