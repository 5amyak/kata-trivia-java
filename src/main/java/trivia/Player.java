package trivia;

public class Player {

    private final String playerName;
    private Integer place = 0;
    private Integer purse = 0;
    private Boolean isInPenaltyBox = false;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPurse() {
        return purse;
    }

    public void setPurse(Integer purse) {
        this.purse = purse;
    }

    public Boolean isInPenaltyBox() {
        return isInPenaltyBox;
    }

    public void setInPenaltyBox(Boolean inPenaltyBox) {
        isInPenaltyBox = inPenaltyBox;
    }
}
