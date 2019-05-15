package server;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Repository.PlayerRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PlayerRepository.class)
public class Application {

    public static void main(String... args) {
        ChessBoard chessBoard = new ChessBoard();
        Gson gson = new Gson();
        System.out.println(gson.toJson(chessBoard));
        SpringApplication.run(Application.class, args);
    }
}
