/**author acleofe */

public class Team {
    private final String teamName;
    private int score = 0;
    Team(String tName){
        this.teamName = tName;
    }

    public void addPoints(int points){
        score += points;
    }
    public String getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }
}
