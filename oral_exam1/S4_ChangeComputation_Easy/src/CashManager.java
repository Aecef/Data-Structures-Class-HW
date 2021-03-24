import java.util.Scanner;
/**@author alecc*/



public class CashManager {


    /**
     * MethodName: getChangeRequired
     * Purpose: Asks the user for the item price and the payment then returns the difference to later figure out
     * how much change is needed.
     * @return The difference of the Payment - the Item Price
     */
    public double getChangeRequired(){
        double item, paid = 0.00;
        Scanner price = new Scanner(System.in);

        System.out.println("\nItem Price: ");
        item = price.nextDouble();
        System.out.println("Amount Paid: ");
        paid = price.nextDouble();

        return paid - item;
    }


    /**
     *
     * @param changeNeeded Is the difference of the payment - the item price
     * @return The array of how much of each currency to give as change
     */
    public int[] giveChange(double changeNeeded){
        //       20 bill   10 bill   5 bill   1 bill   Quarter   Dime   Nickel   Penny
        //Index: 0         1         2        3        4         5       6       7
        int[] changeTypes = new int[8];

        //Checks how many 20s are needed
        int holder = (int) changeNeeded / 20;
        if(holder > 0){
            changeTypes[0] += holder;
            changeNeeded -= holder * 20;
        }
        //Checks how many 10s are needed
        holder = (int) changeNeeded / 10;
        if(holder > 0){
            changeTypes[1] += holder;
            changeNeeded -= holder * 10;
        }
        //Checks how many 5s are needed
        holder = (int) changeNeeded / 5;
        if(holder > 0){
            changeTypes[2] += holder;
            changeNeeded -= holder * 5;
        }
        //Checks how many 1s are needed
        holder = (int) changeNeeded;
        if(holder > 0){
            changeTypes[3] += holder;
            changeNeeded -= holder;
        }
        //Checks how many Quarters are needed
        holder = (int) (changeNeeded / 0.25);
        if(holder > 0){
            changeTypes[4] += holder;
            changeNeeded -= holder * 0.25;
        }
        //Checks how many Dimes are needed
        holder = (int) (changeNeeded / 0.10);
        if(holder > 0){
            changeTypes[5] += holder;
            changeNeeded -= holder * 0.10;
        }
        //Checks how many Nickels are needed
        holder = (int) (changeNeeded / 0.05);
        if(holder > 0){
            changeTypes[6] += holder;
            changeNeeded -= holder * 0.05;
        }
        //Checks how many Pennies are needed
        holder = (int) (changeNeeded / 0.0099);
        if(holder > 0){
            changeTypes[7] += holder;
        }
        return changeTypes;
    }
}
