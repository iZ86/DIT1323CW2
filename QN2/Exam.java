import java.text.DecimalFormat;

public class Exam{
    private int studentID;
    private String studentName;
    private String studentLevel;  
    private double[] scores;
    
    public Exam() {
        studentID = 0;
        studentName = "Isaac";
        studentLevel = "Diploma";
        scores = new double[6];
    }

    public Exam(int sID, String n, String l, double[] scr) {
        this.studentID = sID;
        this.studentName = n;
        this.studentLevel = l;
        this.scores = scr;

    }

    public void setStudentID(int ID) {
        studentID = ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String n) {
        studentName = n;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentLevel(String l) {
        studentLevel = l;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setScores(double[] scr) {
        scores = scr;
    }

    public double getScores() {
        return scores[5];
    }

    public double totalScores() {
        double totalScore = 0;
        for(double score : scores) {
            totalScore += score;
        }
        return totalScore;

    }

    public double averageScores() {
     
        return totalScores() / 6;
    }

    public double getMax() {
        double maxScore = scores[0];
        for (double newScore : scores) {
        maxScore = Math.max(maxScore, newScore);
        }
        return maxScore;
    }   
    DecimalFormat df = new DecimalFormat("##.###");
    
    @Override
    public String toString() {
        return "Your Name: " + getStudentName() 
        + "\nYour Student ID: " + getStudentID() 
        + "\nYour Student Level:" + getStudentLevel() 
        + "\nYour Total Scores: " + df.format(totalScores())
        + "\nYour Average Score: " + df.format(averageScores())
        + "\nYour Maximum Score: " + getMax();
    }
                                                
}