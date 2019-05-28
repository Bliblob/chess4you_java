package server;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.ChessBoard.Movements.base.Position;
import server.Repository.IPlayerRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = IPlayerRepository.class)
public class Application {

    public static void main(String... args) {
        Position chessBoard = new Position(1,1);
        Gson gson = new Gson();
        System.out.println(gson.toJson(chessBoard));
        SpringApplication.run(Application.class, args);
    }
}
