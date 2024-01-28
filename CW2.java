/*
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 */
import java.text.DecimalFormat;

import javax.swing.*;

public class CW2 {
    // TODO: Proper semantics
    // TODO: Check if the rounding up is correct and if the rounding up method can be applied to this project.
    // TODO: Check if the math is correct.
    // TODO: Maybe some more design changes and read up the question more.
    public static void main(String[] args) {

        while (true) {

            // Initialization
            String currencyType = "";
            String amountEnteredInString = "";
            String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String charactersAllowedInCurrency = ".012345679";
            double amountEntered = 0;
            double exchangeRateToMYR = 0;
            double currencyExchangeResult = 0;
            double adminRate = 0;
            double adminFee = 0;

            /*Loops to get the currency type from user and validates if user entered valid input.
            If not, prompt user again.
             */
            while (currencyType.isBlank() || currencyType.length() != 3) {

                // Gets currency type from user.
                currencyType = JOptionPane.showInputDialog(null, "Please insert your currency type.");

                /* Loops to check if any characters in the user input,
                is contained in the ALPHABETS regardless of case,
                If it is not contained, prompts user to input again.
                Otherwise, proceed.
                 */
                for (int i = 0; i < 3; i++) {

                    // True if the ith character in CURRENCYTYPE is contained in ALPHABETS. Otherwise, false.
                    boolean isAlphabet = false;

                    // Loops to check if the characters in CURRENCYTYPE is contained in APLHABETS.
                    for (int j = 0; j < alphabets.length(); j++) {

                        // Checks if the ith character in CURRENCYTYPE is contained in ALPHABETS.
                        if (currencyType.toUpperCase().charAt(i) == alphabets.charAt(j)) {

                            // Set to true.
                            isAlphabet = true;
                        }

                    }

                    // if the ith character in CURRENCYTYPE is not contained in ALPHABETS, prompt user for new input.
                    if (!isAlphabet) {

                        // Reset value for the loop.
                        currencyType = "";

                        break;
                    }
                }
            }

            /* Get amount to be exchanged by user and validates if user entered valid input.
            If not, prompt user again.
             */
            while (amountEnteredInString.isBlank()) {

                // Gets amount entered in string by user.
                amountEnteredInString = JOptionPane.showInputDialog(null, "Your Currency chosen is: " + currencyType.toUpperCase() + "\nPlease insert the amount you wish to exchange.");

                // Tracks the number of full stops that is in AMOUNTENTEREDINSTRING.
                int numberOfFullStops = 0;

                /* Loops to check if the characters in AMOUNTENTEREDINSTRING,
                is contained in CHARACTERSALLOWEDINCURRENCY,
                If it is not contained, prompt user again.
                Otherwise, proceed.
                 */
                for (int i = 0; i < amountEnteredInString.length(); i++) {

                    // True if the ith character is in CHARACTERSALLOWEDINCURRENCY. Otherwise, false.
                    boolean isCharacerAllowedInCurrency = false;


                    for (int j = 0; j < charactersAllowedInCurrency.length(); j++) {

                        // Checks if the ith character in AMOUNTENEREDINSTRING is in CHARACTERSALLOWEDINCURRENCY.
                        if (amountEnteredInString.charAt(i) == charactersAllowedInCurrency.charAt(j)) {

                            // Checks if the ith character in AMOUNTENTEREDINSTRING is a full stop.
                            if (amountEnteredInString.charAt(i) == '.') {

                                // Increment NUMBEROFFULLSTOPS by 1.
                                numberOfFullStops += 1;
                            }

                            // Set to true.
                            isCharacerAllowedInCurrency = true;
                        }
                    }

                    /* If the ith character is not contained in CHARACTERSALLOWEDINCURRENCY,
                    or If the AMOUNTENENTEREDINSTRING has more than one full stops,
                    or If the AMOUNTENENTEREDINSTRING has more than 2 decimal places,
                    or If the AMOUNTENENTEREDINSTRING is only a full stop with no value at the front,
                    prompt user for input again.
                    Otherwise, the user input will be taken.
                     */
                    if (!isCharacerAllowedInCurrency || numberOfFullStops > 1
                            || (numberOfFullStops == 1 && ((amountEnteredInString.length() - i) > 2))
                            || (numberOfFullStops == 1 && (amountEnteredInString.length()) == 1)) {

                        // Reset the values for the loop.
                        amountEnteredInString = "";

                        break;
                    }
                }
            }

            // Parse user input from data type String into data type Double.
            amountEntered = Double.parseDouble(amountEnteredInString);

            // TODO: Refine everything below here.
            /* Get the exchange rate (to MYR) from user and validates if user entered valid input.
            If not, prompt user again.
             */
            while (exchangeRateToMYR <= 0) {
                exchangeRateToMYR = Float.parseFloat(JOptionPane.showInputDialog(null, "Please insert the exchange rate (to MYR)."));
                // TODO: Removed everything, to be refined.

            }

            // Calculates the result of the amount entered converted to MYR with the adminFee applied.
            currencyExchangeResult = (amountEntered * exchangeRateToMYR);

            // Rounds up to CUURRENCYEXCHANGERESULT to 2 decimal point.
            currencyExchangeResult = (float) (Math.round(currencyExchangeResult * 100) / 100.0);


            // Gets the admin rate.
            if (currencyExchangeResult <= 2000) {
                adminRate = 0.0025;
            }
            else if (currencyExchangeResult <= 5000){
                adminRate = 0.005;
            }
            else if(currencyExchangeResult <= 10000){
                adminRate = 0.0075;
            }
            else {
                adminRate = 0.01;
            }

            // Calculates the admin fee.
            adminFee = currencyExchangeResult * adminRate;

            // Rounds up ADMINFEE to 2 decimal points.
            adminFee = (float) ((Math.round(adminFee * 100)) / 100.0);

            // Applies admin fee to CURRENCYEXCHANGERESULT.
            currencyExchangeResult -= adminFee;

            DecimalFormat df = new DecimalFormat("###,###,###.##");
            JOptionPane.showMessageDialog(null, "Total amount exchanged is RM"+ df.format(currencyExchangeResult)  + "\n Your Admin Fee is: "+df.format(adminFee), "Result", JOptionPane.PLAIN_MESSAGE);
    }

        
    }
}
