public class Soccer extends Game {


    Soccer(Team fTeam, Team sTeam){
        super(fTeam, sTeam);
        this.periods = 2;
        this.pLengthInMin = 45;
        this.scoringMethods = new int[]{1};
        this.scoringMethodNames = new String[]{"Goal"};
    }

    public int getScoringMethods() {
        return scoringMethods[0];
    }

    public String[] getScoringMethodNames() {
        return scoringMethodNames;
    }
}
