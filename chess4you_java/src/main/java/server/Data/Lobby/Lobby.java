package server.Data.Lobby;

import lombok.*;
import server.Data.Game.Player;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Lobby {
    @Setter(AccessLevel.NONE)
    private UUID Name = UUID.randomUUID();
    @Setter(AccessLevel.NONE)
    @NonNull private Player PlayerOne;
    private Player PlayerTwo;
}
