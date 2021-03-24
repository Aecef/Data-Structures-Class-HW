import java.math.*;
/**@author alecc*/
public class ChangeComputation {
    public static void main(String[] args) {
        CashManager change = new CashManager();
        float totalNeeded = (float)change.getChangeRequired();
        //Controls the case if the customer does not pay enough
        if(totalNeeded < 0){
            System.out.println("THE AMOUNT GIVEN IS INSUFFICIENT!\n" +
                    Math.abs(totalNeeded) + " IS STILL REQUIRED!");
        }
        else {
            //       20 bill   10 bill   5 bill   1 bill   Quarter   Dime   Nickel   Penny
            //Index: 0         1         2        3        4         5       6       7
            int[] changeType = change.giveChange(totalNeeded);

            //Will display total change that will need to be given
            System.out.println("----CHANGE TOTAL----");
            System.out.println(totalNeeded);

            //Section will display the amount of each bill given in change
            System.out.println("----CURRENCY TO USE----");
            System.out.println("20 Dollar Bill(s): " + changeType[0]);
            System.out.println("10 Dollar Bill(s): " + changeType[1]);
            System.out.println("5 Dollar Bill(s): " + changeType[2]);
            System.out.println("1 Dollar Bill(s): " + changeType[3]);
            System.out.println("Quarter(s): " + changeType[4]);
            System.out.println("Dime(s): " + changeType[5]);
            System.out.println("Nickel(s): " + changeType[6]);
            System.out.println("Penny(s): " + changeType[7]);
        }
    }
}
