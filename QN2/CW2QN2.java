import java.util.Scanner;

public class CW2QN2 {


    public static void main(String[] args) {

        String studentID = "";
        String studentName = "";
        String studyLevel = "";
        Scanner s = new Scanner(System.in);

        // Validates studentID input of user.
        while (studentID.isBlank()) {
            System.out.println("Please Input Your Student ID");
            studentID = s.nextLine();

            // Validates every character of studentID.
            for (int i = 0; i < studentID.length(); i++) {

                boolean isValidStudentIDCharacter = false;

                // Set isValidStudentIDCharacter to true, if the ith character of studentID is a number or an alphabet.
                if (isCharacterAlphabet(studentID.charAt(i)) || isCharacterNumber(studentID.charAt(i))) {

                    isValidStudentIDCharacter = true;
                }

                // If not valid character set to false, and prompt user for input again.
                if (!(isValidStudentIDCharacter)) {
                    System.out.println("Invalid character.");
                    studentID = "";
                    break;
                }
            }
        }

        // Validates studentName input of user.
        while (studentName.isBlank()) {
            System.out.println("Please Input Your Name");
            studentName = s.nextLine();

            // Validates every character of studentName.
            for (int i = 0; i < studentName.length(); i++) {

                boolean isValidStudentNameCharacter = false;

                // Set isValidStudentNameCharacter to true, if the ith character of studentName is an alphabet.
                if (isCharacterAlphabet(studentName.charAt(i))) {

                    isValidStudentNameCharacter = true;
                }

                // If not valid character set to false, and prompt user for input again.
                if (!(isValidStudentNameCharacter)) {
                    System.out.println("Invalid character.");
                    studentName = "";
                    break;
                }

            }
        }

        // Validates studyLevel input of user.
        while (studyLevel.isBlank()) {
            System.out.println("Please Input Your Study Level");
            studyLevel = s.nextLine();

            // Validates every character of studyLevel.
            for (int i = 0; i < studyLevel.length(); i++) {

                boolean isValidStudyLevelCharacter = false;

                // Set isValidStudyLevelCharacter to true, if the ith character of studyLevel is a number or an alphabet.
                if (isCharacterAlphabet(studyLevel.charAt(i)) || isCharacterNumber(studyLevel.charAt(i))) {

                    isValidStudyLevelCharacter = true;
                }

                // If not valid character set to false, and prompt user for input again.
                if (!(isValidStudyLevelCharacter)) {
                    System.out.println("Invalid character.");
                    studyLevel = "";
                    break;
                }

            }
        }


        String level = s.nextLine();

        double[] storeScores = new double[5];
        int size = storeScores.length;

        boolean j = true;
        while (j) {
            j = false;
            for (int i = 0; i < size; i++) {
                System.out.println("Please Input Scores for Subject " + (i + 1) + ":");

                storeScores[i] = s.nextDouble();

                for (double scores : storeScores) {
                    if (storeScores[i] <= 0 || storeScores[i] > 100 || String.valueOf(scores).matches(".*[A-Za-z].*")) {
                        j = true;

                    }
                }
            }
        }

        s.close();

        Exam e = new Exam(studentID, studentName, level, storeScores);

        System.out.println(e);

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
