package server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import server.Handler.LobbyHandler;
import server.Service.PlayerService;

@Configuration
@ComponentScan(basePackageClasses = PlayerService.class)
@ComponentScan(basePackageClasses = LobbyHandler.class)
public class MongoConfig {

    /*@Bean
    CommandLineRunner commandLineRunner(IPlayerRepository playerRepository) {
        return strings -> {
            playerRepository.save(new Player("Andri"));
            playerRepository.save(new Player("Fabio"));
        };
    }*/
}
