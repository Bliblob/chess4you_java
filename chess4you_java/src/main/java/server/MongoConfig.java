package server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import server.Handler.LobbyHandler;
import server.Handler.PlayerHandler;

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
