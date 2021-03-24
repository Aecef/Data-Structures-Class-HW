
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
/**@author alecc */

/**
 * @see JFrame
 * */
public class NumberFrame extends JFrame {
    private final JTextField guess;// Field Where player will input guess
    private final JButton button;//General Guess Input Button
    private final JButton again;//The Restart Button
    private final JLabel label;

    private JLabel correct;//Display If Guess Is Correct
    private JLabel low;//Display If Guess Is Too Low
    private JLabel high;//Display If Guess Is Too High

    private int previousDiff = 0;//The distance the previous guess was to the actual number
    private  int currentDiff = 0;//The distance the current guess was to the actual number
    private String guessText;//Text Input by the player
    private int guessInt;//Text Input converted to an int
    private int randNum;//Number that player will try to guess

    //GUI Generation
    public NumberFrame(){

        setLayout(new FlowLayout());
        setLocation(600,350);
        setSize(500,110);
        setResizable(false);

        randNum = generateRandNum();
        System.out.println(randNum);

        label = new JLabel("<html>I have a number between 1-1000. Can you guess my number?<br> Please enter your guess.</html>");
        add(label);

        guess = new JTextField(10);
        add(guess);

        button = new JButton("Enter");
        add(button,BorderLayout.SOUTH);


        correct = new JLabel("THATS THE RIGHT NUMBER!");
        add(correct);
        correct.setVisible(false);

        high = new JLabel("TOO HIGH!");
        add(high);
        high.setVisible(false);

        low = new JLabel("TOO LOW!");
        add(low);
        low.setVisible(false);

        again = new JButton("Play again?");
        add(again, BorderLayout.SOUTH);
        again.setVisible(false);

        GuessHandler bHandler = new GuessHandler();
        button.addActionListener(bHandler);

        restartHandler againHandler = new restartHandler();
        again.addActionListener(againHandler);


    }


    /**
     * @param result Take in the value of -1, 0 , or 1 to know whether the
     *               guess was low, correct, or high and makes that label
     *               visible
     * */
    public void makeVisible(int result){
        //Lets player know if they are correct and make the play again button visible
        //Also where guess text field is made uneditable
        if (result == 0){
            guess.setBackground(Color.GREEN);
            correct.setVisible(true);
            guess.setEditable(false);
            again.setVisible(true);
        }
        //Below if statements display "TOO HIGH" or "TOO LOW"
        else if(result > 0){
            high.setVisible(true);
        }
        else{
            low.setVisible(true);
        }
    }

    /**
     * MethodName: checkDiff
     * Purpose: Checks how far the player was on their current guess, from the correct answer,
     * vs their previous guess and sets the color to blue if closer, red if farther, and green
     * if they are the same distance away.
     * */
    public void checkDiff(){
        currentDiff = Math.abs(randNum - guessInt);
        if(currentDiff > previousDiff){
            guess.setBackground(Color.BLUE);
            guess.setForeground(Color.WHITE);
        }
        else if(currentDiff < previousDiff){
            guess.setBackground(Color.RED);
            guess.setForeground(Color.WHITE);
        }
        else{
            guess.setBackground(Color.GREEN);
            guess.setForeground(Color.BLACK);
        }
        previousDiff = currentDiff;
    }

    /**
     * ClassName: restartHandler
     * Purpose: Used to handle the button action event of the Restart button and resets the values needed to restart
     * the game
     * @see ActionListener
     *
     * */
    private class restartHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent playAgain) {
            again.setVisible(false);
            correct.setVisible(false);
            guess.setBackground(Color.WHITE);
            guess.setForeground(Color.BLACK);
            guess.setEditable(true);
            randNum = generateRandNum();
            System.out.println(randNum);
        }
    }

    /**
     * ClassName: restartHandler
     * Purpose: Used to handle the button action event of the players guess being input. Depending if the
     * guess is higher, lower, or equal the display will change.
     * @see ActionListener
     *
     * */
    private class GuessHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            high.setVisible(false);
            correct.setVisible(false);
            low.setVisible(false);

            guessText = guess.getText();
            guessInt = Integer.parseInt(guessText);

            checkDiff();
            if(guessInt == randNum){
               makeVisible(0);
            }
            else if(guessInt > randNum){

                makeVisible(1);

            }
            else if(guessInt < randNum){
                makeVisible(-1);
            }
            guess.setText("");
        }
    }

    /**
     * @return The number player will need  to guess and is between 1-1000
     * */
    public int generateRandNum(){
        SecureRandom random = new SecureRandom();
        this.randNum = random.nextInt(1000) + 1;
        return this.randNum;
    }

    /**
     * @return Text the player input as their guess
     * */
    public String getGuessText() {
        return guessText;
    }

}

