import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        String studentID, studentName, studyLevel;
        double[] scoresOfSubject = new double[6];
        int numberOfSubjects = scoresOfSubject.length;
        Scanner s = new Scanner(System.in);

        studentID = getStudentIDFromUser(s);
        studentName = getStudentNameFromUser(s);
        studyLevel = getStudyLevelFromUser(s);


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

    /** Return true, iff char character is '.'.
     * Otherwise, return false.
     */

    public static boolean isCharacterDecimalPoint(char character) {
        return (character == 46);
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
