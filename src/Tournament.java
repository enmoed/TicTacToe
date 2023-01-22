public class Tournament {
    private final int rounds; // rounds of the tournament
    private final Renderer renderer; // renderer of the games of the tournament
    private final Player[] players;  // the players of the tournament
    private static final String RESULTS_MESSAGE = "######### Results #########\nPlayer 1, %s won:" +
            " %d rounds\nPlayer 2, %s won: %d rounds\nTies: %d%n"; // the final result message

    /**
     * Constructor of the tournament
     * @param rounds int number of rounds to the tournament
     * @param renderer type of Renderer of the games
     * @param players an array of the Players
     */
    public Tournament(int rounds, Renderer renderer, Player[] players){
        this.rounds=rounds;
        this.renderer=renderer;
        this.players = new Player[players.length];
        for (int i=0; i<players.length; i++){
            this.players[i] = players[i];
        }
    }

    /**
     * Plays the tournament
     * @param size int size of the game board
     * @param winStreak int streak needed to win
     * @param playerNames array of two Strings of the player names
     */
    public void playTournament(int size, int winStreak, String[] playerNames){
        int[] score = {0, 0, 0};
        for (int i = 0; i < rounds; i++){
            Mark winner = new Game(players[i%2], players[(i+1)%2],size, winStreak, renderer).run();
            if (winner == Mark.BLANK){ // tie
                score[2]++;
            }
            else if (winner == Mark.X && i % 2 == 0 || winner == Mark.O && i % 2 == 1){ // player 1 won
                score[0]++;
            }
            else{ // player 2 won
                score[1]++;
            }
        }
        System.out.printf(RESULTS_MESSAGE, playerNames[0], score[0], playerNames[1], score[1], score[2]);

    }

    /**
     * Runs a tournament of tictactoe
     * @param args int rounds, int size, int winStreak, String renderer, String player1, String player2
     */
    public static void main(String []args){
        int rounds = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int winStreak = Integer.parseInt(args[2]);
        Renderer renderer = RendererFactory.buildRenderer(args[3], size);
        String[] playerNames = {args[4], args[5]};
        Player[] players = new Player[2];
        for (int i = 0; i < 2; i++){
            players[i] = PlayerFactory.buildPlayer(playerNames[i]);
        }
        Tournament tournament = new Tournament(rounds, renderer, players);
        tournament.playTournament(size, winStreak, playerNames);
    }




}
