package teamSports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    static Team team;
    static BasketballPlayer player1;
    static BasketballPlayer player2;

    @BeforeEach
    void setup(){
        team = new Team<BaseballPlayer>("Zalgiris");

        player1 = new BasketballPlayer("Jankis", 207,120.0);
        player2 = new BasketballPlayer("Sabas", 220,130.0);

        team.addPlayer(player1);
        team.addPlayer(player2);

    }

    @Test
    void isPlayerAdded(){
        assertEquals(2, team.getMembers().size());
    }

}