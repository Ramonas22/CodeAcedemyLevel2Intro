package teamSports;

class Main {
    public static void main(String[] args) {

        Team<BasketballPlayer> zalgiris = new Team<>("Zalgiris");
        Team<BasketballPlayer> rytas = new Team("Rytas");
        Team<BasketballPlayer> wolves = new Team("Wolves");

        BasketballPlayer jankunas = new BasketballPlayer("Jankis", 207,120.0);
        BasketballPlayer sabonis = new BasketballPlayer("Sabas", 220,130.0);

        zalgiris.addPlayer(sabonis);
        zalgiris.addPlayer(jankunas);


        zalgiris.playMatch(wolves, 94, 87);
        rytas.playMatch(wolves, 66, 67);

        System.out.println(zalgiris.getName() + " "+ zalgiris.getWon() + " " + zalgiris.getLoss());


        Team<FootballPlayer> real = new Team<>("Kabelis");


        FootballPlayer ronaldo = new FootballPlayer("cr7", 187,87.5);
        FootballPlayer messi = new FootballPlayer("messi", 170,70.0);

        real.addPlayer(ronaldo);
        real.addPlayer(messi);

        //
        // real.whichTeamHasMorePlayers(zalgiris);
    }

}
