/**@author alecc*/
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Guess {

    private static final int LONGEST_ENGLISH_WORD = 45;
    private char[] goodGuesses = new char[LONGEST_ENGLISH_WORD];
    private char[] badGuesses = new char[26];
    private char[] usedLetters = new char[26];
    private int goodIndex = 0;
    private int badIndex = 0;
    private int usedIndex = 0;


    /**
     *************************************************************************
     * MethodName: printBadGuesses
     * Purpose: Prints out the array filled with the incorrect guesses the player
     * and displays them in the console.
     * @return String representation of the players bad Hangman guesses so far
     ************************************************************************
     */
    public String printBadGuesses(){
        String holder = "";

        for(char letter : badGuesses){
            holder += letter + " ";
        }
        return holder;
    }


    /**
     *************************************************************************
     * MethodName: printDisplayWord
     * Purpose: Displays only the letters of the current word that the player
     * has correctly guessed. Otherwise a "-" is used to indicate that the player
     * has yet to guess that letter. This also returns the char[] to compare
     * with the actual current word later to determine whether the player has won.
     * @param originalWord Word to guess and used to determine the length of the fLetters char[]
     * @return The char[] of the word being displayed
     ************************************************************************
     */
    public String printDisplayWord(char[] originalWord){
        char holder;
        String sHolder = "";
        char[] fLetters = new char[originalWord.length];
        for(int i = 0; i < originalWord.length; i++){
            holder = originalWord[i];
            if(containsGuess(holder)){
                fLetters[i] = holder;
            }
            else{
                fLetters[i] = '-';
            }
        }

        for(char letter : fLetters){
            //System.out.print(letter); Not Needed After GUI Implementation
            sHolder += letter + " ";

        }
        return sHolder;
    }

    /**
     *************************************************************************
     * MethodName: removeGuess
     * Purpose: Returns a char[] with the length of the of the original word - the amount of
     * times the guess appears in the word. It achieves this by allocating an array
     * of such a length through comparisons of all the words letters with the players
     * guess.
     * @param originalWord The whole original random word
     * @param guess Current player char guess
     * @param amount Amount of letters found of the guess that will be removed
     * @return A char[] of the random word - the already guessed chars
     ************************************************************************
     */
    public char[] removeGuess(char[] originalWord, char guess, int amount){
        int i = 0;
        char[] lettersRem = new char[originalWord.length - amount];
        while(amount > 0){
            for(char letter : originalWord){
                if(letter == guess){
                    amount--;
                }
                else {
                    lettersRem[i] = letter;
                    i++;
                }
            }
        }
        return lettersRem;
    }

    /**
     *************************************************************************
     * MethodName: playerGuess
     * Purpose: Returns the amount of times a player's  guess appears in the
     * hangman word. If it returns 0, it is assumed that the letter does not
     * appear in the word.
     * @param guess The players current guess
     * @param currWord The random/hangman word
     * @return The total amount of times the player guess appears in the word
     ************************************************************************
     */
    public int playerGuess(String guess, char[] currWord){
        int totalInWord = 0;
        for(char letter: currWord)
            if(letter == guess.charAt(0)){
                totalInWord++;
            }
        if(totalInWord == 0 && !this.inBadGuess(guess.charAt(0))){
            this.badGuesses[badIndex] = guess.charAt(0);
            badIndex++;
        }
        if(totalInWord > 0){
            this.goodGuesses[goodIndex] = guess.charAt(0);
            this.goodIndex++;
        }
        return totalInWord;
    }


    /**
     *************************************************************************
     * MethodName: beenUsed
     * Purpose: Checks to see if the player has used the guessed letter before
     * to avoid them using the same letter twice
     * @param guess Players char letter guess
     * @return True if the letter has been guessed already, False Otherwise
     ************************************************************************
     */
    public boolean beenUsed(char guess){
        for(char letter : this.usedLetters){
            if(guess == letter){
                return true;
            }
        }
        this.usedLetters[usedIndex] = guess;
        usedIndex++;
        return false;
    }
    /**
     *************************************************************************
     * MethodName: continueGame
     * Purpose: Asks the player whether or not they would like to keep playing. If
     * the player does not answer y or n then the game will continue asking
     * until they do.
     * @return True to continue game, False Otherwise
     ************************************************************************
     */
    public boolean continueGame() {
        boolean didntChoose = true;
        Scanner in = new Scanner(System.in);
        while (didntChoose) {//Doesnt change value because the player MUST choose Y or N
            String inputHolder = JOptionPane.showInputDialog(null,"Would you like to play again?(Y/N): ");
            if (inputHolder.equals("y") || inputHolder.equals("Y")) {
                JOptionPane.showMessageDialog(null, "Have Fun!");
                //System.out.println("Have Fun!");
                return true;
            }
            else if (inputHolder.equals("n") || inputHolder.equals("N")) {
                JOptionPane.showMessageDialog(null, "Thanks For Playing!");
                return false;
            }
        }
        return false;
    }

    /**
     *************************************************************************
     * MethodName: containsGuess
     * Purpose: Determines whether a letter is contained within the char[] of
     * good guesses. This helps determine whether or not the player should be
     * allowed to see that "guess" letter
     * @param guess Players Guess
     * @return True if the guess is within the word, False otherwise
     ************************************************************************
     */
    public boolean containsGuess(char guess){
        for(char letter : this.goodGuesses){
            if(letter == guess){
                return true;
            }
        }
        return false;
    }
    /**
     *************************************************************************
     * MethodName: inBadGuess
     * Purpose: Determines whether a letter is contained within the char[] of
     * bad guesses. This helps to not show any repeated guesses when printing the
     * badGuesses array.
     * @param guess Players Guess
     * @return True if the the players wrong guess has already been input, false otherwise
     ************************************************************************
     */
    public boolean inBadGuess(char guess){
        for(char letter : this.badGuesses){
            if(letter == guess){
                return true;
            }
        }
        return false;
    }

}
