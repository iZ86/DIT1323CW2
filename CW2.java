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
            String exchangeRateToMYRInString = "";
            String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String charactersAllowedInCurrency = ".012345679";
            double amountEntered = 0;
            double exchangeRateToMYR = 0;
            double currencyExchangeResult = 0;
            double adminRate = 0;
            double adminFee = 0;

            /* Validates the currency type inputted by user,
            because currency type can only be three letters from the alphabet.
             */
            while (currencyType.isBlank() || currencyType.length() != 3) {

                // Gets currency type from user.
                currencyType = JOptionPane.showInputDialog(null, "Please insert your currency type.");

                // To check if all the characters in CURRENCYTYPE is contained in APLHABETS.
                for (int i = 0; i < currencyType.length(); i++) {

                    // True if the ith character is in ALPHABETS. Otherwise, false.
                    boolean isAlphabet = false;

                    /* To compare if ith character in CURRENCYTYPE is in ALPHABETS,
                        regardless of case.
                         */
                    for (int j = 0; j < alphabets.length(); j++) {

                        if (currencyType.toUpperCase().charAt(i) == alphabets.charAt(j)) {

                            isAlphabet = true;
                            break;
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

            /* Validates the amount entered by user input,
            to prevent any special characters and prevent more than one
            decimal points.
             */
            while (amountEnteredInString.isBlank()) {

                // Gets amount entered in string by user.
                amountEnteredInString = JOptionPane.showInputDialog(null, "Your Currency chosen is: " + currencyType.toUpperCase() + "\nPlease insert the amount you wish to exchange.");

                // Tracks the number of decimal points that is in AMOUNTENTEREDINSTRING.
                int numberOfDecimalPoints = 0;

                /* Check if all the characters in AMOUNTENTEREDINSTRING,
                is contained in CHARACTERSALLOWEDINCURRENCY,
                 */
                for (int i = 0; i < amountEnteredInString.length(); i++) {

                    // True if the ith character is in CHARACTERSALLOWEDINCURRENCY. Otherwise, false.
                    boolean isCharacerAllowedInCurrency = false;


                    for (int j = 0; j < charactersAllowedInCurrency.length(); j++) {

                        // Checks if the ith character in AMOUNTENEREDINSTRING is in CHARACTERSALLOWEDINCURRENCY.
                        if (amountEnteredInString.charAt(i) == charactersAllowedInCurrency.charAt(j)) {

                            // Checks if the ith character in AMOUNTENTEREDINSTRING is a decimal point.
                            if (amountEnteredInString.charAt(i) == '.') {

                                // Increment NUMBEROFDECIMALPOINTS by 1.
                                numberOfDecimalPoints += 1;
                            }

                            isCharacerAllowedInCurrency = true;
                            break;
                        }
                    }

                    /* If the ith character is not contained in CHARACTERSALLOWEDINCURRENCY,
                    or If the AMOUNTENENTEREDINSTRING has more than one decimal points,
                    or If the AMOUNTENENTEREDINSTRING has more than 2 decimal places,
                    or If the AMOUNTENENTEREDINSTRING is only a decimal point with no value at the front,
                    prompt user for input again.
                    Otherwise, the user input will be taken.
                     */
                    if (!isCharacerAllowedInCurrency || numberOfDecimalPoints > 1
                            || (numberOfDecimalPoints == 1 && ((amountEnteredInString.length() - i) > 2))
                            || (numberOfDecimalPoints == 1 && (amountEnteredInString.length()) == 1)) {

                        // Reset the values for the loop.
                        amountEnteredInString = "";

                        break;
                    }
                }
            }

            // Parse AMOUNTENTEREDINSTRING from user input from data type String into data type Double.
            amountEntered = Double.parseDouble(amountEnteredInString);

            /* Validates the exchange rate (to MYR) from user input,
            to prevent any special characters and prevent more than one
            decimal points.
             */
            while (exchangeRateToMYRInString.isBlank()) {

                // Gets exchange rate to MYR from user input.
                exchangeRateToMYRInString = JOptionPane.showInputDialog(null, "Please insert the exchange rate (to MYR).");

                // Tracks the number of decimal points that is in EXCHANGERATETOMYRINSTRING.
                int numberOfDecimalPoints = 0;

                /* Check if all the characters in EXCHANGERATETOMYRINSTRING,
                is contained in CHARACTERSALLOWEDINCURRENCY,
                 */
                for (int i = 0; i < exchangeRateToMYRInString.length(); i++) {

                    // True if the ith character is in CHARACTERSALLOWEDINCURRENCY. Otherwise, false.
                    boolean isCharacerAllowedInCurrency = false;


                    for (int j = 0; j < charactersAllowedInCurrency.length(); j++) {

                        // Checks if the ith character in EXCHANGERATETOMYRINSTRING is in CHARACTERSALLOWEDINCURRENCY.
                        if (exchangeRateToMYRInString.charAt(i) == charactersAllowedInCurrency.charAt(j)) {

                            // Checks if the ith character in EXCHANGERATETOMYRINSTRING is a decimal point.
                            if (exchangeRateToMYRInString.charAt(i) == '.') {

                                // Increment NUMBEROFDECIMALPOINTS by 1.
                                numberOfDecimalPoints += 1;
                            }

                            isCharacerAllowedInCurrency = true;
                            break;
                        }
                    }

                    /* If the ith character is not contained in CHARACTERSALLOWEDINCURRENCY,
                    or If the EXCHANGERATETOMYRINSTRING has more than one decimal points,
                    or If the EXCHANGERATETOMYRINSTRING has more than 2 decimal places,
                    or If the EXCHANGERATETOMYRINSTRING is only a decimal point with no value at the front,
                    prompt user for input again.
                    Otherwise, the user input will be taken.
                     */
                    if (!isCharacerAllowedInCurrency || numberOfDecimalPoints > 1
                            || (numberOfDecimalPoints == 1 && ((exchangeRateToMYRInString.length() - i) > 2))
                            || (numberOfDecimalPoints == 1 && (exchangeRateToMYRInString.length()) == 1)) {

                        // Reset the values for the loop.
                        exchangeRateToMYRInString = "";

                        break;
                    }
                }

            }

            // Parse EXCHANGERATETOMYRINSTRING from user input from data type String into data type Double.
            exchangeRateToMYR = Double.parseDouble(exchangeRateToMYRInString);

            // TODO: Refine everything below here.

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
