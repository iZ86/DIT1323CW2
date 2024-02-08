
import java.text.DecimalFormat;
// TODO: Add comments.
// TODO: Maybe change the toString method.
// TODO: Maybe revaluate the scores variable and methods.
public class Exam {
    private int studentID;
    private String studentName;
    private String studentLevel;  
    private double[] scores;

    public Exam(int studentID, String studentName, String studentLevel, double[] scores) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentLevel = studentLevel;
        this.scores = scores;

    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public double[] getScores() {
        return scores;
    }

    public double calcTotalScores() {
        double totalScore = 0;
        for(double score : scores) {
            totalScore += score;
        }
        return totalScore;

    }

    public double calcAverageScores() {
     
        return calcTotalScores() / 6;
    }

    public double getMax() {
        double maxScore = scores[0];
        for (double newScore : scores) {
        maxScore = Math.max(maxScore, newScore);
        }
        return maxScore;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.###");
        return "Your Name: " + getStudentName()
                + "\nYour Student ID: " + getStudentID()
                + "\nYour Student Level:" + getStudentLevel()
                + "\nYour Total Scores: " + df.format(calcTotalScores())
                + "\nYour Average Score: " + df.format(calcAverageScores())
                + "\nYour Maximum Score: " + getMax();
    }

}
