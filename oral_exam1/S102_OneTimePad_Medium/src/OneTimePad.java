import java.util.Scanner;
//-500 will be considered a space (' ')
public class OneTimePad {
    private final static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J',
                                            'K','L', 'M','N','O','P','Q','R','S','T',
                                            'U','V','W','X','Y','Z'};

    /**
     *************************************************************************
     * MethodName: indexInAlpha
     * Purpose: If its a  space then this returns -1. Otherwise  this searches the
     * alphabet for the letter and returns the index.
     * @param letter Letter that will be looked up in the char[] alphabet
     * @return The index of the letter found. Other wise the value is marked
     *          as -500 to signify a "space"
     ************************************************************************
     */
    public static int indexInAlpha(char letter){
        int i = 0;
        if(letter == ' '){
            return -500;
        }
        for(char l : alphabet){
            if(l == letter){
                return i;
            }
            i++;
        }
        return -500;
    }

    /**
     *************************************************************************
     * MethodName: letterAtIndex
     * Purpose: If the index = -500 that means that the character is a space (' ').
     * Otherwise, this scans the alphabet array for the given index and returns that
     * character
     * @param index The index we want to see the letter of in the alphabet array
     * @return The char equivalent of the index in the alphabet array
     ************************************************************************
     */
    public static char letterAtIndex(int index){
        if(index < 0) {
            return ' ';
        }
        return alphabet[index];
    }

    /**
     *************************************************************************
     * MethodName: getAlphabet
     * Purpose: Returns the Uppercase of the alphabet
     * @return Uppercase char[] of the alphabet
     ************************************************************************
     */
    public static char[] getAlphabet() {
        return alphabet;
    }

    public static void main(String[] args) {
        Cipher encryption = new Cipher();
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter The Message You Would Like To Encrypt: ");
        encryption.createFinalEncryptionMessage(in.nextLine().toUpperCase());

        System.out.println("\n----ENCRYPTED MESSAGE----");
        for(char e : encryption.getEncryptedMessageAlpha()){
            System.out.print(e);
        }
        System.out.println();
        System.out.println();
        System.out.println("-----MESSAGE KEY-----");
        encryption.printKey();

    }






}
