public class Players {

    private Player p1;
    private Player p2;

    public Players (Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Player getPlayer(boolean n){
        return n ? p1 : p2;
    }
}
