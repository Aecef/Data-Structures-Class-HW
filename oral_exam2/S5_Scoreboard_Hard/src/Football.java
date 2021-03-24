public class Football extends Game{

    Football(Team fTeam, Team sTeam){
        super(fTeam, sTeam);
        this.periodName = "Quarter";
        this.pLengthInMin = 15;
        this.scoringMethods = new int[]{1,2,2,3,6};
        this.scoringMethodNames = new String[]{"Extra Point", "Safety", "2-pt Conversion", "Field Goal","touchdown"};
    }


    @Override
    public int getScoringMethods(String type) {
        if(type.equals("touchdown")){
            return scoringMethods[4];
        }
        else if(type.equals("field goal")){
            return scoringMethods[3];
        }
        else if(type.equals("2pt") || type.equals("safety")){
            return scoringMethods[1];
        }

        else if(type.equals("extra point")){
            return scoringMethods[0];
        }
        return 0;
    }

    @Override
    public String[] getScoringMethodNames() {
        return scoringMethodNames;
    }
}
