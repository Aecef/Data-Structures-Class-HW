/**author acleofe */

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Converter extends JFrame {

    private final JTextField roman;
    private final JTextField arabic;
    private int romanChecker;

    private static final String[] basicRoman = new String[]{"M" ,"CM","D","CD","C","XC","L","XL","X","IX","V", "IV", "I"};
    private static final int[] basicArabic = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    private static final char[] basicRomanAccounted = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static final int[] basicArabicAccounted = new int[]{1000, 500, 100, 50, 10, 5, 1};

    Converter(){
        setLayout(new FlowLayout());
        setTitle("Arabic/Roman Converter");
        setLocation(600,350);
        setSize(500,110);
        setResizable(false);

        add(new Label("Arabic: "));

        inputHandlerA inputArabic = new inputHandlerA();
        inputHandlerR inputRoman = new inputHandlerR();

        arabic = new JTextField(10);
        add(arabic,BorderLayout.SOUTH);
        arabic.addKeyListener(inputArabic);

        add(new Label("Roman: "));

        roman = new JTextField(10);
        add(roman);
        roman.addKeyListener(inputRoman);
    }

    /**
     * ClassName: inputHandlerA
     * Purpose: Detects key inputs within the arabic box and changes the roman field depending on the input
     */
    private class inputHandlerA implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e){}

        @Override
        public void keyReleased(KeyEvent e) {
            if(!arabic.getText().isEmpty() && !arabic.getText().equals("")){
                if(Integer.parseInt(arabic.getText()) > 3999){ throw new IllegalArgumentException();}
                roman.setText(arabicToRoman(Integer.parseInt(arabic.getText())));
            }
        }
    }

    /**
     * ClassName: inputHandlerR
     * Purpose: Detects key inputs within the roman box and changes the arabic field depending on the input
     */
    private class inputHandlerR implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
            String rholder = roman.getText();
            String holder = romanToArabic(roman.getText());
            if(rholder.toUpperCase().equals(arabicToRoman(romanChecker))){
                arabic.setText(holder);
            }
            else{
                throw new IllegalArgumentException("Not A Valid Roman Numeral!");
            }

        }
    }


    /**
     * MethodName: romanToArabic
     * Purpose: Convert the Roman value input into the Arabic equivalent
     * @param roman The input within the roman textfield
     * @return The value of the roman in arabic as a String
     */
    private String romanToArabic(String roman){
        char[] romanS = roman.toUpperCase().toCharArray();
        String arabicNumS = "";
        int arabicNum = 0;

        int sLength = romanS.length;
        for(int i = 0; i < sLength; i++){
            if(romanS[i] == 'C' || romanS[i] == 'X' || romanS[i] == 'I'){
                if(romanS[i] == 'C'){
                    if((i+1) < sLength && romanS[i+1] == 'M'){
                        arabicNum += 900;
                        i += 1;
                    }
                    else if((i+1) < sLength && romanS[i+1] == 'D'){
                        arabicNum += 400;
                        i += 1;
                    }
                    else {
                        arabicNum += 100;
                    }
                }
                else if(romanS[i] == 'X'){
                    if((i+1) < sLength && romanS[i+1] == 'C'){
                        arabicNum += 90;
                        i += 1;
                    }
                    else if((i+1) < sLength && romanS[i+1] == 'L'){
                        arabicNum += 40;
                        i += 1;
                    }
                    else {
                        arabicNum += 10;
                    }
                }

                else if(romanS[i] == 'I'){
                    if((i+1) < sLength && romanS[i+1] == 'V'){
                        arabicNum += 4;
                        i += 1;
                    }
                    else if((i+1) < sLength && romanS[i+1] == 'X'){
                        arabicNum += 9;
                        i += 1;
                    }
                    else {
                        arabicNum += 1;
                    }
                }
            }
            else{
                int k = 0;
                for (char l : basicRomanAccounted) {
                    if (romanS[i] == l) {
                        arabicNum += basicArabicAccounted[k];
                    }
                    k++;
                }
            }
        }
        this.romanChecker = arabicNum;
        return arabicNumS + arabicNum;
    }


    /**
     * MethodName: arabicToRoman
     * Purpose: Convert the arabic value input into the roman equivalent
     * @param arabic The input within the arabic textfield
     * @return The value of int arabic as is roman equivalent as a String
     */
    private String arabicToRoman(int arabic){
        String roman = "";
        int i = 0;
        while(arabic > 0){
            if(arabic - basicArabic[i] >= 0){
                roman += basicRoman[i];
                arabic -= basicArabic[i];
            }
            else{
                i++;
            }
        }
        return roman;
    }
}
