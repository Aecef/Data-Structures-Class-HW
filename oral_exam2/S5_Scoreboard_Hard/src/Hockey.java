public class Hockey extends Game {
    Hockey(Team fTeam, Team sTeam){
        super(fTeam, sTeam);
        this.periods = 3;
        this.pLengthInMin = 20;
        this.scoringMethods = new int[]{1};
        this.scoringMethodNames = new String[]{"Goal"};
    }

    @Override
    public int getScoringMethods(String type) {
        if(type.equals("Goal")){
            return scoringMethods[0];
        }
        return 0;
    }

    @Override
    public String[] getScoringMethodNames() {
        return scoringMethodNames;
    }
}
