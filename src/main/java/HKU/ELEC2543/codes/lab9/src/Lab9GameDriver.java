// We will use our own driver program to test your program

public class Lab9GameDriver {

  public static void main(String[] args) {

    Lab9Player[] p = new Lab9Player[5]; // array for the players

    for (int i = 0; i < p.length; i++)
      p[i] = new Lab9Player();

    Lab9CardGame game = new Lab9CardGame(p);
    game.playOneGame();
  }
}
