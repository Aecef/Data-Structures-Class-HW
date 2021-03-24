/**author acleofe */
import java.util.Scanner;

public class MetricConversion {

    private String userInput;
    private Scanner in;

    //Collects the families of measurements
    private String[] weight = {"pound", "gram", "kilogram"} ;
    private String[] liquid = {"cup", "quart", "gallon", "ounce", "milliliter", "liter"};
    private String[] length = {"inch", "feet", "yard", "mile","centimeter", "meter", "kilometer"};

    //Collects the differing english measurements
    private String[] english = {"pound", "cup", "quart", "gallon", "ounce", "inch", "feet", "yard", "mile"};
    private String[] englishWeight = {"pound"};
    private String[] englishLiquid = {"cup", "quart", "gallon", "ounce"};
    private String[] englishLength = {"inch", "feet", "yard", "mile"};

    //Collects the differing metric measurements
    private String[] metric = {"gram", "kilogram", "milliliter", "liter", "centimeter", "meter", "kilometer"};
    private String[] metricWeight = {"gram", "kilogram"};
    private String[] metricLiquid = {"milliliter", "liter"};
    private String[] metricLength = {"centimeter", "meter", "kilometer"};

    private String[][] allArrays = {weight, length, liquid};
    private double convertedAmount, amount;
    private String[] foundWords = new String[2];
    private int[] indexes = new int[2];


    /**
     * MethodName: obtainInput
     * Purpose: Takes in the users next line of input. THis also obatins the number value of the amount the user
     * wants to be converted
     *
     */
    private void obtainInput(){
        in = new Scanner(System.in);
        this.userInput = in.nextLine().toLowerCase().replace('?', ' ').trim();
        for(String s : userInput.split(" ")){
            in = new Scanner(s);
            if(in.hasNextDouble()){
                amount = in.nextDouble();
            }
        }
    }

    /**
     * MethodName: actualConversion
     * Purpose: Determines which measurement the user wants to be converted. Depending on the type, the data will
     * be sent to corresponding static methods in UnitConversion in order to return the correct conversion value.
     * @return The final converted amount
     */
    private double actualConversion(){
        if(indexes[0] < indexes[1]){
            if(inMetric(foundWords[0])){
                if(inMetricLength(foundWords[0])){
                    convertedAmount = UnitConversion.metricToEnglishLength(foundWords[0], foundWords[1], amount);
                }
                else if(inMetricWeight(foundWords[0])){
                    convertedAmount = UnitConversion.metricToEnglishWeight(foundWords[0], foundWords[1], amount);
                }
                else if(inMetricLiquid(foundWords[0])){
                    convertedAmount = UnitConversion.metricToEnglishLiquid(foundWords[0], foundWords[1], amount);
                }
            }
            else if(inEnglish(foundWords[0])){
                if(inEnglishLength(foundWords[0])){
                    convertedAmount = UnitConversion.englishToMetricLength(foundWords[0], foundWords[1], amount);
                }
                if(inEnglishWeight(foundWords[0])){
                    convertedAmount = UnitConversion.englishToMetricWeight(foundWords[0], foundWords[1], amount);
                }
                if(inEnglishLiquid(foundWords[0])){
                    convertedAmount = UnitConversion.englishToMetricLiquid(foundWords[0], foundWords[1], amount);
                }
            }
        }
        else if(indexes[1] < indexes[0]){

            if(inMetricLength(foundWords[1])){
                convertedAmount = UnitConversion.metricToEnglishLength(foundWords[1], foundWords[0], amount);
            }
            else if(inMetricWeight(foundWords[1])){
                convertedAmount = UnitConversion.metricToEnglishWeight(foundWords[1], foundWords[0], amount);
            }
            else if(inMetricLiquid(foundWords[1])){
                convertedAmount = UnitConversion.metricToEnglishLiquid(foundWords[1], foundWords[0], amount);
            }
        }
        else if(inEnglish(foundWords[1])){
            if(inEnglishLength(foundWords[1])){
                convertedAmount = UnitConversion.englishToMetricLength(foundWords[1], foundWords[0], amount);
            }
            if(inEnglishWeight(foundWords[1])){
                convertedAmount = UnitConversion.englishToMetricWeight(foundWords[1], foundWords[0], amount);
            }
            if(inEnglishLiquid(foundWords[1])){
                convertedAmount = UnitConversion.englishToMetricLiquid(foundWords[1], foundWords[0], amount);
            }
        }

        return convertedAmount;
    }

    /**
     * MethodName: convert
     * Purpose: Is the method that implements the other private methods and allows it to be used within the test class.
     * This will also display the ending converted value.
     *
     */
    public void convert(){
        obtainInput();
        if(isCorrectConversion()){
            System.out.println(foundWords[1] + " -------> " + foundWords[0]);
            System.out.println(actualConversion() + " " + foundWords[0] + "(s)");
        }
        else{
            System.out.println(foundWords[1] + " -------> " + foundWords[0]);
            System.out.println("NOT A VALID CONVERSION");
        }
    }

    /**
     * MethodName: isCorrectConversion
     * Purpose: Checks whether or not the two words found within the request are contained with the same family of measurement
     * (liquid, weight, length).
     * @return True if the two metrics are within the same family, false if otherwise.
     */
    private boolean isCorrectConversion(){
        String[] words = userInput.split(" ");
        String[] chosenWords = new String[2];
        int i = -1;
        for(String word : words){
            word = word.replace("miles","mile").replace("ounces", "ounce").replace("es", "").replace("s", "").replace("foot", "feet");
            if((inMetric(word) || inEnglish(word))){
                try{
                    i++;
                    chosenWords[i] = word;
                    this.indexes[i] = this.userInput.indexOf(word);
                }catch (NullPointerException e){
                    System.out.println("Too Many Arguments!");
                }
            }
        }

        this.foundWords = chosenWords;
        return sameType(chosenWords[0], chosenWords[1]);
    }


    /**
     * @param m1 The first type of measurement found in the input.
     * @param m2 The second type of measurement found in the input.
     * @return True if
     */

    private boolean sameType(String m1, String m2){
        for(String[] array : this.allArrays){
            if(inArray(array, m1) && inArray(array, m2)){
                return true;
            }
        }
        return false;
    }


    /**
     * @param array The array that is being searched
     * @param word  The word that is being searched for within the array
     * @return True if the array contains the word, false if not
     */
    private boolean inArray(String[] array, String word){
        for(String w : array){
            if(w.equals(word)){
                return true;
            }
        }
        return false;
    }

    private boolean inMetric(String word){
        return inArray(this.metric, word);
    }
    private boolean inMetricLiquid(String word){
        return inArray(this.metricLiquid, word);
    }
    private boolean inMetricWeight(String word){
        return inArray(this.metricWeight, word);
    }
    private boolean inMetricLength(String word){
        return inArray(this.metricLength, word);
    }

    private boolean inEnglish(String word){
        return inArray(this.english, word);
    }
    private boolean inEnglishLiquid(String word){
        return inArray(this.englishLiquid, word);
    }
    private boolean inEnglishLength(String word){
        return inArray(this.englishLength, word);
    }
    private boolean inEnglishWeight(String word){
        return inArray(this.englishWeight, word);
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public String[] getFoundWords() {
        return foundWords;
    }
}