/**
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 */


import java.text.DecimalFormat;
import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {

        while (true) {

            // Initialization
            String currencyType = "";
            String amountEnteredInString = "";
            String exchangeRateToMYRInString = "";
            String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String charactersAllowedInCurrency = ".0123456789";
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
                currencyType = JOptionPane.showInputDialog(null,
                        "Please insert the currency type you wish to exchange to MYR.\nE.g. USD.",
                        "Currency Exchange Application",
                        JOptionPane.QUESTION_MESSAGE);

                // To check if user did not press cancel.
                if (currencyType != null) {
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

                    // Prompt user that their input, is not valid.
                    if (currencyType.isBlank() || currencyType.length() != 3) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid currency type!\n-3 letters only.\n-E.g. USD, SGD.",
                                "Currency Exchange Application",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // User pressed cancel.
                    break;
                }
            }

            // User pressed cancel.
            if (currencyType == null) {
                break;
            }

            /* Validates the amount entered by user input,
            to prevent any special characters and prevent more than one
            decimal points.
             */
            while (amountEnteredInString.isBlank()) {

                // Gets amount entered in string by user.
                amountEnteredInString = JOptionPane.showInputDialog(null,
                        "Currency type chosen: " + currencyType.toUpperCase()
                                + "\nPlease insert the amount of the chosen currency that you wish to exchange to MYR. \nE.g. 1000, 1023.45.",
                        "Currency Exchange Application",
                        JOptionPane.QUESTION_MESSAGE);

                // To check if user did not press cancel.
                if (amountEnteredInString != null) {
                    // Tracks the number of decimal points that is in AMOUNTENTEREDINSTRING.
                    int numberOfDecimalPoints = 0;

                    /* Check if all the characters in AMOUNTENTEREDINSTRING,
                    is contained in CHARACTERSALLOWEDINCURRENCY,
                    */
                    for (int i = 0; i < amountEnteredInString.length(); i++) {

                        // True if the ith character is in CHARACTERSALLOWEDINCURRENCY. Otherwise, false.
                        boolean isCharacterAllowedInCurrency = false;


                        for (int j = 0; j < charactersAllowedInCurrency.length(); j++) {

                            // Checks if the ith character in AMOUNTENEREDINSTRING is in CHARACTERSALLOWEDINCURRENCY.
                            if (amountEnteredInString.charAt(i) == charactersAllowedInCurrency.charAt(j)) {

                                // Checks if the ith character in AMOUNTENTEREDINSTRING is a decimal point.
                                if (amountEnteredInString.charAt(i) == '.') {

                                    // Increment NUMBEROFDECIMALPOINTS by 1.
                                    numberOfDecimalPoints += 1;
                                }

                                isCharacterAllowedInCurrency = true;
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
                        if (!isCharacterAllowedInCurrency || numberOfDecimalPoints > 1
                                || (numberOfDecimalPoints == 1 && ((amountEnteredInString.length() - i) > 2))
                                || (numberOfDecimalPoints == 1 && (amountEnteredInString.length()) == 1)) {

                            // Reset the values for the loop.
                            amountEnteredInString = "";
                            break;
                        }
                    }

                    // Prompt user that their input is invalid.
                    if (amountEnteredInString.isBlank()) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid amount!\n-Must be >=0.\n-2 Decimal places or lesser.\n-No number separators (,).\n-E.g. 1000, 1023.45.",
                                "Currency Exchange Application",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // User pressed cancel.
                    break;
                }
            }

            // User pressed cancel.
            if (amountEnteredInString == null) {
                break;
            }

            // Parse AMOUNTENTEREDINSTRING from user input from data type String into data type Double.
            amountEntered = Double.parseDouble(amountEnteredInString);

            /* Validates the exchange rate (to MYR) from user input,
            to prevent any special characters and prevent more than one
            decimal points.
             */
            while (exchangeRateToMYRInString.isBlank()) {

                // Gets exchange rate to MYR from user input.
                exchangeRateToMYRInString = JOptionPane.showInputDialog(null, "Currency type chosen: "
                        + currencyType.toUpperCase()
                        + "\nPlease insert the exchange rate of the chosen currency to MYR.\nE.g. 3, 4.20.",
                        "Currency Exchange Application",
                        JOptionPane.QUESTION_MESSAGE);


                // To check if user did not press cancel.
                if (exchangeRateToMYRInString != null) {
                    // Tracks the number of decimal points that is in EXCHANGERATETOMYRINSTRING.
                    int numberOfDecimalPoints = 0;

                    /* Check if all the characters in EXCHANGERATETOMYRINSTRING,
                    is contained in CHARACTERSALLOWEDINCURRENCY,
                    */
                    for (int i = 0; i < exchangeRateToMYRInString.length(); i++) {

                        // True if the ith character is in CHARACTERSALLOWEDINCURRENCY. Otherwise, false.
                        boolean isCharacterAllowedInCurrency = false;


                        for (int j = 0; j < charactersAllowedInCurrency.length(); j++) {

                            // Checks if the ith character in EXCHANGERATETOMYRINSTRING is in CHARACTERSALLOWEDINCURRENCY.
                            if (exchangeRateToMYRInString.charAt(i) == charactersAllowedInCurrency.charAt(j)) {

                                // Checks if the ith character in EXCHANGERATETOMYRINSTRING is a decimal point.
                                if (exchangeRateToMYRInString.charAt(i) == '.') {

                                    // Increment NUMBEROFDECIMALPOINTS by 1.
                                    numberOfDecimalPoints += 1;
                                }

                                isCharacterAllowedInCurrency = true;
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
                        if (!isCharacterAllowedInCurrency || numberOfDecimalPoints > 1
                                || (numberOfDecimalPoints == 1 && ((exchangeRateToMYRInString.length() - i) > 2))
                                || (numberOfDecimalPoints == 1 && (exchangeRateToMYRInString.length()) == 1)) {

                            // Reset the values for the loop.
                            exchangeRateToMYRInString = "";
                            break;
                        }
                    }

                    // Prompts user if their input is invalid.
                    if (exchangeRateToMYRInString.isBlank()) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid exchange rate!\n-Must be >=0.\n-2 Decimal places or lesser.\n-No number separators (,).\n-E.g. 1000, 1023.45.",
                                "Currency Exchange Application",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // User pressed cancel.
                    break;
                }
            }

            // User pressed cancel.
            if (exchangeRateToMYRInString == null) {
                break;
            }

            // Parse EXCHANGERATETOMYRINSTRING from user input from data type String into data type Double.
            exchangeRateToMYR = Double.parseDouble(exchangeRateToMYRInString);

            // Calculates the result of currency exchange.
            currencyExchangeResult = (amountEntered * exchangeRateToMYR);

            // Gets the admin rate.
            if (currencyExchangeResult <= 2000) {
                adminRate = 0.0025;

            } else if (currencyExchangeResult <= 5000) {
                adminRate = 0.005;

            } else if (currencyExchangeResult <= 10000) {
                adminRate = 0.0075;

            } else {
                adminRate = 0.01;

            }

            // Calculates the admin fee.
            adminFee = currencyExchangeResult * adminRate;

            // Applies admin fee to CURRENCYEXCHANGERESULT.
            currencyExchangeResult -= adminFee;

            // Outputs exchange result.
            DecimalFormat df = new DecimalFormat("###,###,###.00");
            JOptionPane.showMessageDialog(null,
                    "Results\n------------\nCurrency type exchanged: " + currencyType.toUpperCase()
                            + "\nAdmin fee: RM" + df.format(adminFee)
                            + "\nTotal amount exchanged (admin fee applied): RM" + df.format(currencyExchangeResult),
                    "Currency Exchange Application", JOptionPane.PLAIN_MESSAGE);

            // Prompts user if they wish to exchange another type of currency.
            int continueExchange = JOptionPane.showConfirmDialog(null, "Do you wish do another exchange? ",
                    "Currency Exchange Application",
                    JOptionPane.YES_NO_OPTION);

            // If user presses "no" or "x", exit program.
            if (continueExchange == 1 || continueExchange == -1) {
                break;
            }
        }
    }
}
