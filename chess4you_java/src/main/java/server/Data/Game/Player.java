package server.Data.Game;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import server.Data.ChessBoard.Board.ChessEnum;

@Document(collection = "players")
@Data
@RequiredArgsConstructor
public class Player {
    @Id
    private String Id;
    @NonNull private String Name;
    private ChessEnum.Color Color;
}
