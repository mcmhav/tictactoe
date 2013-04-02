public class Board {

    
	private Boolean board[][] = new Boolean[3][3];

    public Board(){

    }

    public boolean placePiece(Boolean p, int p1, int p2){
        if(board[p1][p2]==null){
            board[p1][p2] = p;
            return true;
        }
        return false;
    }

    public Boolean[][] getBoard(){
        return board;
    }

    public boolean checkWin(){
        int ht;
        int hf;

        int vt;
        int vf;

        int crt = 0;
        int crf = 0;

        int clt = 0;
        int clf = 0;

        for (int i = 0; i < 3; i++){
            ht = 0;
            hf = 0;
            vf = 0;
            vt = 0;
            if (board[i][i]!=null){
                if (board[i][i]){
                    crt++;
                } else {
                    crf++;
                }
            }
            if (board[i][2-i]!=null){
                if (board[i][2-i]){
                    clt++;
                } else {
                    clf++;
                }
            }
            for (int j = 0; j < 3; j++){
                if(board[i][j]!=null){
                    if (board[i][j]) {
                        ht++;
                    } else {
                        hf++;
                    }
                }
                if(board[j][i]!=null){
                    if (board[j][i]) {
                        vt++;
                    } else {
                        vf++;
                    }
                }
            }
            if (hf == 3 || vf == 3){
                System.out.println("x win");
                return true;
            } else if (ht == 3 || vt == 3){
                System.out.println("O win");
                return true;
            }
        }

        if (crf == 3 || clf == 3){
            System.out.println("X win");
            return true;
        } else if (crt == 3 || clt == 3){
            System.out.println("O win");
            return true;
        }

        return false;
    }

    public void printBoard(){
        for (int i = 0; i < 3; i++){
            System.out.println();
            for (int j = 0; j < 3; j++){
                if(board[i][j]!=null){
                    if(board[i][j]){
                        System.out.print("O" + "\t");
                    } else if(!board[i][j]){
                        System.out.print("X" + "\t");
                    }
                } else {
                    System.out.print("-" + "\t");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Board b = new Board();

        Player p1 = new RandomPlayer(b, true);
        Player p2 = new RandomPlayer(b, false);

        Players ps = new Players(p1, p2);

        
		int c = 0;
        boolean turn = false;

        while (!b.checkWin() && c < 9){
            ps.getPlayer(turn).placePiece();
            b.printBoard();
            c++;

            turn = !turn;
        }
        if (c == 9 && !b.checkWin()) {
            System.out.println("No winner");
        }
    }
}
