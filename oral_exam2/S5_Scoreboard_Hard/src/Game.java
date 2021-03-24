public class Game {
    private final Team firstTeam;
    private final Team secondTeam;
    private boolean gameOver = false;
    protected int periodTracker = 0;
    protected String periodName;
    protected int periods = 4;
    protected int pLengthInMin = 10;
    protected Team winner = null;
    protected int[] scoringMethods = {1};
    protected String[] scoringMethodNames = {"Goal"};

    Game(Team fTeam, Team sTeam){
        this.firstTeam = fTeam;
        this.secondTeam = sTeam;
        this.periodName = "Period";
    }

    public void addScore(int points, Team team){
        team.addPoints(points);
    }

    public void addPeriod(){
        this.periodTracker++;
    }

    /**
     * @return Determines whether the game has finished or not
     */
    public boolean gameOverPeriod(){
        if(periodTracker == periods){
            return true;
        }
        return false;
    }

    public String getPeriodName() {
        return periodName;
    }

    /**
     * MethodName: scoreType
     * Purpose: Returns the correct value of the score for the input given.
     * @param choice Is the value of the user input, this is adjusted to work no matter who many scare methods there are.
     * @return The int value of the score type needed
     */
    public int scoreType(int choice){
        // Modulus to account for the increasing number for the user choices
        int choiceF = choice % (scoringMethodNames.length +1) ;
        if(choice > scoringMethodNames.length){
            return scoringMethods[choiceF];
        }
        return scoringMethods[choiceF-1];
    }


    /**
     * MethodName: getWinner
     * Purpose: Checks the score of the first and second team and returns the name of the team that has a higher score. If there
     *      is no winner then 'NO WINNNER' will be returned instead.
     * @return The winner of the game
     * */
    public String getWinner(){
        if(firstTeam.getScore() > secondTeam.getScore()){
            return firstTeam.getTeamName();
        }
        else if(firstTeam.getScore() < secondTeam.getScore()){
            return secondTeam.getTeamName();
        }
        return "NO WINNER";
    }

    /**
     * MethodName: printStatus
     * Purpose: Displays the scores of each team along with their name and the current period the game is in.
     * If the game is over, then the user will be notified that the game has ended and the winner will be displayed.
     * */
    public void printStatus(){
        if(gameOverPeriod()){
            System.out.println("\nGame Is Over.");
            System.out.println(firstTeam.getTeamName() + " - " + firstTeam.getScore() + ", "
                    + secondTeam.getTeamName() + " - " + secondTeam.getScore());
            System.out.println("Current " + periodName + ": " + periodTracker);
            System.out.println("Winner: " + getWinner() + "\n");

        }
        else{
            System.out.println("\n" + firstTeam.getTeamName() + " - " + firstTeam.getScore() + ", "
                    + secondTeam.getTeamName() + " - " + secondTeam.getScore());
            System.out.println("Current " + periodName + ": " + periodTracker + "\n");
        }
    }

    public String[] getScoringMethodNames() {
        return scoringMethodNames;
    }

    public int getScoringMethods(String type) {
        return 0;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void setIsGameOver(boolean p){
        gameOver = p;
    }

    public Team getWinnerTeam() {
        return winner;
    }

    public int getPeriods() {
        return periods;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public int getpLengthInMin() {
        return pLengthInMin;
    }
    }
