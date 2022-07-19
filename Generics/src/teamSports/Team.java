package teamSports;

import java.util.ArrayList;

class Team<T extends Player> {

    private String name;
    private int played = 0;
    private int won = 0;
    private int loss = 0;
    private int tied = 0;

    private ArrayList<T> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getTied() {
        return tied;
    }

    public void setTied(int tied) {
        this.tied = tied;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<T> members) {
        this.members = members;
    }

    public boolean addPlayer(T player){
        members.add(player);
        System.out.println(((Player) player).getName() + " was picked");
        return true;
    }


}
