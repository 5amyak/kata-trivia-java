package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class GameBetter implements IGame {
    private final QuestionManager questionManager = new QuestionManager();
    private final ArrayList<Player> players = new ArrayList<>();
    private int currentPlayerIdx = 0;
    private boolean isGettingOutOfPenaltyBox;

    public boolean add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void roll(int roll) {
        Player currentPlayer = players.get(currentPlayerIdx);
        System.out.println(currentPlayer.getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox() && roll % 2 == 0) {
            isGettingOutOfPenaltyBox = false;
            System.out.println(currentPlayer.getPlayerName() + " is not getting out of the penalty box");
            return;
        }
        if (currentPlayer.isInPenaltyBox()) {
            isGettingOutOfPenaltyBox = true;
            System.out.println(currentPlayer.getPlayerName() + " is getting out of the penalty box");
        }

        movePlayerToNewPosition(roll, currentPlayer);
        questionManager.askQuestion(getCategoryForCurrentPosition(currentPlayer.getPlace()));
    }

    private void movePlayerToNewPosition(int roll, Player currentPlayer) {
        int newPos = (currentPlayer.getPlace() + roll) % 12;
        currentPlayer.setPlace(newPos);

        System.out.println(currentPlayer.getPlayerName()
                + "'s new location is " + newPos);
        System.out.println("The category is " + getCategoryForCurrentPosition(newPos));
    }

    private String getCategoryForCurrentPosition(int pos) {
        if (pos % 4 == 0) return "Pop";
        if (pos % 4 == 1) return "Science";
        if (pos % 4 == 2) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        Player currentPlayer = players.get(currentPlayerIdx);
        if (currentPlayer.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            currentPlayerIdx = getNextPlayerIdx();
            return true;
        }

        currentPlayer.setInPenaltyBox(false);
        updateGoldCoins(currentPlayer);
        boolean isCurrentPlayerWinner = currentPlayer.getPurse() == 6;
        currentPlayerIdx = getNextPlayerIdx();
        return !isCurrentPlayerWinner;
    }

    private void updateGoldCoins(Player currentPlayer) {
        System.out.println("Answer was correct!!!!");
        currentPlayer.setPurse(currentPlayer.getPurse() + 1);
        System.out.println(currentPlayer.getPlayerName()
                + " now has "
                + currentPlayer.getPurse()
                + " Gold Coins.");
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayerIdx).getPlayerName() + " was sent to the penalty box");
        players.get(currentPlayerIdx).setInPenaltyBox(true);

        currentPlayerIdx = getNextPlayerIdx();
        return true;
    }

    private int getNextPlayerIdx() {
        return (currentPlayerIdx + 1) % players.size();
    }

}