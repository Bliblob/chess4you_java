package server.Validator;

import lombok.Data;
import server.Data.ChessBoard.Movements.base.Movement;

import java.util.List;

@Data
public class EnPasseResult {
    public boolean isEnPassePossible;
    public List<Movement> movements;

    public EnPasseResult(boolean isEnPassePossible) {
        this.isEnPassePossible = isEnPassePossible;
    }

    public EnPasseResult(boolean isEnPassePossible, List<Movement> movements) {
        this.isEnPassePossible = isEnPassePossible;
        this.movements = movements;
    }
}
