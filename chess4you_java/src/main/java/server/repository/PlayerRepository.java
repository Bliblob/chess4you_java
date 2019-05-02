package server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import server.Data.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
