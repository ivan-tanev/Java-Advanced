package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (capacity >= roster.size()){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){

        Player[] kickedPlayers = this.roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);

        for (Player kickedPlayer : kickedPlayers) {
            roster.removeIf(player -> player.getName().equals(kickedPlayer.getName()));
        }

        return kickedPlayers;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder output = new StringBuilder();

        output.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player player : roster) {
            output.append(player.toString()).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
