import java.util.Scanner;
public class CW2QN2 {


 public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    System.out.println("Please Input Your Student ID");
    int id = s.nextInt();
    

    System.out.println("Please Input Your Name");
    s.nextLine();
    String studentName = s.nextLine();

    System.out.println("Please Input Your Study Level");
    String level = s.nextLine();

    double[] storeScores = new double[5];
    int size = storeScores.length;
    
    for(int i = 0; i < size; i++) {
        System.out.println("Please Input Scores for Subject " + (i+1) + ":");
        
        storeScores[i] = s.nextDouble();
    
    }
    s.close();

    Exam e = new Exam(id, studentName, level, storeScores);
    e.setStudentID(id);
    e.setStudentName(studentName);
    e.setStudentLevel(level);
    e.setScores(storeScores);

    System.out.println(e);

 }   
}
