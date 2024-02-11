import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        String studentID, studentName, studyLevel;
        int numberOfSubjects = 6;
        double[] scoresOfSubject;
        Scanner s = new Scanner(System.in);

        studentID = getStudentIDFromUser(s);
        studentName = getStudentNameFromUser(s);
        studyLevel = getStudyLevelFromUser(s);
        scoresOfSubject = getSubjectScoresFromUser(s, numberOfSubjects);

        s.close();

        Exam e = new Exam(studentID, studentName, studyLevel, scoresOfSubject);

        System.out.println(e);

    }

    /** Return studentID from user input after validation.
     * If invalid, prompt user for new studentID input.
     */
    public static String getStudentIDFromUser(Scanner s) {

        String studentID = "";

        // Validates studentID input of user.
        while (studentID.isBlank()) {
            System.out.println("Please Input Your Student ID");
            studentID = validateStudentID(s.nextLine());
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
        }

        return studentName;
    }

    /** Return studyLevel from user input after validation.
     * If invalid, prompt user for new studyLevel input.
     */
    public static String getStudyLevelFromUser(Scanner s) {

        String studyLevel = "";

        // Validates studyLevel input of user.
        while (studyLevel.isBlank()) {
            System.out.println("Please enter your study level.");
            studyLevel = validateStudyLevel(s.nextLine());

        }

        return studyLevel;
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
        return validateUserInput(studentID, !(isStringContainSpecialCharacters(studentID)));
    }

    /** Return the given studentName if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentName(String studentName) {

        // studentName must not contain any special characters or numbers.
        return validateUserInput(studentName, isStringContainAlphabetOnly(studentName));
    }

    /** Return the given studyLevel if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudyLevel(String studyLevel) {

        // studyLevel must not contain any special characters.
        return validateUserInput(studyLevel, !(isStringContainSpecialCharacters(studyLevel)));
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

    /** Return true iff String SCORE is a valid score.
     * Otherwise, return false.
     */
    public static boolean isValidScore(String score) {
        int numberOfDecimalPlaces = 0;

        for (int i = 0; i < score.length(); i++) {
            char character = score.charAt(i);

            if (isCharacterDecimalPoint(character)) {
                numberOfDecimalPlaces += 1;
            }

            /* Return false, if character is not a number and not a decimal place,
            or if it has more than one decimal places,
            or if the whole score is just one decimal place,
            or if it has more than 2 decimal place.
             */
            if ((!isCharacterNumber(character) && !isCharacterDecimalPoint(character))
                    || numberOfDecimalPlaces > 1
                    || (numberOfDecimalPlaces == 1 && (score.length() == 1))
                    || (numberOfDecimalPlaces == 1 && ((score.length() - i) > 3))) {
                return false;
            }
        }
        
        return true;
    }


    /** Return true iff every character in String STRING is an alphabet.
     * Otherwise, return false.
     */
    public static boolean isStringContainAlphabetOnly(String string) {

        for (int i = 0; i < string.length(); i++) {

            if (!(isCharacterAlphabet(string.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /** Return true iff every character in String STRING is a special character.
     *  Otherwise, return false.
     */
    public static boolean isStringContainSpecialCharacters(String string) {

        for (int i = 0; i < string.length(); i++) {

            if (!(isCharacterNumber(string.charAt(i)) || isCharacterAlphabet(string.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    /** Return true, iff char CHARACTER is a decimal point.
     * Otherwise, return false.
     */
    public static boolean isCharacterDecimalPoint(char character) {
        return character == 46;
    }

    /** Return true, iff char NUMBER iS a number.
     * Otherwise, return false.
     */
    public static boolean isCharacterNumber(char number) {
        if (number >= 48 && number <= 57) {
            return true;
        }
        return false;
    }

    /** Return true, iff char CHARACTER is an alphabet, regardless of case.
     * Otherwise, return false.
     */
    public static boolean isCharacterAlphabet(char character) {
        if ((character >= 65 && character <= 90)
                || (character >= 97 && character <= 122)) {
            return true;
        }
        return false;
    }
}
