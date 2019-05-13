package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import server.Repository.PlayerRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PlayerRepository.class)
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
