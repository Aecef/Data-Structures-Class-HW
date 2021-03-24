public class Basketball extends Game {


    Basketball(Team fTeam, Team sTeam){
        super(fTeam, sTeam);
        this.periodName = "Quarter";
        this.pLengthInMin = 12;
        this.scoringMethods = new int[]{1,2,3};
        this.scoringMethodNames = new String[]{"Free Throw", "2 Pointer", "3 Pointer"};
    }


    public int getScoringMethods(String type) {
        if(type.equals("2pt")){
            return scoringMethods[2];
        }
        else if(type.equals("3pt")){
            return scoringMethods[1];
        }

        else if(type.equals("free throw")){
            return scoringMethods[0];
        }
        return 0;
    }

    public String[] getScoringMethodNames() {
        return scoringMethodNames;
    }
}
