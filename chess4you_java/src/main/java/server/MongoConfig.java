package server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import server.Data.LobbyHandler;
import server.Data.PlayerHandler;

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
