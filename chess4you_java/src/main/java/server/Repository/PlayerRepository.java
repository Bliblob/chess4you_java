package server.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import server.Data.Game.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
