package server.Data.ChessBoard.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import server.Data.ChessBoard.Pieces.Piece;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Field {
    private Piece piece;
    @NonNull private Boolean isActive;
}
