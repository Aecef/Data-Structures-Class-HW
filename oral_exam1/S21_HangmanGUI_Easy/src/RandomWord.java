/**@author alecc*/
// Choosing a random word for the hangman game
import java.security.SecureRandom;
import java.util.Random;


public class RandomWord {

    private static String[] wordList = {"neat","equal","understood","want","birds",
            "tempt","hungry","prefer","bizarre","purpose","neat", "depressing","hopeless",
            "pointless","domineering","rest","floor","rhythm","dynamic","channel","aimless",
            "patience","railroad","boundary","seashore, oscilloscope, dragon, "};


     /**
     *************************************************************************
     * MethodName: removeWord
     * Purpose: Removes the previously selected word chosen from chooseWord from the array wordList
     ************************************************************************
     */
    public void removeWord(int removed){
        int i = 0;
        int run = wordList.length;
        wordList[removed] = null;
        String[] holderArr = new String[run - 1];
        for(String word: wordList){
            if(word != null){
                holderArr[i] = word;
                i++;
            }
        }

        wordList = holderArr;
    }


    /**
    *************************************************************************
    * MethodName: chooseWord
    * Purpose: Generates random number that chooses from the array of words, wordList,
    * and returns that word.
    ************************************************************************
    */
    public String chooseWord(){
        if(wordList.length == 0){
            return null;
        }

        SecureRandom randomNumbers = new SecureRandom();
        int chosenNum = randomNumbers.nextInt(wordList.length);
        String wordHolder = wordList[chosenNum];
        removeWord(chosenNum);
        return wordHolder;
    }

    /**
     *************************************************************************
     * MethodName: getWordList
     * Purpose: Returns the list of words the game has
     ************************************************************************
     */
    public static String[] getWordList() {
        return wordList;
    }
}



