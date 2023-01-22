/**
 * A class determining which player to create
 */
public class PlayerFactory {

    private static final String PLAYER_ERROR = "Choose a player, and start again\n The players:" +
            " [human, clever, whatever, genius]"; // string of error message

    /**
     * Default Constructor
     */
    public PlayerFactory(){}

    /**
     * Creates player
     * @param playerName name of player to create
     * @return player created
     */
    public static Player buildPlayer(String playerName){
        switch (playerName.toLowerCase()){
            case "human":
                return new HumanPlayer();
            case "clever":
                return new CleverPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "genius":
                return new GeniusPlayer();
            default:
                System.out.println(PLAYER_ERROR);
                System.exit(1);
        }
        return null;
    }
}
