import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        String studentID, studentName, studentLevel;
        int numberOfSubjects = 6;
        double[] scoresOfSubject;
        Scanner s = new Scanner(System.in);

        studentID = getStudentIDFromUser(s);
        studentName = getStudentNameFromUser(s);
        studentLevel = getStudentLevelFromUser(s);
        scoresOfSubject = getSubjectScoresFromUser(s, numberOfSubjects);

        s.close();

        Exam e = new Exam(studentID, studentName, studentLevel, scoresOfSubject);

        System.out.println(e);

    }

    /** Return studentID from user input after validation.
     * If invalid, prompt user for new studentID input.
     */
    public static String getStudentIDFromUser(Scanner s) {

        String studentID = "";
        System.out.println("********************************************");
        System.out.println("    Welcome to Sunway Education Group");
        System.out.println("    Please Enter Your Personal Info");
        System.out.println("********************************************");

        // Validates studentID input of user.
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

        String studentName = "";

        // Validates studentName input of user.
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

        String studentLevel = "";

        // Validates studentLevel input of user.
        while (studentLevel.isBlank()) {
            System.out.println("Please enter your study level.");
            studentLevel = validateStudentLevel(s.nextLine());
            System.out.println("==================================");

        }

        return studentLevel;
    }

    /** Return the scores for NUMBEROFSUBJECTS subjects from user input if valid.
     * Otherwise, prompt user for new score input.
     */
    public static double[] getSubjectScoresFromUser(Scanner s, int numberOfSubjects) {

        double[] subjectScores = new double[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {

            String score = "";

            while (score.isBlank()) {
                System.out.println("Please Input Scores for Subject " + (i + 1) + ":");
                score = validateScore(s.nextLine());
                System.out.println("==================================");
            }

            subjectScores[i] = Double.parseDouble(score);
        }

        return subjectScores;
    }

    /** Return the given studentID if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentID(String studentID) {

        // studentID must not contain any special characters.
        return validateUserInput(studentID, isValidStudentID(studentID));
    }

    /** Return the given studentName if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentName(String studentName) {

        // studentName must not contain any special characters or numbers.
        return validateUserInput(studentName, isValidStudentName(studentName));
    }

    /** Return the given studentLevel if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentLevel(String studentLevel) {

        // studentLevel must not contain any special characters.
        return validateUserInput(studentLevel, isValidStudentLevel(studentLevel));
    }

    /** Return the given score if valid.
     * Otherwise, return empty string.
     */
    public static String validateScore(String score) {

        // score must only contain
        return validateUserInput(score, isValidScore(score));
    }

    /** Return the String USERINPUT if boolean VALID is true.
     * Otherwise, return an empty string.
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

        for (int i = 0; i < studentID.length(); i++) {
            char character = studentID.charAt(i);

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

    /** Return true iff String SCORE is a valid score.
     * Otherwise, return false.
     */
    public static boolean isValidScore(String score) {
        int numberOfDecimalPoint = 0;

        for (int i = 0; i < score.length(); i++) {
            char character = score.charAt(i);

            if (isCharacterDecimalPoint(character)) {
                numberOfDecimalPoint += 1;
            }

            /* Return false, if character is not a number or a decimal place,
            or if it has more than one decimal point,
            or if the whole score is just one decimal point,
            or if it has more than 2 decimal places.
             */
            if ((!isCharacterNumber(character) && !isCharacterDecimalPoint(character))
                    || numberOfDecimalPoint > 1
                    || (numberOfDecimalPoint == 1 && (score.length() == 1))
                    || (numberOfDecimalPoint == 1 && ((score.length() - i) > 3))) {
                return false;
            }
        }

        // subjectScore cannot be less than 0, or more than 100.
        Double subjectScore = Double.parseDouble(score);
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
