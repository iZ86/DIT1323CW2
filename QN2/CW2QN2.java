import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        String studentID, studentName, studyLevel;
        double[] scoresOfSubject = new double[6];
        int numberOfSubjects = scoresOfSubject.length;
        Scanner s = new Scanner(System.in);

        studentID = getStudentIDFromUserInput(s);
        studentName = getStudentNameFromUserInput(s);
        studyLevel = getStudyLevelFromUserInput(s);


        boolean j = true;
        while (j) {
            j = false;
            for (int i = 0; i < numberOfSubjects; i++) {
                System.out.println("Please Input Scores for Subject " + (i + 1) + ":");

                scoresOfSubject[i] = s.nextDouble();

                for (double scores : scoresOfSubject) {
                    if (scoresOfSubject[i] <= 0 || scoresOfSubject[i] > 100 || String.valueOf(scores).matches(".*[A-Za-z].*")) {
                        j = true;

                    }
                }
            }
        }

        s.close();

        Exam e = new Exam(studentID, studentName, studyLevel, scoresOfSubject);

        System.out.println(e);

    }

    /** Return studentID from user input after validation.
     * If invalid, prompt user for new studentID input.
     */
    public static String getStudentIDFromUserInput(Scanner s) {

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
    public static String getStudentNameFromUserInput(Scanner s) {

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
    public static String getStudyLevelFromUserInput(Scanner s) {

        String studyLevel = "";

        // Validates studyLevel input of user.
        while (studyLevel.isBlank()) {
            System.out.println("Please enter your study level.");
            studyLevel = validateStudyLevel(s.nextLine());

        }

        return studyLevel;
    }

    /** Return the given studentID if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentID(String studentID) {
        if (isStringContainSpecialCharacters(studentID)) {
            studentID = "";
            printInvalidUserInput();
        }
        return studentID;
    }

    /** Return the given studentName if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudentName(String studentName) {
        if (!(isStringContainAlphabetOnly(studentName))) {
            studentName = "";
            printInvalidUserInput();
        }
        return studentName;
    }

    /** Return the given studyLevel if valid.
     * Otherwise, return empty string.
     */
    public static String validateStudyLevel(String studyLevel) {
        if (isStringContainSpecialCharacters(studyLevel)) {
            studyLevel = "";
            printInvalidUserInput();
        }
        return studyLevel;
    }

    /** Prints a message for an invalid user input. */
    public static void printInvalidUserInput() {
        System.out.println("Invalid input.");
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

    /** Return true, iff char number is part of base 10 numbers.
     * Otherwise, return false.
     */
    public static boolean isCharacterNumber(char number) {
        if (number >= 48 && number <= 57) {
            return true;
        }
        return false;
    }

    /** Return true, iff char character is part of the english alphabet, regardless of case.
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
