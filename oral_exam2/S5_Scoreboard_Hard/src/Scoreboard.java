/**author acleofe */

import java.util.Scanner;

public class Scoreboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Team homeTeam;
        Team awayTeam;
        int gameChoice;
        int period = 0;
        int choice = 0;
        System.out.print("Select the type of game: \n" +
                "1. Football \n" +
                "2. Basketball \n" +
                "3. Soccer \n" +
                "4. Hockey \n" +
                "Enter Choice: ");
        gameChoice = in.nextInt();
        System.out.println("\nEnter Home Team: ");
        homeTeam = new Team(in.next());

        System.out.println("Enter Away Team: ");
        awayTeam = new Team(in.next());
        Game game;
        if(gameChoice == 1){
            game = new Football(homeTeam, awayTeam);
        }
        else if(gameChoice == 2){
            game = new Basketball(homeTeam, awayTeam);

        }
        else if(gameChoice == 3){
            game = new Soccer(homeTeam, awayTeam);

        }
        else if(gameChoice == 4){
            game = new Hockey(homeTeam, awayTeam);

        }
        else {
            game = null;
        }


        //Wont have to touch if you are adding a new game
        if(game != null) {
            while (!game.gameOverPeriod()) {

                //could've put for loops within the Game class
                for (int i = 0; i < game.getScoringMethodNames().length; i++) {
                    System.out.println((i + 1) + ". " + homeTeam.getTeamName() + "'s " + game.getScoringMethodNames()[i]);
                }
                for (int i = 0; i < game.getScoringMethodNames().length; i++) {
                    System.out.println((i + (game.getScoringMethodNames().length + 1)) + ". " + awayTeam.getTeamName() + "'s " + game.getScoringMethodNames()[i]);
                }
                System.out.println(((game.getScoringMethodNames().length * 2) + 1) + ". End " + game.getPeriodName());

                choice = in.nextInt();

                if (choice > 0 && choice <= (game.getScoringMethodNames().length)) {
                    game.addScore(game.scoreType(choice), homeTeam);
                } else if (choice > (game.getScoringMethodNames().length) && choice <= (game.getScoringMethodNames().length * 2)) {
                    game.addScore(game.scoreType(choice), awayTeam);
                } else {
                    //Any other button will advance the game
                    game.addPeriod();
                }
                game.printStatus();
            }
        }
    }

}
