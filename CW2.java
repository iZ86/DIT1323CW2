/*
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 */
import javax.swing.*;

public class CW2 {
    // TODO: Proper semantics
    // TODO: Check if the rounding up is correct and if the rounding up method can be applied to this project.
    // TODO: Check if the math is correct.
    // TODO: Maybe some more design changes and read up the question more.
    public static void main(String[] args){
        while (true) {

            // Initialization
            String currencyType;
            float amountEntered, exchangeRateToMYR, currencyExchangeResult, adminRate, adminFee;

            // Setting starter values.
            currencyType = "";
            amountEntered = exchangeRateToMYR = currencyExchangeResult = adminRate = adminFee = 0;

            // Get currency type from user and validates if user entered valid input. If not, prompt user again.
            while (currencyType == "" || currencyType.length()!=3) {
                currencyType = JOptionPane.showInputDialog(null, "Please insert your currency type.");
                    if(currencyType == null){
                        System.exit(0);
                    }
                // TODO: Need to have a better validation.
                // TODO: Need to exit out of the program if user press cancel.
            }

            // Get amount to be exchanged by user and validates if user entered valid input. If not, prompt user again.
            while (amountEntered <= 0) {
                amountEntered = Float.parseFloat(JOptionPane.showInputDialog(null, "Your Currency chosen is: " + currencyType.toUpperCase() + "\nPlease insert the amount you wish to exchange."));
                // TODO: Need to have a better validation.
                // TODO: Need to exit out of the program if user press cancel.
                if(amountEntered == 0){
                    System.exit(0);
                }
            }

            // Get the exchange rate (to MYR) from user and validates if user entered valid input. If not, prompt user again.
            while (exchangeRateToMYR <= 0) {
                exchangeRateToMYR = Float.parseFloat(JOptionPane.showInputDialog(null,"Please insert the exchange rate (to MYR)."));
                // TODO: Need to have a better validation.
                // TODO: Need to exit out of the program if user press cancel.
                if(exchangeRateToMYR == 0){
                    System.exit(0);
                }
            }

            // Calculates the result of the amount entered converted to MYR with the adminFee applied.
            currencyExchangeResult = (amountEntered * exchangeRateToMYR);

            // Rounds up to CUURRENCYEXCHANGERESULT to 2 decimal point.
            currencyExchangeResult = (float) (Math.round(currencyExchangeResult * 100) / 100.0);


            // Gets the admin rate.
            if (currencyExchangeResult <= 2000){
                adminRate = 0.0025F;
            }
            else if (currencyExchangeResult <= 5000){
                adminRate = 0.005F;
            }
            else if(currencyExchangeResult <= 10000){
                adminRate = 0.0075F;
            }
            else {
                adminRate = 0.01F;
            }

            // Calculates the admin fee.
            adminFee = currencyExchangeResult * adminRate;

            // Rounds up ADMINFEE to 2 decimal points.
            adminFee = (float) ((Math.round(adminFee * 100)) / 100.0);

            // Applies admin fee to CURRENCYEXCHANGERESULT.
            currencyExchangeResult -= adminFee;


            JOptionPane.showMessageDialog(null, "Total amount exchanged is RM"+ currencyExchangeResult + "\n Your Admin Fee is: "+adminFee, "Result", JOptionPane.PLAIN_MESSAGE);
    }

        
    }
}
