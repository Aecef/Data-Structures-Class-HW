import java.util.Scanner;
//-500 refers to a space
public class Decrypt extends OneTimePad {

    public static void main(String[] args) {

        //Takes in the Cipher text
        Cipher nValueHelper = new Cipher();
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter The Cipher Text:");
        char[] cipherText = in.nextLine().toUpperCase().toCharArray();

        //Take in the N-values
        int[] cipherTextIndexes = nValueHelper.indexOfMessage(cipherText);
        System.out.println("Please Enter Corresponding The N-Values[EX: 2 1 3 45 6]: ");
        String nValues = in.nextLine();
        int[] finalNValues = nValueHelper.obtainNValues(nValues);


        //Converts cipher text to original message using the given n-values
        int[] originalMessIndex = nValueHelper.nValuesRemoved(finalNValues, cipherTextIndexes);
        char[] originalMessage = nValueHelper.indexToCharArray(originalMessIndex);

        System.out.println();
        System.out.println("---------------YOUR MESSAGE--------------");
        for(char k : originalMessage){
            System.out.print(k);
        }


    }
}
