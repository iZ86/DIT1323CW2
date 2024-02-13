/**
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 */

import java.text.DecimalFormat;

public class Exam {
    /** Student ID. */
    private String studentID;
    /** Student Name. */
    private String studentName;
    /** Student level. */
    private String studentLevel;
    /** Subject scores of student. */
    private double[] scores;

    /** A new exam object with 6 subject scores. */
    public Exam(String studentID, String studentName, String studentLevel, double[] scores) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentLevel = studentLevel;
        this.scores = scores;

    }

    /** Set new String studentID. */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /** Return String studentID. */
    public String getStudentID() {
        return studentID;
    }

    /** Set new String studentName. */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /** Return String studentName. */
    public String getStudentName() {
        return studentName;
    }

    /** Set new String studentLevel. */
    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    /** Return String studentLevel. */
    public String getStudentLevel() {
        return studentLevel;
    }

    /** Set new double[] scores. */
    public void setScores(double[] scores) {
        this.scores = scores;
    }

    /** Return double[] scores. */
    public double[] getScores() {
        return scores;
    }
    

    /** Return total score.*/
    public double calcTotalScores() {
        double totalScore = 0;
        for (double score : scores) {
            totalScore += score;
        }
        return totalScore;

    }

    /** Return average score. */
    public double calcAverageScores() {
     
        return calcTotalScores() / 6;
    }

    /** Return max score. */
    public double getMax() {

        double maxScore = 0;
        for (double score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.###");
        return "\n\n       Summary Report Only For You" 
                + "\n===========================================\n"
                + "  Your Name: " + getStudentName()
                + "\n  Your Student ID: " + getStudentID()
                + "\n  Your Student Level:" + getStudentLevel()
                + "\n  Your 1st Subject Score is: "  + scores[0]
                + "\n  Your 2nd Subject Score is: "  + scores[1]
                + "\n  Your 3rd Subject Score is: "  + scores[2]
                + "\n  Your 4th Subject Score is: "  + scores[3]
                + "\n  Your 5th Subject Score is: "  + scores[4]
                + "\n  Your 6th Subject Score is: "  + scores[5]
                + "\n==========================================="
                + "\n  Your Total Scores: " + df.format(calcTotalScores())
                + "\n  Your Average Score: " + df.format(calcAverageScores())
                + "\n  Your Maximum Score: " + getMax()
                + "\n===========================================";
    }

}
