package server.Data.ChessBoard.Pieces;

import lombok.*;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Position;

import java.util.UUID;
@Data
@RequiredArgsConstructor
public abstract class Piece {
    @Setter(AccessLevel.NONE)
    private UUID Uuid = UUID.randomUUID();
    @Setter(AccessLevel.NONE)
    private String name = this.getClass().getSimpleName();
    private Position position;
    @NonNull private ChessEnum.Color color;
    private ChessEnum.Piece type;
    private ChessEnum.DirectionType[] directions;
}

