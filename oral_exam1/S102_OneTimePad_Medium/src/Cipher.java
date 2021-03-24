import javax.management.ObjectName;
import java.security.SecureRandom;
import java.util.Scanner;
//-500 refers to a space
/**@author alecc */
public class Cipher {

    private String originalMessage;
    private int[] key;
    private int[] originalIndex;
    private int[] encryptedMessage;
    private char[] encryptedMessageAlpha;


    /**
     *************************************************************************
     * MethodName: createFinalEncryptionMessage()
     * @return The char values in the alphabet[] based on the encrypted index
     *          of the original message. Version used if other instance variables
     *          were initialized separately
     ************************************************************************
     */
    public char[] createFinalEncryptionMessage(){
        int i = 0;
        char[] temp = new char[key.length];
        for(int a : encryptedMessage){
            temp[i] = OneTimePad.letterAtIndex(encryptedMessage[i]);
            i++;

        }
        encryptedMessageAlpha = temp;
        return encryptedMessageAlpha;
    }

    /**
     *************************************************************************
     * MethodName: createFinalEncryptionMessage(String)
     * @return The char values in the alphabet[] based on the encrypted index
     *          of the original message. Version used if other instance variables
     *          were not initialized separately and the message is immediately loaded in
     *************************************************************************
     */
    public char[] createFinalEncryptionMessage(String message){
        this.originalMessage = message;
        this.key = generateKey(message.toCharArray());
        this.originalIndex = indexOfMessage(message.toCharArray());
        this.encryptedMessage = changeIndex();
        return createFinalEncryptionMessage();
    }

    /**
     *************************************************************************
     * MethodName: generateKey
     * Purpose: This will run through the char array of the message and assigns a
     * random N value for every character that will eventually change the value
     * of the original message
     * @param message Message that is being encrypted is inputted to know how many n-values to assign
     * @return this.key to store what n-values have been assigned for each index
     ************************************************************************
     */
    public int[] generateKey(char[] message){
        SecureRandom keyGen = new SecureRandom();
        int i = 0;
        int[] temp = new int[message.length];
        for (char a : message){
            if (a == ' '){
                temp[i] = -500;
            }
            else{
                temp[i] = keyGen.nextInt(26);
            }
            i++;
        }
        key = temp;
        return this.key;
    }

    /**
     *************************************************************************
     * MethodName: indexOfMessage
     * Purpose: Finds the corresponding letters in the alphabet and returns their index
     * value using indexInAlpha
     * @param message Message that is being encrypted to know the index of each letter within the alphabet
     * @return The original messages index to later be changed based on the n-values
     ************************************************************************
     */
    public int[] indexOfMessage(char[] message){
        int i = 0;
        int[] temp = new int[message.length];
        for(char letter : message){
            temp[i] = OneTimePad.indexInAlpha(letter);
            i++;
        }
        originalIndex = temp;
        return this.originalIndex;
    }


    /**
     *************************************************************************
     * MethodName: changeIndex
     * Purpose: Thia alter the index value of the message using the key and returns the
     * stored value of encryptedMessage
     * @return The altered index of the original messages index based on there n-values
     *          and will be used to display the ciphered text
     ************************************************************************
     */
    public int[] changeIndex(){
        int i = 0;
        int [] temp = new int[originalIndex.length];
        for(int a : originalIndex){
            if (temp[i] == -500){
                temp[i] = -500;
            }
            else{
                temp[i] = (originalIndex[i] + key[i]) % 26;
            }
            i++;
        }
        encryptedMessage = temp;
        return encryptedMessage;
    }

    /**
     *************************************************************************
     * MethodName: obtainNValues
     * Purpose: Takes in the values the user gives that should be the N-values
     * that will help display the correct message
     * @param userInputOfNVals Are the N-values that will decrypt the message and is an input
     *                         by the user
     * @return The final N values in the form of an int[] to help reconvert the messages N values
     ************************************************************************
     */
    public int[] obtainNValues(String userInputOfNVals){
        int i = 0;
        Scanner nValuesScanner = new Scanner(userInputOfNVals);
        int[] temp = new int[userInputOfNVals.length()];
        while(nValuesScanner.hasNextInt()){
            temp[i] = nValuesScanner.nextInt();
            i++;
        }
        int[] finalNValues = new int[i];
        for(int j = 0; j < i; j++){
            finalNValues[j] = temp[j];
        }
        return finalNValues;
    }

    /**
     *************************************************************************
     * MethodName: nValuesRemoved
     * Purpose: This will remove the N-values given from the ciphered message
     * and return the indexes to the correct values to display the correct
     * message
     * @param cipherVals The index values for alphabet values of the received, encrypted
     *                   message
     * @param nVals The index values that will reconvert the cipherVals to their
     *              original values
     * @return The corrected index that will be used to display the decrypted message
     ************************************************************************
     */
    public int[] nValuesRemoved(int[] nVals, int[] cipherVals){
        int size = cipherVals.length;
        int originalIndexN;
        int[] temp = new int[size];
        int j = 0;//In case cipher val is -500 to not increment nVals as well
        for(int i = 0; i < size; i++){
            if(cipherVals[i] != -500) {
                originalIndexN = cipherVals[i] - nVals[j];
                if (originalIndexN != -500 && originalIndexN < 0) {
                    originalIndexN += 26;
                }
                temp[i] = originalIndexN;
                j++;
            }
            else{temp[i] = -500;}
        }
        return temp;
    }

    /*
     *************************************************************************
     * MethodName: indexToCharArray
     * Purpose:
     ************************************************************************
     */
    public char[] indexToCharArray(int[] index){
        char[] temp = new char[index.length];
        for(int i = 0; i < index.length; i++){
            temp[i]  = OneTimePad.letterAtIndex(index[i]);
        }
        return temp;
    }

    /**
     *************************************************************************
     * MethodName: getKey
     * Purpose: Returns the int[] of the key
     * @return int[] of the key that was used to encrypt the message
     ************************************************************************
     */
    public int[] getKey() {
        return key;
    }

    /**
     *************************************************************************
     * MethodName: getOriginalIndex
     * Purpose:Returns the index of the original message
     * @return index of the original message
     ************************************************************************
     */
    public int[] getOriginalIndex() {
        return originalIndex;
    }



    /**
     *************************************************************************
     * MethodName: getEncryptedMessageAlpha
     * @return Returns the char[] that contains the altered indexed letters
     ************************************************************************
     */
    public char[] getEncryptedMessageAlpha() {
        return encryptedMessageAlpha;
    }

    public void printKey(){
        for(int k : key){
            if(k < 0){
                System.out.print(' ');
            }
            else {
                System.out.print(k + " ");
            }
        }
    }

    public void printEncryptedMessage(){
        for(int k : encryptedMessage){
            if(k < 0){
                System.out.print(' ');
            }
            else {
                System.out.print(k + " ");
            }
        }
    }

    /**
     * @return Returns the message as it was originally input (a String)
     */
    public String getOriginalMessage(){
        return originalMessage;
    }
}
