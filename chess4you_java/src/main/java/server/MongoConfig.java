package server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import server.Data.LobbyHandler;
import server.Data.Player;
import server.Data.PlayerHandler;
import server.repository.PlayerRepository;

@Configuration
@ComponentScan(basePackageClasses = PlayerHandler.class)
@ComponentScan(basePackageClasses = LobbyHandler.class)
public class MongoConfig {

    /*@Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository) {
        return strings -> {
            playerRepository.save(new Player("Andri"));
            playerRepository.save(new Player("Fabio"));
        };
    }*/
}
