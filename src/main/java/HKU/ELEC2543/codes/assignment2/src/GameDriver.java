import java.io.*;

public class GameDriver {

  public static void main(String[] args) throws Exception {
/*
    Big2Player[] p = new Big2Player[4];
    p[0] = new Big2Player();
    p[1] = new Big2Player();
    p[2] = new Big2Player();
    p[3] = new Big2Player();

    Big2Game big2game = new Big2Game(p);
    big2game.playOneGame();
*/

    SevensPlayer[] p = new SevensPlayer[5];
    p[0] = new SevensPlayer();
    p[1] = new SevensPlayer();
    p[2] = new SevensPlayer();
    p[3] = new SevensPlayer();
    p[4] = new SevensPlayer();


    SevensGame sevengame = new SevensGame(p);
    sevengame.playOneGame();

  }
}

