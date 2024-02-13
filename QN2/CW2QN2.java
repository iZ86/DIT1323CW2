/**
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 */

import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        // Initialization.
        String studentID, studentName, studentLevel;
        int numberOfSubjects = 6;
        double[] scoresOfSubject;
        Scanner s = new Scanner(System.in);

        // Print header for the program.
        printHeader();

        // Get input from user.
        studentID = getStudentIDFromUser(s);
        studentName = getStudentNameFromUser(s);
        studentLevel = getStudentLevelFromUser(s);
        scoresOfSubject = getSubjectScoresFromUser(s, numberOfSubjects);

        // Close the scanner.
        s.close();

        // Initialize exam object with input from user.
        Exam e = new Exam(studentID, studentName, studentLevel, scoresOfSubject);

        // Output data.
        System.out.println(e);

    }

    /** Print CLI header of the program. */
    public static void printHeader() {
        System.out.println("********************************************");
        System.out.println("    Welcome to Sunway Education Group");
        System.out.println("    Please Enter Your Personal Info");
        System.out.println("********************************************");
    }

    /** Return studentID from user input after validation.
     * If invalid, prompt user for new studentID input.
     */
    public static String getStudentIDFromUser(Scanner s) {

        // Initialization.
        String studentID = "";

        // Makes sure that studentID is valid before returning.
        while (studentID.isBlank()) {
            System.out.println("Please Input Your Student ID");
            studentID = validateStudentID(s.nextLine());
            System.out.println("================================");
        }

        return studentID;
    }

    /** Return studentName from user input after validation.
     * If invalid, prompt user for new studentName input.
     */
    public static String getStudentNameFromUser(Scanner s) {

        // Initialization.
        String studentName = "";

        // Make sure that studentName is valid before returning.
        while (studentName.isBlank()) {
            System.out.println("Please input your name");
            studentName = validateStudentName(s.nextLine());
            System.out.println("================================");
        }

        return studentName;
    }

    /** Return studentLevel from user input after validation.
     * If invalid, prompt user for new studentLevel input.
     */
    public static String getStudentLevelFromUser(Scanner s) {

        // Initialization.
        String studentLevel = "";

        // Makes sure that studentLevel is valid before returning.
        while (studentLevel.isBlank()) {
            System.out.println("Please enter your student level.");
            studentLevel = validateStudentLevel(s.nextLine());
            System.out.println("==================================");

        }

        return studentLevel;
    }

    /** Return double[] scores for NUMBEROFSUBJECTS subjects from user input if valid.
     * Otherwise, prompt user for new score input.
     */
    public static double[] getSubjectScoresFromUser(Scanner s, int numberOfSubjects) {

        // Initialization
        double[] scores = new double[numberOfSubjects];

        // Prompt user for NUMBEROFSUBJECTS amount of scores.
        for (int i = 0; i < numberOfSubjects; i++) {

            String score = "";

            // Makes sure that score is valid before adding it to double[] scores.
            while (score.isBlank()) {
                System.out.println("Please Input Scores for Subject " + (i + 1) + ":");
                score = validateScore(s.nextLine());
                System.out.println("==================================");
            }

            // Change the datatype from String to double and add to double[] scores.
            scores[i] = Double.parseDouble(score);
        }

        return scores;
    }

    /** Return the given studentID if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentID(String studentID) {

        // studentID must not be blank or contain any special characters.
        return validateUserInput(studentID, isValidStudentID(studentID));
    }

    /** Return the given studentName if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentName(String studentName) {

        // studentName must not be blank or contain any special characters excluding whitespace or numbers.
        return validateUserInput(studentName, isValidStudentName(studentName));
    }

    /** Return the given studentLevel if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentLevel(String studentLevel) {

        // studentLevel must not be blank or contain any special characters excluding whitespace.
        return validateUserInput(studentLevel, isValidStudentLevel(studentLevel));
    }

    /** Return the given score if valid.
     * Otherwise, return empty string.
     */
    public static String validateScore(String score) {

        // score must not be blank or contain any special characters excluding decimal point or alphabets.
        return validateUserInput(score, isValidScore(score));
    }

    /** Return the String USERINPUT if boolean VALID is true.
     * Otherwise, print an invalid message and return an empty string.
     */
    public static String validateUserInput(String userInput, boolean valid) {
        if (!valid) {
            userInput = "";
            printInvalidUserInput();
        }
        return userInput;
    }

    /** Prints a message for an invalid user input. */
    public static void printInvalidUserInput() {
        System.out.println("Invalid input.");
    }

    /** Return true iff String studentID does not contain any special characters.
     * Otherwise, return false.
     */
    public static boolean isValidStudentID(String studentID) {

        // If studentID is blank.
        if (studentID.isBlank()) {
            return false;
        }

        for (int i = 0; i < studentID.length(); i++) {

            char character = studentID.charAt(i);

            // Return false if char character is a special character.
            if (!(isCharacterAlphabet(character)) && !(isCharacterNumber(character))) {
                return false;
            }
        }
        return true;
    }

    /** Return true iff String studentName does not contain any special characters excluding whitespace,
     * and does not contain numbers,
     * and there is no whitespace before first name.
     * and there is no whitespace after last name.
     * and there is no whitespace before or after another whitespace.
     * Otherwise, return false.
     */
    public static boolean isValidStudentName(String studentName) {

        // If studentName is blank.
        if (studentName.isBlank()) {
            return false;
        }

        for (int i = 0; i < studentName.length(); i++) {
            char character = studentName.charAt(i);

            // Return false if the character is a number or special character, excluding whitespace.
            if (!(isCharacterAlphabet(character)) && !(isCharacterWhiteSpace(character))) {
                return false;
            }

            if (isCharacterWhiteSpace(character)) {
                // Return false, if there is two white spaces next to each other.
                // Or, if there is white space in the beginning of the name.
                // Or, if there is white space after last name.
                if ((((i + 1) < studentName.length()) && (isCharacterWhiteSpace(studentName.charAt(i + 1))))
                        || (i == 0)
                        || (i == (studentName.length() - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Return true iff String studentLevel does not contain any special characters,
     * and there is no whitespace before first name.
     * and there is no whitespace after last name.
     * and there is no whitespace before or after another whitespace.
     * Otherwise, return false.
     */
    public static boolean isValidStudentLevel(String studentLevel) {

        // If studentLevel is blank.
        if (studentLevel.isBlank()) {
            return false;
        }

        for (int i = 0; i < studentLevel.length(); i++) {
            char character = studentLevel.charAt(i);

            // Return false if the character is a special character, excluding whitespace.
            if (!(isCharacterAlphabet(character)) && !(isCharacterNumber(character)) && !(isCharacterWhiteSpace(character))) {
                return false;
            }

            if (isCharacterWhiteSpace(character)) {
                // Return false, if there is two white spaces next to each other.
                // Or, if there is white space in the beginning of the name.
                // Or, if there is white space after last name.
                if ((((i + 1) < studentLevel.length()) && (isCharacterWhiteSpace(studentLevel.charAt(i + 1))))
                        || (i == 0)
                        || (i == (studentLevel.length() - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Return true iff String SCORE does not contain any special characters, excluding decimal point,
     * and does not contain any alphabets,
     * and does not contain more than one decimal point and more than two decimal place,
     * and the score must be between 0 and 100.
     * Otherwise, return false.
     */
    public static boolean isValidScore(String score) {

        if (score.isBlank()) {
            return false;
        }
        
        int numberOfDecimalPoint = 0;

        for (int i = 0; i < score.length(); i++) {
            char character = score.charAt(i);

            if (isCharacterDecimalPoint(character)) {
                numberOfDecimalPoint += 1;
            }

            /* Return false, if character is not a number or a decimal place,
            or if it has more than one decimal point,
            or if the whole score is just one decimal point,
            or if it has more than two decimal places.
             */
            if ((!isCharacterNumber(character) && !isCharacterDecimalPoint(character))
                    || numberOfDecimalPoint > 1
                    || (numberOfDecimalPoint == 1 && (score.length() == 1))
                    || (numberOfDecimalPoint == 1 && ((score.length() - i) > 3))) {
                return false;
            }
        }

        // subjectScore cannot be less than 0, or more than 100.
        double subjectScore = Double.parseDouble(score);
        if (subjectScore < 0 || subjectScore > 100) {
            return false;
        }
        return true;
    }



    /** Return true, iff char CHARACTER is a decimal point.
     * Otherwise, return false.
     */
    public static boolean isCharacterDecimalPoint(char character) {
        return (character == 46);
    }

    /** Return true, iff char CHARACTER is a whitespace.
     * Otherwise, return false.
     */
    public static boolean isCharacterWhiteSpace(char character) {
        return (character == 32);
    }

    /** Return true, iff char NUMBER iS a number.
     * Otherwise, return false.
     */
    public static boolean isCharacterNumber(char number) {
        return (number >= 48 && number <= 57);
    }

    /** Return true, iff char CHARACTER is an alphabet, regardless of case.
     * Otherwise, return false.
     */
    public static boolean isCharacterAlphabet(char character) {
        return ((character >= 65 && character <= 90) || (character >= 97 && character <= 122));
    }
}
