public class RandomPlayer extends Player {

    public RandomPlayer (Board b, boolean s){
        super(b,s);
    }
    public void placePiece(){
        while(!b.placePiece(s, (int)(Math.random()*3), (int)(Math.random()*3))) { }
    }
}
