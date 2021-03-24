/**@author alecc*/
//File to contain the main file for the Hangman game
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import  javax.swing.JFrame;

public class Hangman {
    public static void main(String[] args) {
        int lettersFound;
        int failedAttpts = 0;
        final int limbs = 6;
        int lettersGuessed = 0; //Tracker to see if player has won
        boolean willPlay = false;
        String bdGuess = "";

        RandomWord randomWord = new RandomWord();
        String inputHolder = JOptionPane.showInputDialog("Hangman is a game where you guess a letter and are told" +
                " whether or not it is within the hidden word. You can keep guessing until you run out of tries, which in this version" +
                "is 6.\nYou will not be punished for duplicate guesses and will be given the word you missed if you lose.\nDo you want to play Hangman? (Y/N)");

        if (inputHolder.equals("Y") || inputHolder.equals("y")) {
            willPlay = true;
        }

        while (willPlay) {
            Guess guessChecker = new Guess();
            String currentWord = randomWord.chooseWord();
            if(currentWord == null){
                System.out.println("You have finished the entire list of words.\nThanks For Playing!");
            }
            char[] hangmanWord = currentWord.toCharArray();


            while ((failedAttpts != limbs)){
                bdGuess = guessChecker.printBadGuesses();

                JOptionPane.showMessageDialog(null,"----Your Word----\n" + guessChecker.printDisplayWord(currentWord.toCharArray())+ "" +
                        "\n-----BAD GUESSES-----\n" + bdGuess);



                inputHolder = "";// Make Sure inputHolder is Empty before asking for an input
                while (inputHolder.isEmpty()) {
                    inputHolder = JOptionPane.showInputDialog("What Letter will you guess?");
                }

                lettersFound = guessChecker.playerGuess(inputHolder, hangmanWord);
                if(!guessChecker.beenUsed(inputHolder.charAt(0))) {
                    if (lettersFound == 0) {
                        JOptionPane.showMessageDialog(null,"Not a letter!\nAttempts Remaining: " + (limbs - (failedAttpts + 1)) );


                        failedAttpts += 1;

                        if (failedAttpts == limbs) {
                            JOptionPane.showMessageDialog(null,"\nYou LOST/DIED\nThe word actually was: \n----" + currentWord + "----");

                        }
                    } else {
                        lettersGuessed += lettersFound;
                        // If letter is found then the current word needed to be guessed is changed to the old word
                        // without the letter(s) the player guessed
                        hangmanWord = guessChecker.removeGuess(hangmanWord, inputHolder.charAt(0), lettersFound);

                        if (lettersGuessed == currentWord.length()) {
                            guessChecker.printDisplayWord(currentWord.toCharArray());
                            JOptionPane.showMessageDialog(null,"CONGRATULATIONS!!\n----YOU WON!!----");
                            failedAttpts = limbs;
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"You Already guessed '" + inputHolder + "': TRY AGAIN!\n" +
                            "Attempts Remaining: " + (limbs - (failedAttpts + 1)));


                }
            }
            willPlay = guessChecker.continueGame();
            failedAttpts = 0; //Resets the Attempts of the player
            lettersGuessed = 0;
        }
    }
}
